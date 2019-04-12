package com.example.elite.telephonereport;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MerchantLoginActivity extends AppCompatActivity {

    private EditText username,password;
    private Button login;
    public final int success = 1;//登陆成功
    public final int password_error = 2;//密码错误
    public final int no_shop = 3;//用户不存在
    //处理子线程向主线程传递的数据
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what)
            {
                case success://成功就跳转界面
                    Intent intent = new Intent(MerchantLoginActivity.this,HelloActivity.class);
                    startActivity(intent);break;
                case no_shop://用户不存在
                    Toast.makeText(MerchantLoginActivity.this,"user does not exist",Toast.LENGTH_SHORT).show();
                    password.setText("");
                    username.setText("");
                    break;
                case password_error://密码错误
                    Toast.makeText(MerchantLoginActivity.this,"Password error",Toast.LENGTH_SHORT).show();
                    username.setText("");
                    password.setText("");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_login);

        username = findViewById(R.id.shop_login_username);
        password = findViewById(R.id.shop_login_password);
        login = findViewById(R.id.shop_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username.getText().toString().equals("")&&!password.getText().toString().equals(""))
                {
                    //向数据库传递用户名和密码，判断是否正确
                    sendInfo();
                }
                else
                {
                    //username和password不能为空
                    Toast.makeText(MerchantLoginActivity.this,"Username and password cannot be empty",Toast.LENGTH_SHORT).show();
                    username.setText("");
                    password.setText("");
                }
            }
        });
    }

    private void sendInfo()
    {
        //新开一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;//连接
                BufferedReader reader = null;
                try
                {
                    URL url = new URL("http://10.242.39.104:8080/shopSignIn");//地址
                    connection = (HttpURLConnection) url.openConnection();//打开连接
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setRequestMethod("POST");//post传输方式
                    connection.connect();
                    OutputStream out = connection.getOutputStream();//输出流
                    String paramsString = "name="+username.getText().toString()+"&pass="+password.getText().toString();//传递用户名和密码
                    out.write(paramsString.getBytes());
                    out.flush();
                    out.close();//关闭

                    InputStream in = connection.getInputStream();//返回流
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer respond = new StringBuffer();
                    String line;
                    //读取数据
                    while((line = reader.readLine())!=null)
                    {
                        respond.append(line);
                    }
                    //处理JSON数据
                    JSONObject jsonObject = new JSONObject(respond.toString());
                    //获得results的值
                    String result = jsonObject.getString("results");
                    Message msg = new Message();
                    if(result.equals("success"))
                    {
                        msg.what=success;
                        handler.sendMessage(msg);
                    }
                    else if(result.equals("no_shop"))
                    {
                        msg.what=no_shop;
                        handler.sendMessage(msg);
                    }
                    else
                    {
                        msg.what=password_error;
                        handler.sendMessage(msg);
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }finally {
                    if(reader != null)
                    {
                        try
                        {
                            reader.close();
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if(connection != null)
                    {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
}
