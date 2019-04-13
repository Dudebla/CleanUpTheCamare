package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.front_end_of_clean_up_the_camera_app.R;

import butterknife.ButterKnife;

//商家订单处理页面进行中子页
public class MOHGoingFragment extends Fragment {

    private String name;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

//        Bundle bundle = getArguments();
//
//        name = bundle.getString("name");
//
//        if (name == null) {
//
//            name = "参数非法";
//
//        }

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_morder_handle_going, container, false);

        ButterKnife.bind(this, view);

        return view;

    }

}
