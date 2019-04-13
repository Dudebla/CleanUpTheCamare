package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.front_end_of_clean_up_the_camera_app.R;
import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MOHContentFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


//商家订单处理页面
public class MOrderHandleFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private MOHContentFragmentAdapter adapter;

    private List<String> titles;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_morder_handle, container, false);
        //绑定页面
        ButterKnife.bind(this, view);

        adapter = new MOHContentFragmentAdapter(getChildFragmentManager());

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        // 更新适配器数据
        adapter.setList(titles);

        return view;
    }

    private void initData() {

        titles = new ArrayList<>();

        titles.add("待处理");

        titles.add("进行中");

        titles.add("已取消");

        titles.add("已完成");

    }

}

