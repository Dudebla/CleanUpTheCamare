package com.example.front_end_of_clean_up_the_camera_app;

/*HotelAroundActivity:  activity manege even at hotel_around_
* */

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.front_end_of_clean_up_the_camera_app.Adapter.HotelMessageAdaper;
import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.HotelMessage;

import java.util.ArrayList;
import java.util.List;

public class HotelAroundActivity extends AppCompatActivity {

    private List<HotelMessage> hotelMessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_around_list_layout);

        //  set bar event
        Toolbar toolbar = (Toolbar)findViewById(R.id.hotel_around_list_toolBar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("附近酒店");
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        initHotelMessaheList();

        //  set hotel list recyclerView
        RecyclerView hmRecyclerView = (RecyclerView)findViewById(R.id.hotel_around_list_recyclerView);
        HotelMessageAdaper hotelMessageAdaper = new HotelMessageAdaper(this, hotelMessageList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        hmRecyclerView.setLayoutManager(linearLayoutManager);
        hmRecyclerView.setAdapter(hotelMessageAdaper);
    }

    private void initHotelMessaheList(){
        hotelMessageList = new ArrayList<>();

        HotelMessage hotelMessage = new HotelMessage("HotelNAme", "blablablablablabla", 1, 0);
        hotelMessageList.add(hotelMessage);
        hotelMessageList.add(hotelMessage);
        hotelMessage = new HotelMessage("HHHHHHHHHHHHH", "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh", 13, 3);
        hotelMessageList.add(hotelMessage);
        hotelMessageList.add(hotelMessage);
    }
}
