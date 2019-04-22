package com.example.front_end_of_clean_up_the_camera_app.UserFragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;

import com.example.front_end_of_clean_up_the_camera_app.Adapter.CUHOrderFragmentAdapter;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CUHOrderFragment extends Fragment {

    @BindView(R.id.cuh_order_tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.cuh_order_viewPager)
    ViewPager viewPager;

    private CUHOrderFragmentAdapter adapter;

    private List<String> titles;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initTitles();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content_user_home_order_layout,container, false);

        ButterKnife.bind(this, view);

        adapter = new CUHOrderFragmentAdapter(getChildFragmentManager());

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        adapter.setList(titles);

        tabLayout.getTabAt(0).setIcon(R.drawable.waiting_pay_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.waiting_server_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.had_send_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.order_history_icon);

        return view;
    }

    private void initTitles(){

        titles = new ArrayList<>();

        titles.add("待付款");

        titles.add("待接单");

        titles.add("进行中");

        titles.add("所有订单");
    }
}
