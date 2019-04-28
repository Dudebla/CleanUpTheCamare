package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;


//import android.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MOHPendingOrderAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MechantData.MOHPendingOrder;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


//商家订单处理页面待处理子页
public class MOHPendingFragment extends Fragment {

    private ListView listView;

    private List<MOHPendingOrder> datas = new ArrayList<MOHPendingOrder>();

    private MOHPendingOrderAdapter mohPendingOrderAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initDatas();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_morder_handle_pending, container, false);

        ButterKnife.bind(this, view);

        listView = view.findViewById(R.id.lv_morderHandlePending);

        mohPendingOrderAdapter = new MOHPendingOrderAdapter(getActivity(),datas);

        listView.setAdapter(mohPendingOrderAdapter);

        return view;

    }


    //String orderTime,String userName,String userPhone,String userAddress,String userRemarks,String estimatedAmount,int userImage
    private void initDatas() {
        MOHPendingOrder order0 = new MOHPendingOrder("12:00","小李","123****890","广州市体育西路","","12￥",R.drawable.user_image);
        MOHPendingOrder order1 = new MOHPendingOrder("12:00","小黄","124****890","广州市天河区中山大道","尽量快一点","14￥",R.drawable.user_image);
        MOHPendingOrder order2 = new MOHPendingOrder("12:00","小红","1234567890","华师","快点","12￥",R.drawable.user_image);
        MOHPendingOrder order3 = new MOHPendingOrder("12:00","小百","1234567890","华师","hahaha","12￥",R.drawable.user_image);
        MOHPendingOrder order4 = new MOHPendingOrder("12:00","小和","1234567890","华师","取消","12￥",R.drawable.user_image);
        MOHPendingOrder order5 = new MOHPendingOrder("12:00","小明","1234567890","华师","巴拉巴拉巴拉巴拉","12￥",R.drawable.user_image);
        datas.add(order0);
        datas.add(order1);
        datas.add(order2);
        datas.add(order3);
        datas.add(order4);
        datas.add(order5);
    }

}
