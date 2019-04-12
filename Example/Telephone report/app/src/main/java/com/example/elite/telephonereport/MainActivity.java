package com.example.elite.telephonereport;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;//自定义标题栏布局
    private ImageView icon;//logo
    private Button merchantlogin,adminlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏默认标题栏
        actionBar = getSupportActionBar();
        actionBar.hide();
        //加载logo
        icon = findViewById(R.id.icon);
        icon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.icon2));

        merchantlogin = findViewById(R.id.merchantlogin);
        adminlogin = findViewById(R.id.adminlogin);
        merchantlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MerchantLoginActivity.class);
                startActivity(intent);
            }
        });

        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AdministratorLoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
