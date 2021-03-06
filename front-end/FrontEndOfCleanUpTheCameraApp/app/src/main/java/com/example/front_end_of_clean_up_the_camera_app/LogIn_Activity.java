//  LogIn_Activity.java   ----    login_activity.xml
package com.example.front_end_of_clean_up_the_camera_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.front_end_of_clean_up_the_camera_app.Tools.LoadingWindow;
import com.example.front_end_of_clean_up_the_camera_app.Tools.ServerConnection;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogIn_Activity extends AppCompatActivity {

    private EditText username_editText, password_editText;
    private TextView signin_textView, forgetPW_textView;
    private Button login_button;
    private String userName;
    private String userId;
    private int userType;
    private LoadingWindow loadingWindow = null;


    //  statement of username and password
    private static final int EMPTY_MSG = 0;
    private static final int USERNAME_OUT_OF_RANGE = 1;
    private static final int PASSWORD_OUT_OF_RANGE = 2;
    private static final int USERNAME_INCLUDE_ILLEGAL_CHAR = 3;
    private static final int PASSWORD_INCLUDE_ILLEGAL_CHAR = 4;
    private static final int MSG_LEGAL = 5;
    private static final int USERNAME_NOT_FOUND = 6;

    public final int success = 1;// success login
    public final int password_error = 2;//
    public final int no_user = 3;//user not exit

    //  dude TestButton
    private Button dudeTestButton;
    //  test for login
    private String IP = "192.168.43.86";

    //PH TestButton
    private Button PHtestButton;


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            loadingWindow.dismiss();
            switch (msg.what){
                case success:
                    Intent intent;
                    if(userType == 1){//user
                        intent = new Intent(LogIn_Activity.this, UserHomeActivity.class);
                    }else{
                        intent = new Intent(LogIn_Activity.this, MechanthomeActivity.class);

                    }
                    startActivity(intent);
                    finish();
                    break;
                case password_error:
                    Toast.makeText(LogIn_Activity.this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    break;
                case no_user:
                    Toast.makeText(LogIn_Activity.this, "用户名不存在，请重新输入", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("userName", null);
        int userType = sharedPreferences.getInt("userType", -1);
        Intent intent;
        if(userName != null){
            if(userType==1){//is user
                intent = new Intent(LogIn_Activity.this, UserHomeActivity.class);
            }else{
                intent = new Intent(LogIn_Activity.this, MechanthomeActivity.class);
            }
            startActivity(intent);
            finish();
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        username_editText = (EditText)findViewById(R.id.login_username_editText);
        password_editText = (EditText)findViewById(R.id.login_password_editText);
        login_button = (Button)findViewById(R.id.login_login_button);
        signin_textView = (TextView)findViewById(R.id.login_signIn_textView);
        forgetPW_textView = (TextView)findViewById(R.id.login_forgetPW_textView);

        //  dude Test Button
        dudeTestButton = (Button)findViewById(R.id.tmpButtonForDudeTest);

        //PH Test Button
        PHtestButton=(Button)findViewById(R.id.btn_testForPH);

        setOnClickListenerOfWidget();


    }


    //  set onClickListener of login_button, signin_textView
    private void setOnClickListenerOfWidget(){

        //  set onClickListener of button, check the msg
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int statement = getLogInMsg();
                String tipMsg = "";
                switch (statement){
                    case EMPTY_MSG:
                        tipMsg = "用户名和密码不能为空";
                        break;
                    case USERNAME_INCLUDE_ILLEGAL_CHAR:
                    case USERNAME_OUT_OF_RANGE:
                        tipMsg = "用户名长度为2~16，只包含汉子、数字、字母和下划线_";
                        break;
                    case PASSWORD_INCLUDE_ILLEGAL_CHAR:
                    case  PASSWORD_OUT_OF_RANGE:
                        tipMsg = "密码长度为8～16，只包含数字、字母、特殊符号_@#";
                        break;
                    default:

                }
                if(!"".equals(tipMsg)) {
                    Toast.makeText(v.getContext(), tipMsg, Toast.LENGTH_SHORT).show();
                }else{
//                    Intent intent = new Intent(LogIn_Activity.this, UserHomeActivity.class);
//                    startActivity(intent);

                    //================================
                    //    login
                    //================================
                    sendLoginMessage();

                }
            }
        });

        //  set onClickListener of signin_textView, link to SignIn_Activity
        signin_textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn_Activity.this, SignIn_Activity.class);
                startActivity(intent);
            }
        });

        //  Dude Test Button
        dudeTestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//
            }
        });

        //PH Test Button
        PHtestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(LogIn_Activity.this, MechanthomeActivity.class);

                startActivity(intent);
            }
        });


    }

    //  send login message
    private void sendLoginMessage(){
        //  create new thread
        loadingWindow = new LoadingWindow(LogIn_Activity.this);
        loadingWindow.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try{

                    connection = new ServerConnection("login", "POST").getConnection();
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.connect();

                    OutputStream outputStream = connection.getOutputStream();
                    String loginMsg = "username=" + username_editText.getText().toString() +
                            "&password=" + password_editText.getText().toString();
                    outputStream.write(loginMsg.getBytes());
                    outputStream.flush();
                    outputStream.close();

//                    int code = connection.getResponseCode();

                    InputStream inputStream = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder respond = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        respond.append(line);
                    }
                    JSONObject jsonObject = new JSONObject(respond.toString());
                    Log.d("jsonObj2", respond.toString());
                    String result = jsonObject.getString("result");
                    if(result!=null){
                        Message msg = new Message();
                        switch (result){
                            case "200":
                                //  login
                                msg.what = success;
                                userType = jsonObject.getInt("flag");
                                userId = jsonObject.getString("id");
                                userName = username_editText.getText().toString();
                                userId = jsonObject.getString("id");
                                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("userName", userName);

                                editor.putString("userId", userId);

                                editor.putString("userId",userId);

                                editor.putInt("userType", userType);
                                editor.apply();
                                handler.sendMessage(msg);
                                break;
                            case "404":
                                //  username not exited
                                msg.what = no_user;
                                handler.sendMessage(msg);
                                break;
                            case "401":
                                //  wrong password
                                msg.what = password_error;
                                handler.sendMessage(msg);
                                break;
                                default:
                        }
                    }


                }catch (Exception e){
                    e.printStackTrace();
                    Log.d("Login_Activity", e + e.getMessage());
                }
            }
        }).start();
    }


    //  getLogInMsg:int
    //  check the msg of username and password, return statement
    private int getLogInMsg(){
        int statement;

        String username = username_editText.getText().toString();
        String password = password_editText.getText().toString();

        if("".equals(username) || "".equals(password)){
            statement = EMPTY_MSG;
        }else if(username.length()>15 || username.length()<2) {
            statement = USERNAME_OUT_OF_RANGE;
        }else if(password.length()>16 || password.length()<8){
            statement = PASSWORD_OUT_OF_RANGE;
        }else{
            return checkMsgChar(username, password);
        }
        return statement;
    }

    private int checkMsgChar(String username, String password){
        //  username只含有汉字、数字、字母、下划线不能以下划线开头和结尾
        //  password只含有字母、数字、_@#
        String regOfUsername = "^[(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]]{2,16}$";
        String regOfPassword = "^[a-zA-Z0-9_@#]{8,16}$";

        Pattern pattern = Pattern.compile(regOfUsername);
        Matcher matcher = pattern.matcher(username);
        if(matcher.find()){
            pattern = Pattern.compile(regOfPassword);
            matcher = pattern.matcher(password);
            if(matcher.find()){
                return MSG_LEGAL;
            }
            else {
                return PASSWORD_INCLUDE_ILLEGAL_CHAR;
            }
        }else{
            return USERNAME_INCLUDE_ILLEGAL_CHAR;
        }
    }


}
