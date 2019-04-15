//  not finished yet
package com.example.front_end_of_clean_up_the_camera_app;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.UserAdapter.ContentUserHomeFragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentUserHomeActivity extends AppCompatActivity {

    //  title
    private final int[] USER_TAB_TITLE = new int[]{
            R.string.user_home, R.string.user_order, R.string.user_chat};
    private final int[] USER_TAB_IMGS = new int[]{R.drawable.tab_morder_inqury_selector,
            R.drawable.tab_morder_inqury_selector, R.drawable.tab_morder_chat_selector};

    @BindView(R.id.content_user_home_pager)ViewPager viewPager;
    @BindView(R.id.content_user_home_tabLayout)TabLayout tabLayout;

    //  pager adapter
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_user_home_view_layout);

        //  bind
        ButterKnife.bind(this);

        //  init pager
        initPager();

        setTabs(tabLayout, getLayoutInflater(), USER_TAB_TITLE, USER_TAB_IMGS);

    }

    private void setTabs(TabLayout tablayout, LayoutInflater inflater, int[] tabTitles, int[] tabImages){
        for(int i = 0; i < tabTitles.length; i++){
            TabLayout.Tab tab = tabLayout.newTab();
            View view = inflater.inflate(R.layout.item_main_menu, null);
            tab.setCustomView(view);

            TextView textViewTitle = (TextView)view.findViewById(R.id.txt_tab);
            textViewTitle.setText(tabTitles[i]);

            ImageView imageViewTab =(ImageView)view.findViewById(R.id.img_tab);
            imageViewTab.setImageResource(tabImages[i]);

            tabLayout.addTab(tab);
        }
    }

    private void initPager(){

        pagerAdapter = new ContentUserHomeFragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);

        //  change bing
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
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
