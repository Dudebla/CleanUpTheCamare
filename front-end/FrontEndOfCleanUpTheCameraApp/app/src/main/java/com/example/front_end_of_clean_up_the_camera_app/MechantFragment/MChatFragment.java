package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.front_end_of_clean_up_the_camera_app.R;

//商家聊天子页
public class MChatFragment extends Fragment {

public MChatFragment() {

}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

   View view = inflater.inflate(R.layout.fragment_mchat, container, false);

    return view;

}

}
