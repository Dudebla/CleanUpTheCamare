package com.example.front_end_of_clean_up_the_camera_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.CUHOrderMessage;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.List;

public class CUHOrderHistoryHandleAdapter extends BaseAdapter {
    private Context context;
    private List<CUHOrderMessage> cuhOrderMessageList;

    public class ViewHolder{

        TextView orderId;
        TextView orderDate;
        TextView spaceType;
        TextView spaceArea;
        TextView sellerName;
        TextView orderCost;
        TextView orderResult;
        TextView orderStatu;

        Button makeDiscussButton;

    }

    public CUHOrderHistoryHandleAdapter(Context context, List<CUHOrderMessage> cuhOrderMessageList){

        this.context = context;
        this.cuhOrderMessageList = cuhOrderMessageList;
    }

    @Override
    public int getCount() {
        return cuhOrderMessageList.size();
    }

    @Override
    public Object getItem(int position) {
        return cuhOrderMessageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CUHOrderMessage cuhOrderMessage = (CUHOrderMessage)getItem(position);

        View view;

        CUHOrderHistoryHandleAdapter.ViewHolder viewHolder;

        if(convertView == null){

            view = LayoutInflater.from(context).inflate(R.layout.cuh_order_item_header_history, null);

            viewHolder = new CUHOrderHistoryHandleAdapter.ViewHolder();
            viewHolder.orderId = (TextView)view.findViewById(R.id.cuh_orderHistory_id_textView);
            viewHolder.orderDate = (TextView)view.findViewById(R.id.cuh_orderHistory_data_textView);
            viewHolder.spaceType = (TextView)view.findViewById(R.id.cuh_orderHistory_spaceType_textView);
            viewHolder.spaceArea = (TextView)view.findViewById(R.id.cuh_orderHistory_spaceArea_textView);
            viewHolder.sellerName = (TextView)view.findViewById(R.id.cuh_orderHistory_sellerName_textView);
            viewHolder.orderCost = (TextView)view.findViewById(R.id.cuh_orderHistory_cost_textView);
            viewHolder.orderResult = (TextView)view.findViewById(R.id.cuh_orderHistory_result_textView);
            viewHolder.makeDiscussButton = (Button)view.findViewById(R.id.cuh_orderHistory_makeDiscuss_button);

            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (CUHOrderHistoryHandleAdapter.ViewHolder)view.getTag();

            viewHolder.orderId.setText(cuhOrderMessage.getID());
            viewHolder.orderDate.setText(cuhOrderMessage.getOrderTime().toString());
            viewHolder.spaceType.setText(cuhOrderMessage.getSpaceType());
            viewHolder.spaceArea.setText(String.valueOf(cuhOrderMessage.getSpaceArea()));
            viewHolder.sellerName.setText(cuhOrderMessage.getSellerID());
            viewHolder.orderCost.setText(String.valueOf(cuhOrderMessage.getCost()));
            viewHolder.orderResult.setText(cuhOrderMessage.getCheckStatu());
            viewHolder.makeDiscussButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "!!!!!", Toast.LENGTH_SHORT).show();
                }
            });

//            TextView orderDate;
//            TextView spaceType;
//            TextView spaceArea;
//            TextView sellerName;
//            TextView orderCost;
//            TextView orderResult;
//            TextView orderStatu;
//
//            Button makeDiscussButton;

        }


        return view;

    }
}
