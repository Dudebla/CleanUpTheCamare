//  SignIn_Activity.java ----signin_layout.xml

//  customerUserType | sellerUserType
//  username, tellNumber, password, passwordRV: for editView of signin_layout, for sign in msg
//  tip_***: textView of signin_layout, visible while *** on focus

package com.example.front_end_of_clean_up_the_camera_app;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn_Activity extends AppCompatActivity {


    private RadioButton customerUserType;
    private RadioButton sellerUserType;
    private EditText username_editText;
    private EditText tellNumber_editText;
    private EditText password_editText;
    private EditText passwordRV_editText;
    private TextView tip_username;
    private TextView tip_password;
    private TextView tip_passwordRV;
    private TextView hasId_textView;
    private Button signIn_button;
    private Boolean msgIsLegal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        customerUserType = (RadioButton)findViewById(R.id.signin_customer_type);
        sellerUserType = (RadioButton)findViewById(R.id.signin_seller_type);
        username_editText = (EditText)findViewById(R.id.signin_username_editText);
        tellNumber_editText = (EditText)findViewById(R.id.signin_tellNumber_editText);
        password_editText = (EditText)findViewById(R.id.signin_password_editText);
        passwordRV_editText = (EditText)findViewById(R.id.signin_passwordReview_editText);
        tip_username = (TextView)findViewById(R.id.tip_username_textView);
        tip_password = (TextView)findViewById(R.id.tip_Password_textView);
        tip_passwordRV = (TextView)findViewById(R.id.tip_PasswordReview_textView);
        hasId_textView = (TextView)findViewById(R.id.signin_hadId_textView);
        signIn_button = (Button)findViewById(R.id.signin_button);
        msgIsLegal = false; //  false as default


        setListenerOfWidget();
    }

    private void setListenerOfWidget(){
        username_editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    tip_username.setVisibility(View.VISIBLE);
                else
                    tip_username.setVisibility(View.INVISIBLE);
            }
        });
        password_editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    tip_password.setVisibility(View.VISIBLE);
                else
                    tip_password.setVisibility(View.INVISIBLE);
            }
        });
        passwordRV_editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    tip_passwordRV.setVisibility(View.VISIBLE);
                else
                    tip_passwordRV.setVisibility(View.INVISIBLE);
            }
        });
        signIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = username_editText.getText().toString();
                String tellNumber = tellNumber_editText.getText().toString();
                String password = password_editText.getText().toString();
                String passwordRV = passwordRV_editText.getText().toString();
                if("".equals(username)||"".equals(tellNumber)||"".equals(password)||"".equals(passwordRV)){
                    Toast.makeText(v.getContext(), "输入不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(username.length()<2||username.length()>16||password.length()<8||password.length()>16){
                    Toast.makeText(v.getContext(), "输入长度不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password.equals(passwordRV)){
                    Toast.makeText(v.getContext(), "两次密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(tellNumber.matches("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\\\d{8}$")){
                    Toast.makeText(v.getContext(), "联系号码输入不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!username.matches("^[(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]]{2,16}$")){
                    Toast.makeText(v.getContext(), "用户名输入有误，请重新输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password.matches("^[a-zA-Z0-9_@#]{8,16}$")){
                    Toast.makeText(v.getContext(), "密码输入不规范，请重新输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                msgIsLegal = true;
                Toast.makeText(v.getContext(), "MsgLegal", Toast.LENGTH_SHORT).show();
            }
        });
        hasId_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn_Activity.this, LogIn_Activity.class);
                startActivity(intent);
            }
        });
    }

}
