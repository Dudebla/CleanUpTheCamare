//  LogIn_Activity.java   ----    login_activity.xml
package com.example.loginview_test;

import android.content.Intent;
import android.service.autofill.RegexValidator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogIn_Activity extends AppCompatActivity {

    private EditText username_editText, password_editText;
    private TextView signin_textView, forgetPW_textView;
    private Button login_button;

    //  statement of username and password
    private static final int EMPTY_MSG = 0;
    private static final int USERNAME_OUT_OF_RANGE = 1;
    private static final int PASSWORD_OUT_OF_RANGE = 2;
    private static final int USERNAME_INCLUDE_ILLEGAL_CHAR = 3;
    private static final int PASSWORD_INCLUDE_ILLEGAL_CHAR = 4;
    private static final int MSG_LEGAL = 5;
    private static final int USERNAME_NOT_FOUND = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        username_editText = (EditText)findViewById(R.id.login_username_editText);
        password_editText = (EditText)findViewById(R.id.login_password_editText);
        login_button = (Button)findViewById(R.id.login_login_button);
        signin_textView = (TextView)findViewById(R.id.login_signIn_textView);
        forgetPW_textView = (TextView)findViewById(R.id.login_forgetPW_textView);

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
                        Intent intent = new Intent(LogIn_Activity.this, UserHomeActivity.class);
                        startActivity(intent);
                        return;
                }
                if(!"".equals(statement)) {
                    Toast.makeText(v.getContext(), tipMsg, Toast.LENGTH_SHORT).show();
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
