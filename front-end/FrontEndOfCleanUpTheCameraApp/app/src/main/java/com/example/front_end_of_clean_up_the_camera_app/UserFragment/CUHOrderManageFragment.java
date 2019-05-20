package com.example.front_end_of_clean_up_the_camera_app.UserFragment;

/*CUHOrderManageFragment:   Fragment    --  manage the view of order_layout, choose different adapter
* listView: ListView    --  ListView of fragment at content_user_home_order_layout
* datas:    List<CUHOrderMessage>   --
* cuhOrderHandleAdapter:    BaseAdapter --  manage list item of order_layout
* type: int --  tag of different listViews
* */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.front_end_of_clean_up_the_camera_app.Adapter.CUHOrderHandleAdapter;
import com.example.front_end_of_clean_up_the_camera_app.Adapter.CUHOrderHistoryHandleAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.CUHOrderMessage;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class CUHOrderManageFragment extends Fragment {

    private ListView listView;

    private List<CUHOrderMessage> datas;

    private BaseAdapter baseAdapter;

    private int type;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.type = this.getArguments().getInt("type");

        initDatas();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.cuh_order_list_layout, container, false);

        ButterKnife.bind(this, view);

        listView = view.findViewById(R.id.cuh_order_listView);

        if(type<=2) {

            baseAdapter = new CUHOrderHandleAdapter(getActivity(), datas, type);
        }else{
            baseAdapter = new CUHOrderHistoryHandleAdapter(getActivity(), datas);
        }
        listView.setAdapter(baseAdapter);

        return view;
    }

    private void initDatas(){

        datas = new ArrayList<>();
        Date date = new Date(System.currentTimeMillis());
        String userTip = "无";
        CUHOrderMessage orderMessage = new CUHOrderMessage("00000001", 0, "李小明", "CUTC广州分部", date, 20.0, "广州市天河区", userTip, "酒店", 30, 0);
        datas.add(orderMessage);
    }
}
