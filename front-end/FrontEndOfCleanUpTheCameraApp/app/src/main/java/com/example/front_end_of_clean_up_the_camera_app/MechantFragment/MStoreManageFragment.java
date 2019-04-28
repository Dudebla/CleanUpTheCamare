package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.MStoreManageSettingActivity.MStoreManageSettingActivity;
import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MStoreManageContentFragmentAdapter;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//商家店铺管理页面
public class MStoreManageFragment extends Fragment {

    private Toolbar toolbar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.switch_mechantStoreConditionControl)
    Switch mStoreConditionControl;

    @BindView(R.id.tv_mechantStoreCondition)
    TextView mStoreCondition;

    @BindView(R.id.tv_mStoreIncomeTotal)
    TextView mStoreIncomeTotal;

    private List<String> titles;

    private MStoreManageContentFragmentAdapter adapter;

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            String msg = "";

            switch (menuItem.getItemId()) {

                case R.id.item_mechantStoreManageSetting:

                    msg += "Click setting";

                    Intent intent = new Intent(getActivity(), MStoreManageSettingActivity.class);

                    startActivity(intent);

                    break;
            }


            return true;
        }
    };

    public MStoreManageFragment() {

    }

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        initData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mstore_manage, container, false);
        //绑定页面
        ButterKnife.bind(this, view);

        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar_mechantStoreManage);

        toolbar.getMenu().clear();

        toolbar.inflateMenu(R.menu.mechant_store_manage);

        toolbar.setOnMenuItemClickListener(onMenuItemClick);

        toolbar.setTitle("店铺管理");

        adapter = new MStoreManageContentFragmentAdapter(getChildFragmentManager());

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        // 更新适配器数据

        //给switch设置点击监控
        mStoreConditionControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mStoreCondition.setText("营业中");
                }else {
                    mStoreCondition.setText("暂停营业");
                }
            }
        });

        mStoreIncomeTotal.setText("2422￥");


        adapter.setList(titles);


        return view;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        menu.clear();

        inflater.inflate(R.menu.mechant_store_manage, menu);

        MenuItem item=menu.findItem(R.id.item_mechantStoreManageSetting);

        super.onCreateOptionsMenu(menu, inflater);

    }

    private void initData() {

        titles = new ArrayList<>();

        titles.add("用户评价");

        titles.add("收入记录");

    }





}


