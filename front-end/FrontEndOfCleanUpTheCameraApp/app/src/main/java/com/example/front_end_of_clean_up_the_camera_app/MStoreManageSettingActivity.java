package com.example.front_end_of_clean_up_the_camera_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MStoreManageSettingActivity extends AppCompatActivity {

    //页卡适配器
    private PagerAdapter adapter;

    @BindView(R.id.toolbar_mechantStoreManageSetting)
    Toolbar toolbar;

    //设置商家名按钮
    Button btn_mStoreManageSetName;
    //设置商家头像按钮
    Button btn_mStoreManageSetImage;
    //设置商家地址按钮
    Button btn_mStoreManageSetAddress;
    //设置商家介绍按钮
    Button btn_mStoreManageSetMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mstore_manage_setting);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        //绑定
        ButterKnife.bind(this);

        //设置标题内容
        toolbar.setTitle("商家设置");
        //设置toolbar的返回事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//返回
            }
        });


        //设置商家名按钮
        btn_mStoreManageSetName=findViewById(R.id.btn_mStoreManageSettingName);
        //设置商家头像按钮
        btn_mStoreManageSetImage=findViewById(R.id.btn_mStoreManageSettingImage);
        //设置商家地址按钮
        btn_mStoreManageSetAddress=findViewById(R.id.btn_mStoreManageSettingAddress);
        //设置商家介绍按钮
        btn_mStoreManageSetMessage=findViewById(R.id.btn_mStoreManageSettingMessage);

        setOnClickListener();

    }

    public void setOnClickListener()
    {
        //点击跳转修改姓名
        btn_mStoreManageSetName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MStoreManageSettingActivity.this, MStoreManageSettingNameActivity.class);
                startActivity(intent);
            }
        });
        //点击跳转修改地址
        btn_mStoreManageSetAddress.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MStoreManageSettingActivity.this, MStoreManageSettingAddressActivity.class);
                startActivity(intent);
            }
        });
        //点击跳转修改商家信息
        btn_mStoreManageSetMessage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MStoreManageSettingActivity.this, MStoreManageSettingMessageActivity.class);
                startActivity(intent);
            }
        });


    }




}
