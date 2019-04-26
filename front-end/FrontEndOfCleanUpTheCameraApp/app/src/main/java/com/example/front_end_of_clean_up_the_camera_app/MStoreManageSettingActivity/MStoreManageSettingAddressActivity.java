package com.example.front_end_of_clean_up_the_camera_app.MStoreManageSettingActivity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MStoreManageSettingAddressActivity extends AppCompatActivity {

    //页卡适配器
    private PagerAdapter adapter;

    @BindView(R.id.tv_mStoreManageSettingCancle)
    TextView tv_cancle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_msotre_manage_reset_address);

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



    }

}
