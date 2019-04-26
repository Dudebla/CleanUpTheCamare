package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MOHCanceledOrderAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MechantData.MOHCanceledOrder;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

//商家订单处理页面已取消子页
public class MOHCanceledFragment extends Fragment {

    private ListView listView;

    private List<MOHCanceledOrder> datas = new ArrayList<MOHCanceledOrder>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initDatas();

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_morder_handle_canceled, container, false);

        ButterKnife.bind(this, view);

        listView=view.findViewById(R.id.lv_morderHandlCancle);

        MOHCanceledOrderAdapter mohCanceledOrderAdapter=new MOHCanceledOrderAdapter(getActivity(),datas);

        listView.setAdapter(mohCanceledOrderAdapter);


        return view;

    }

    private void initDatas() {
        MOHCanceledOrder order0 = new MOHCanceledOrder("2019年4月25日","小红","123456789");
        MOHCanceledOrder order1 = new MOHCanceledOrder("2019年4月25日","小李","123456789");
        MOHCanceledOrder order2 = new MOHCanceledOrder("2019年4月25日","小明","123456789");
        MOHCanceledOrder order3 = new MOHCanceledOrder("2019年4月25日","小黑","123456789");
        MOHCanceledOrder order4 = new MOHCanceledOrder("2019年4月25日","小白","123456789");
        MOHCanceledOrder order5 = new MOHCanceledOrder("2019年4月25日","小兰","123456789");
        datas.add(order0);
        datas.add(order1);
        datas.add(order2);
        datas.add(order3);
        datas.add(order4);
        datas.add(order5);
    }

}
