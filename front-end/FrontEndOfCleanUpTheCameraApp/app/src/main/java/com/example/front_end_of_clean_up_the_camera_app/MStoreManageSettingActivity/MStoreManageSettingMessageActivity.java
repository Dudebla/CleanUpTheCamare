package com.example.front_end_of_clean_up_the_camera_app.MStoreManageSettingActivity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.front_end_of_clean_up_the_camera_app.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MStoreManageSettingMessageActivity extends AppCompatActivity {

    //页卡适配器
    private PagerAdapter adapter;

    private String IP = "54.37.47.153";

    @BindView(R.id.tv_mStoreManageSettingCancle)
    TextView tv_cancle;

    @BindView(R.id.et_mStoreManageSettingMessage)
    TextView et_message;

    @BindView(R.id.btn_mStoreManageSettingSave)
    Button btn_save;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mstore_manage_reset_message);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        //绑定
        ButterKnife.bind(this);


        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//返回
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingDetailMessage();

            }
        });




    }

    //  send machant detail message
    private void settingDetailMessage(){
        //  create new thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try{
                    String urlString = "http://" + IP + ":8080/settingDetialMessage";
                    URL url = new URL(urlString);
                    connection = (HttpURLConnection)url.openConnection();
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.connect();

                    //发送商家地址信息
                    OutputStream outputStream = connection.getOutputStream();
                    String setDetialMsg = "et_message=" + et_message.getText().toString() ;
                    outputStream.write(setDetialMsg.getBytes());
                    outputStream.flush();
                    outputStream.close();

                    //捕获返回数据
                    InputStream inputStream = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuffer respond = new StringBuffer();
                    String line;
                    while((line = reader.readLine()) != null){
                        respond.append(line);
                        Log.d("jsonObj1", line);
                    }
                    JSONObject jsonObject = new JSONObject(respond.toString());
                    Log.d("jsonObj2", respond.toString());
                    String result = jsonObject.getString("result");
                    if(result!=null){
                        switch (result){
                            case "200":
                                Toast.makeText(MStoreManageSettingMessageActivity.this, "保存成功！", Toast.LENGTH_SHORT).show();
                                break;
                            case "404":
                                //  username not exited
                                Toast.makeText(MStoreManageSettingMessageActivity.this, "保存失败，网络开小差啦！", Toast.LENGTH_SHORT).show();
                                break;
                            case "401":
                                //  wrong password
                                Toast.makeText(MStoreManageSettingMessageActivity.this, "保存失败，网络开小差啦！", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                        }
                    }


                }catch (Exception e){
                    e.printStackTrace();
                    Log.d("SettingMessageActivity",e + e.getMessage());
                }
            }
        }).start();
    }








}
