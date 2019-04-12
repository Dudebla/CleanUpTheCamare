package com.example.elite.telephonereport;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
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

public class AdminSignUpActivity extends AppCompatActivity {

    private EditText username,password;
    private Button signup;
    public final int business_conflict = 1;//用户已存在
    public final int success = 2;//成功
    //成功后的弹框
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    //处理子线程向主线程传递的数据
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what)
            {
                case success://成功，弹框提示
                    builder = new AlertDialog.Builder(AdminSignUpActivity.this);
                    alert = builder.setMessage("sign up was successful")
                            .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AdminSignUpActivity.this.finish();
                        }
                    }).setCancelable(false).create();
                    alert.show();
                    break;
                case business_conflict://用户已存在
                    Toast.makeText(AdminSignUpActivity.this,"User already exists",Toast.LENGTH_SHORT).show();
                    username.setText("");
                    password.setText("");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        username = findViewById(R.id.admin_signup_username);
        password = findViewById(R.id.admin_signup_password);
        signup = findViewById(R.id.admin_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username.getText().toString().equals("")&&!password.getText().toString().equals(""))
                {
                    //向数据库传递用户名和密码
                    sendInfo();
                }
                else
                {
                    //username和password不能为空
                    Toast.makeText(AdminSignUpActivity.this,"Username and password cannot be empty",Toast.LENGTH_SHORT).show();
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
                try {
                    URL url = new URL("http://10.242.39.104:8080/businessSignUp");//地址
                    connection = (HttpURLConnection) url.openConnection();//打开
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setRequestMethod("POST");
                    connection.connect();
                    OutputStream out = connection.getOutputStream();//输出流
                    String paramsString = "name=" + username.getText().toString() + "&pass=" + password.getText().toString();//传递用户名和密码
                    out.write(paramsString.getBytes());
                    out.flush();
                    out.close();//关闭

                    InputStream in = connection.getInputStream();//返回流
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer respond = new StringBuffer();
                    String line;
                    //获取数据
                    while ((line = reader.readLine()) != null) {
                        respond.append(line);
                    }
                    //转化为JSON格式
                    JSONObject jsonObject = new JSONObject(respond.toString());
                    //获取results的值
                    String result = jsonObject.getString("results");
                    Message msg = new Message();
                    if (result.equals("success")) {
                        msg.what = success;
                        handler.sendMessage(msg);
                    } else {
                        msg.what = business_conflict;
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
