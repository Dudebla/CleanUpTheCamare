package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MOHGoingOrderAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MechantData.MOHGoingOrder;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

//商家订单处理页面进行中子页
public class MOHGoingFragment extends Fragment {

    private String name;

    private ListView listView;

    private List<MOHGoingOrder> datas = new ArrayList<MOHGoingOrder>();

    private MOHGoingOrderAdapter mohGoingOrderAdapter;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initDatas();

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_morder_handle_going, container, false);

        ButterKnife.bind(this, view);

        listView=view.findViewById(R.id.lv_morderHandlGoing);

        MOHGoingOrderAdapter mohGoingOrderAdapter=new MOHGoingOrderAdapter(getActivity(),datas);

        listView.setAdapter(mohGoingOrderAdapter);

        return view;

    }



    //String orderTime,String reciveTime,String userName,String userPhone,String userAddress,String userRemarks,String estimatedAmount,int userImage) {
    private void initDatas() {
        MOHGoingOrder order0 = new MOHGoingOrder("12:00","12:35","小红","155****0000","广州市珠江东路","","12￥", "0000001", R.drawable.user_image);
        MOHGoingOrder order1 = new MOHGoingOrder("12:12","13:05","小李","155****1122","广州市海珠区阅江西路","嘿嘿","13￥","0000004", R.drawable.user_image);
        MOHGoingOrder order2 = new MOHGoingOrder("12:00","15:00","小明","1234567","华师","检查检查检查","12￥","0000010",R.drawable.user_image);
        MOHGoingOrder order3 = new MOHGoingOrder("12:00","15:00","小黑","1234567","华师","没有","12￥","0000010",R.drawable.user_image);
        MOHGoingOrder order4 = new MOHGoingOrder("12:00","15:00","小白","1234567","华师","啦啦啦啦","12￥","0000010",R.drawable.user_image);
        MOHGoingOrder order5 = new MOHGoingOrder("12:00","15:00","小兰","1234567","华师","哈哈哈哈","12￥","0000010",R.drawable.user_image);
        datas.add(order0);
        datas.add(order1);
        datas.add(order2);
        datas.add(order3);
        datas.add(order4);
        datas.add(order5);
    }
}
