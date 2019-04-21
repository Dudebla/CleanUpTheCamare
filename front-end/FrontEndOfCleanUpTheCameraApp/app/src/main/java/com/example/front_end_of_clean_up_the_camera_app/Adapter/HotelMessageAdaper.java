package com.example.front_end_of_clean_up_the_camera_app.Adapter;

/*
* HotelMessageAdapter:  adapter of hotel_around_list_recyclerView at hotel_around_list_layout.xml
*   hotelMessageList:   List<HotelMessage>
*   layoutInflater: LayoutInflater*/

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.HotelMessage;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.List;

public class HotelMessageAdaper extends RecyclerView.Adapter<HotelMessageAdaper.HMViewHolder> {

    private List<HotelMessage> hotelMessageList;
    private LayoutInflater layoutInflater;

    public HotelMessageAdaper(Context context, List<HotelMessage> hotelMessageList){

        this.hotelMessageList = hotelMessageList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public class HMViewHolder extends RecyclerView.ViewHolder{

        TextView hotelName, hotelAddress, checkedTimes, checkedOutRate;

        public HMViewHolder(View view){
            super(view);
        }
    }

    @NonNull
    @Override
    public HMViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = layoutInflater.inflate(R.layout.hotel_around_item_layout, viewGroup, false);

        HMViewHolder hmViewHolder = new HMViewHolder(view);

        hmViewHolder.hotelName = view.findViewById(R.id.hotel_around_item_hotelName_textView);
        hmViewHolder.hotelAddress = view.findViewById(R.id.hotel_around_item_hotelAddress_textView);
        hmViewHolder.checkedTimes = view.findViewById(R.id.hotel_around_item_checkedTime_textView);
        hmViewHolder.checkedOutRate = view.findViewById(R.id.hotel_around_item_checkedRate_textView);

        return hmViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HMViewHolder hmViewHolder, int i) {

        HotelMessage hotelMessage = hotelMessageList.get(i);
        hmViewHolder.hotelName.setText(hotelMessage.getHotelName());
        hmViewHolder.hotelAddress.setText(hotelMessage.getHotelAddress());
        hmViewHolder.checkedTimes.setText(String.valueOf(hotelMessage.getCheckedTimes()));
        hmViewHolder.checkedOutRate.setText(String.valueOf(hotelMessage.getCheckedRate()) + "%");
    }

    @Override
    public int getItemCount() {
        return hotelMessageList.size();
    }
}
