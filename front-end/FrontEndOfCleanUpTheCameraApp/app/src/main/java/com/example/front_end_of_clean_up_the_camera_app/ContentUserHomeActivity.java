//  not finished yet
package com.example.front_end_of_clean_up_the_camera_app;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentUserHomeActivity extends AppCompatActivity {

    //  title
    private final int[] USER_TAB_TITLE = new int[]{
            R.string.user_home, R.string.user_order, R.string.user_chat};

    @BindView(R.id.content_user_home_pager)ViewPager viewPager;
    @BindView(R.id.content_user_home_tabLayout)TabLayout tabLayout;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_user_home);

        ButterKnife.bind(this);

    }

    private void setTabs(TabLayout tablayout, LayoutInflater inflater, int[] tabTitles){
        for(int i = 0; i < tabTitles.length; i++){

        }
    }
}
