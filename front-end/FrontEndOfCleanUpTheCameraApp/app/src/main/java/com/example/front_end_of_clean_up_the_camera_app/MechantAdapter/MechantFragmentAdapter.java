package com.example.front_end_of_clean_up_the_camera_app.MechantAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.front_end_of_clean_up_the_camera_app.MechantFragment.MChatFragment;
import com.example.front_end_of_clean_up_the_camera_app.MechantFragment.MOrderHandleFragment;
import com.example.front_end_of_clean_up_the_camera_app.MechantFragment.MOrderInquryFragment;
import com.example.front_end_of_clean_up_the_camera_app.MechantFragment.MStoreManageFragment;


//商家首页MechanthomeActivity  viewPager适配器
public class MechantFragmentAdapter extends FragmentPagerAdapter {

    public MechantFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = null;
        //根据item的值新建相应的fragment并返回
        switch (i) {

            case 0:
                //订单处理
                fragment = new MOrderHandleFragment();
                break;

            case 1:
                //订单查询
                fragment = new MOrderInquryFragment();
                break;

            case 2:
                //聊天
               fragment = new MChatFragment();
                break;

            case 3:
                //店铺管理
                fragment = new MStoreManageFragment();
                break;

            default:
                break;
        }

        return fragment;

    }

    //共有四个底部导航栏
    @Override
    public int getCount() {
        return 4;
    }

}
