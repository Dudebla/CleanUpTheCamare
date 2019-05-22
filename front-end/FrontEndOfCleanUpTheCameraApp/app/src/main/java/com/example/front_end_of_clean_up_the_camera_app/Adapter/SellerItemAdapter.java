package com.example.front_end_of_clean_up_the_camera_app.Adapter;


/*SellerItemAdapter: adapter for sellerItem
 *  sellerMessageList: List<SellerMessage>  -- list of sellerMessage for showing
 *  sellerInflater: LayoutInflater  -- for recyclerView layoutManager
 *  OnItemClickListener:  interface -- for OnClick event listening of sellerItem*/

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.SellerMessage;
import com.example.front_end_of_clean_up_the_camera_app.R;
import com.example.front_end_of_clean_up_the_camera_app.UserHome.Seller_List_Activity;

import android.os.Handler;
import java.util.List;

public class SellerItemAdapter extends RecyclerView.Adapter<SellerItemAdapter.SMViewHolder> {

    private List<SellerMessage> sellerMessageList;
    private LayoutInflater sellerInflater;
    private OnItemClickListener sellerItemOnClickerListener;
    private Handler handler;//  root handler

    //  declare OnClicked event Listener
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
    public void setSellerItemOnClickerListener(OnItemClickListener sellerItemOnClickerListener){
        this.sellerItemOnClickerListener = sellerItemOnClickerListener;
    }

    //  define adapter
    public SellerItemAdapter(Context context, List<SellerMessage> sellerMessageList, Handler handler){
        this.sellerMessageList = sellerMessageList;
        this.sellerInflater = LayoutInflater.from(context);
        this.handler = handler;
    }

    //  define viewHolder
    public static class SMViewHolder extends RecyclerView.ViewHolder{
        public TextView sellerName;
        public TextView sellerScore;
        public TextView sellerAddress;
        public TextView sellerDistance;
        public TextView sellerCost;
        public Button sellerOrder;

        public SMViewHolder(View v){
            super(v);
        }
    }

    @NonNull
    @Override
    public SMViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = sellerInflater.inflate(R.layout.seller_item_layout, viewGroup, false);

        SMViewHolder smViewHolder = new SMViewHolder(view);

        smViewHolder.sellerName = (TextView)view.findViewById(R.id.seller_item_sellerName_textView);
        smViewHolder.sellerScore = (TextView)view.findViewById(R.id.seller_item_sellerScore_textView);
        smViewHolder.sellerAddress = (TextView)view.findViewById(R.id.seller_item_sellerAddress_textView);
        smViewHolder.sellerDistance = (TextView)view.findViewById(R.id.seller_item_distance_textView);
        smViewHolder.sellerCost = (TextView)view.findViewById(R.id.seller_item_sellerCost_textView);
        smViewHolder.sellerOrder = (Button)view.findViewById(R.id.seller_item_order_button);

        return smViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SMViewHolder holder, final int position) {

        SellerMessage sellerMessage = sellerMessageList.get(position);

        holder.sellerName.setText(sellerMessage.getSellerName());
        holder.sellerAddress.setText(sellerMessage.getSellerAddress());
        holder.sellerScore.setText(sellerMessage.getSellerScore());
        holder.sellerDistance.setText(sellerMessage.getSellerDistance());
        holder.sellerCost.setText(sellerMessage.getSellerCost());

        if(sellerItemOnClickerListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  take seller message detail action
                    sellerItemOnClickerListener.onItemClick(v, position);
                }
            });
            holder.sellerOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  take order action
                    Toast.makeText(v.getContext(), "button" + position + " onClicked", Toast.LENGTH_SHORT).show();
                    Message msg = new Message();
                    msg.what = Seller_List_Activity.MAKEORDER;
                    msg.arg1 = position;
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", position);
                    msg.setData(bundle);
                    handler.sendMessage(msg);// send msg to root handle
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return sellerMessageList.size();
    }


}
