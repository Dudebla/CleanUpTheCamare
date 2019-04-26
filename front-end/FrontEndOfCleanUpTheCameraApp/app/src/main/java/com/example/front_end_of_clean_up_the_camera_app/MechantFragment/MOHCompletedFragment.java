package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MOHCompletedOrderAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MechantData.MOHCompletedOrder;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

//商家订单处理已完成子页
public class MOHCompletedFragment extends Fragment {

    private ListView listView;

    private List<MOHCompletedOrder> datas = new ArrayList<MOHCompletedOrder>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initDatas();

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_morder_handle_completed, container, false);

        ButterKnife.bind(this, view);

        listView=view.findViewById(R.id.lv_morderHandleCompleted);

        MOHCompletedOrderAdapter mohCompletedOrderAdapter=new MOHCompletedOrderAdapter(getActivity(),datas);

        listView.setAdapter(mohCompletedOrderAdapter);


        return view;

    }

    private void initDatas() {
        MOHCompletedOrder order0 = new MOHCompletedOrder("2019年4月25日","小红","123456789","000000","12￥");
        MOHCompletedOrder order1 = new MOHCompletedOrder("2019年4月25日","小李","123456789","000000","12￥");
        MOHCompletedOrder order2 = new MOHCompletedOrder("2019年4月25日","小明","123456789","000000","12￥");
        MOHCompletedOrder order3 = new MOHCompletedOrder("2019年4月25日","小黑","123456789","000000","12￥");
        MOHCompletedOrder order4 = new MOHCompletedOrder("2019年4月25日","小白","123456789","000000","12￥");
        MOHCompletedOrder order5 = new MOHCompletedOrder("2019年4月25日","小兰","123456789","000000","12￥");
        datas.add(order0);
        datas.add(order1);
        datas.add(order2);
        datas.add(order3);
        datas.add(order4);
        datas.add(order5);
    }

}
