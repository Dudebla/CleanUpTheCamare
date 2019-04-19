package com.example.front_end_of_clean_up_the_camera_app.UserFragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.front_end_of_clean_up_the_camera_app.R;

public class CUHOrderFragment extends Fragment {

    public CUHOrderFragment(){

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content_user_home_order_layout,container, false);

        return view;
    }
}
