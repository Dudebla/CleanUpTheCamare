package com.example.front_end_of_clean_up_the_camera_app.MechantAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.front_end_of_clean_up_the_camera_app.MechantFragment.MOHCanceledFragment;
import com.example.front_end_of_clean_up_the_camera_app.MechantFragment.MOHCompletedFragment;
import com.example.front_end_of_clean_up_the_camera_app.MechantFragment.MOHGoingFragment;
import com.example.front_end_of_clean_up_the_camera_app.MechantFragment.MOHPendingFragment;

import java.util.ArrayList;
import java.util.List;

//订单处理子页MOrderHandleFragment适配器
public class MOHContentFragmentAdapter extends FragmentPagerAdapter {

    //存放顶部tab标题显示
    private List<String> names;

    public MOHContentFragmentAdapter(FragmentManager fm) {

        super(fm);

        this.names = new ArrayList<>();

    }

    //根据datas参数设置顶部标题List的内容
    public void setList(List<String> datas) {

        this.names.clear();

        this.names.addAll(datas);
        //通知顶部tab内容更新
        notifyDataSetChanged();

    }

    //根据选择的tab构造并返回相应的fragment
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                //待处理订单
                fragment = new MOHPendingFragment();
                break;

            case 1:
                //进行中订单
                fragment = new MOHGoingFragment();
                break;

            case 2:
                //已取消订单
                fragment = new MOHCanceledFragment();
                break;

            case 3:
                //已完成订单
                fragment = new MOHCompletedFragment();
                break;

            default:
                break;

        }
        //与订单处理的子页fragment传参names
        Bundle bundle = new Bundle();

        bundle.putString("name", names.get(position));

        fragment.setArguments(bundle);

        return fragment;

    }

    @Override
    public int getCount() {
        return names.size();
    }

    //返回tab标题字符串
    @Override
    public CharSequence getPageTitle(int position) {

        String plateName = names.get(position);

        if (plateName == null) {

            plateName = "";

        }

        else if (plateName.length() > 15) {

            plateName = plateName.substring(0, 15) + "...";

        }

        return plateName;

    }

}
