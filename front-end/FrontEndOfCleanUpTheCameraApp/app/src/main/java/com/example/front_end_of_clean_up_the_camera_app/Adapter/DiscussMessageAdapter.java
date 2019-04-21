package com.example.front_end_of_clean_up_the_camera_app.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.DiscussMessage;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.List;

public class DiscussMessageAdapter extends RecyclerView.Adapter<DiscussMessageAdapter.DMViewHolder> {

    private List<DiscussMessage> discussMessageList;
    private LayoutInflater layoutInflater;

    public DiscussMessageAdapter(Context context, List<DiscussMessage> discussMessageList){

        this.discussMessageList = discussMessageList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public static class DMViewHolder extends RecyclerView.ViewHolder{

        public TextView discussUsername;
        public TextView discussScore;
        public TextView discusscontent;
        public TextView discussDate;

        public DMViewHolder(View view){
            super(view);
        }
    }

    @NonNull
    @Override
    public DMViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = layoutInflater.inflate(R.layout.seller_msg_discuss_item_layout, viewGroup, false);

        DMViewHolder dmViewHolder = new DMViewHolder(view);

        dmViewHolder.discussUsername = (TextView)view.findViewById(R.id.discuss_username_textView);
        dmViewHolder.discussScore = (TextView)view.findViewById(R.id.discuss_score_textView);
        dmViewHolder.discusscontent = (TextView)view.findViewById(R.id.discuss_content_textView);
        dmViewHolder.discussDate = (TextView)view.findViewById(R.id.discuss_time_textView);

        return dmViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull DMViewHolder dmViewHolder, int i) {

        DiscussMessage discussMessage = discussMessageList.get(i);

        dmViewHolder.discussUsername.setText(discussMessage.getDiscuss_username());
        dmViewHolder.discussScore.setText(discussMessage.getDiscuss_score());
        dmViewHolder.discusscontent.setText(discussMessage.getDiscuss_content());
        dmViewHolder.discussDate.setText(discussMessage.getDiscuss_time().toString());

    }

    @Override
    public int getItemCount() {
        return discussMessageList.size();
    }
}
