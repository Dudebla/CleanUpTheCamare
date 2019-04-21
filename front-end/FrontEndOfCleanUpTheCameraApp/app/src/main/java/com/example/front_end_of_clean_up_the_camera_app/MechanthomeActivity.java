package com.example.front_end_of_clean_up_the_camera_app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MechantFragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

//商家首页
public class MechanthomeActivity extends AppCompatActivity {

    private final int[] TAB_TITLES = new int[]{R.string.mechant_orderHandle, R.string.mechant_orderInqury, R.string.mechant_chat, R.string.mechant_storeManage};

    private final int[] TAB_IMGS = new int[]{R.drawable.tab_morder_handle_selector, R.drawable.tab_morder_inqury_selector, R.drawable.tab_morder_chat_selector
            , R.drawable.tab_morder_manage_selector};

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

     //页卡适配器
    private PagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mechant_home);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        //绑定
        ButterKnife.bind(this);

        // 初始化页卡
        initPager();

        //设置标题内容
        setTabs(tabLayout, getLayoutInflater(), TAB_TITLES, TAB_IMGS);

    }

    private void setTabs(TabLayout tabLayout, LayoutInflater inflater, int[] tabTitles, int[] tabImgs) {
        //循环新建n个tab并设置相关属性
        //底部导航栏
        for (int i = 0; i < tabImgs.length; i++) {

            TabLayout.Tab tab = tabLayout.newTab();
            //填充布局
            View view = inflater.inflate(R.layout.item_main_menu, null);
            // 使用自定义视图，目的是为了便于修改，也可使用自带的视图
            tab.setCustomView(view);

            TextView tvTitle = (TextView) view.findViewById(R.id.txt_tab);

            tvTitle.setText(tabTitles[i]);

            ImageView imgTab = (ImageView) view.findViewById(R.id.img_tab);

            imgTab.setImageResource(tabImgs[i]);

            tabLayout.addTab(tab);

        }

    }

    //初始化页卡
    private void initPager() {

        adapter = new MechantFragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        // 关联切换
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 取消平滑切换
                viewPager.setCurrentItem(tab.getPosition(), false);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
