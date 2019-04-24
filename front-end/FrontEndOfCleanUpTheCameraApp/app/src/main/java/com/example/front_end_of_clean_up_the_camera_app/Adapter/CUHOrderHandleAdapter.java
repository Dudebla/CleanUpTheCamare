package com.example.front_end_of_clean_up_the_camera_app.Adapter;

/*CUHOrderHandleAdapter:    BaseAdapter -- adapter of three listViews' item
* read @layout/cuh_order_item_layout_header.xml for detail*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.CUHOrderMessage;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.List;

public class CUHOrderHandleAdapter extends BaseAdapter {

    private Context context;
    private List<CUHOrderMessage> cuhOrderMessageList;
    private int handelType;

    public class ViewHolder{

        TextView orderResultLabel;
        TextView userTipLabel;

        TextView orderID;
        TextView orderTime;
        TextView orderSpaceType;
        TextView orderSpaceArea;
        TextView sellerName;
        TextView userTip;
        TextView orderCost;
        TextView orderResult;

        ImageView chatSeller;

        Button payCostButton;
        Button cancelOrderButton;

        View borderViewThree;
        View borderViewFour;

    }

    public CUHOrderHandleAdapter(Context context, List<CUHOrderMessage> cuhOrderMessageList, int handelType){

        this.context = context;
        this.cuhOrderMessageList = cuhOrderMessageList;
        this.handelType = handelType;
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

        CUHOrderHandleAdapter.ViewHolder viewHolder;

        if(convertView == null){

            view = LayoutInflater.from(context).inflate(R.layout.cuh_order_item_layout_header, null);

            viewHolder = new CUHOrderHandleAdapter.ViewHolder();

            viewHolder.orderID = (TextView)view.findViewById(R.id.cuh_order_id_textView);
            viewHolder.orderTime = (TextView)view.findViewById(R.id.cuh_order_data_textView);
            viewHolder.orderSpaceType = (TextView)view.findViewById(R.id.cuh_order_spaceType_textView);
            viewHolder.orderSpaceArea = (TextView)view.findViewById(R.id.cuh_order_spaceArea_textView);
            viewHolder.sellerName = (TextView)view.findViewById(R.id.cuh_order_sellerName_textView);
            viewHolder.orderCost = (TextView)view.findViewById(R.id.cuh_order_cost_textView);
            viewHolder.userTipLabel = (TextView)view.findViewById(R.id.cuh_order_userTip_label);
            viewHolder.userTip = (TextView)view.findViewById(R.id.cuh_order_userTip_textView);
            viewHolder.orderResult = (TextView)view.findViewById(R.id.cuh_order_result_textView);
            viewHolder.orderResultLabel = (TextView)view.findViewById(R.id.cuh_order_result_label);
            viewHolder.chatSeller = (ImageView)view.findViewById(R.id.cuh_order_chat_imageView);
            viewHolder.payCostButton = (Button)view.findViewById(R.id.cuh_order_pay_button);
            viewHolder.cancelOrderButton = (Button)view.findViewById(R.id.cuh_order_cancel_button);
            viewHolder.borderViewThree = (View)view.findViewById(R.id.cuh_order_dividerThree);
            viewHolder.borderViewFour = (View)view.findViewById(R.id.cuh_order_dividerFour);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (CUHOrderHandleAdapter.ViewHolder)view.getTag();
        }

        viewHolder.orderID.setText(cuhOrderMessage.getID());
        viewHolder.orderTime.setText(cuhOrderMessage.getOrderTime().toString());
        viewHolder.orderSpaceType.setText(cuhOrderMessage.getSpaceType());
        viewHolder.orderSpaceArea.setText(String.valueOf(cuhOrderMessage.getSpaceArea()));
        viewHolder.sellerName.setText(cuhOrderMessage.getSellerID());   //  !!!should be seller name here
        viewHolder.orderCost.setText(String.valueOf(cuhOrderMessage.getCost()));
        viewHolder.userTip.setText(cuhOrderMessage.getUserTip());
        viewHolder.orderResult.setText(Integer.toString(cuhOrderMessage.getCheckStatu()));

        switch (handelType){
            case 0:
                //  waiting paying page
                viewHolder.orderResult.setVisibility(View.GONE);
                viewHolder.orderResultLabel.setVisibility(View.GONE);
                break;
            case 1:
                //  waiting server page
                viewHolder.payCostButton.setVisibility(View.GONE);
                viewHolder.orderResult.setVisibility(View.GONE);
                viewHolder.orderResultLabel.setVisibility(View.GONE);
                break;
            case 2:
                //  serving
                viewHolder.payCostButton.setVisibility(View.GONE);
                viewHolder.cancelOrderButton.setVisibility(View.GONE);
                viewHolder.orderResult.setVisibility(View.GONE);
                viewHolder.orderResultLabel.setVisibility(View.GONE);
                viewHolder.borderViewThree.setVisibility(View.GONE);
                viewHolder.borderViewFour.setVisibility(View.GONE);
                break;
            default :
        }

//        viewHolder.chatSeller.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "!!!!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        viewHolder.payCost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "?????", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        viewHolder.cancelOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "~~~~~", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;

    }
}
