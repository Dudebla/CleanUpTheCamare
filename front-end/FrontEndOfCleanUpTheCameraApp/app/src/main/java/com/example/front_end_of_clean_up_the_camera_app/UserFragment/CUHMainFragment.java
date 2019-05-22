package com.example.front_end_of_clean_up_the_camera_app.UserFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.front_end_of_clean_up_the_camera_app.GlideImageLoader;
import com.example.front_end_of_clean_up_the_camera_app.HotelAroundActivity;
import com.example.front_end_of_clean_up_the_camera_app.R;
import com.example.front_end_of_clean_up_the_camera_app.Seller_List_Activity;
import com.example.front_end_of_clean_up_the_camera_app.ServerConnection;
import com.example.front_end_of_clean_up_the_camera_app.UserHomeActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class CUHMainFragment extends Fragment {

    private List<Integer> imageList;
    private List<String> titleList;
    private RelativeLayout makeOrderRelativeLayout;
    private RelativeLayout hotelAroundRelativaLayout;
    private RelativeLayout litCourseRelativaLayout;

    public CUHMainFragment(){
        initImages();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_user_home_main_layout, container, false);

        Banner banner = (Banner)view.findViewById(R.id.cuh_main_cycle_photo_banner);
        //  set banner style
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //  set imageLoader
        banner.setImageLoader(new GlideImageLoader());
        //  set image set
        banner.setImages(imageList);
        //  set outlook
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setBannerTitles(titleList);
//        banner.setBannerTitles(titles)
        banner.isAutoPlay(true);
        //  set time
        banner.setDelayTime(1500);
        //  set location of indicator
        banner.setIndicatorGravity(BannerConfig.CENTER);

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                //  manager banner photos clicked
                Toast.makeText(getContext(), position + "on clicked", Toast.LENGTH_SHORT).show();
            }
        });

        banner.start();

        makeOrderRelativeLayout = view.findViewById(R.id.cuh_main_make_order_relativeLayout);
        hotelAroundRelativaLayout = view.findViewById(R.id.cuh_main_hotel_around_relativeLayout);
        litCourseRelativaLayout = view.findViewById(R.id.cuh_main_lit_course_relativeLayout);

        setOnClickListener();

        return view;
    }

    private void initImages(){
        imageList = new ArrayList<>();
        titleList = new ArrayList<>();

        imageList.add(R.mipmap.cutc_1);
        imageList.add(R.mipmap.cutc_2);
        imageList.add(R.mipmap.cutc_3);

        titleList.add("photo1");
        titleList.add("photo2");
        titleList.add("photo3");
    }

    private void setOnClickListener(){

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        final String userName = sharedPreferences.getString("userName", null);
        final String userLocation = sharedPreferences.getString("locaiton", null);

        //  set onClickListener
        makeOrderRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userLocation == null){
                    Toast.makeText(getContext(), "获取当前定位失败，请稍后重试", Toast.LENGTH_SHORT).show();
                }else {

                    Intent intent = new Intent(getActivity(), Seller_List_Activity.class);
                    startActivity(intent);
                }
            }
        });

        //  search hotel nearby
        hotelAroundRelativaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userLocation == null){
                    Toast.makeText(getContext(), "获取当前定位失败，请稍后重试", Toast.LENGTH_SHORT).show();
                }else {
                    //  send request
                    Intent intent = new Intent(getActivity(), HotelAroundActivity.class);
                    startActivity(intent);
                }
            }
        });

        litCourseRelativaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }


}
