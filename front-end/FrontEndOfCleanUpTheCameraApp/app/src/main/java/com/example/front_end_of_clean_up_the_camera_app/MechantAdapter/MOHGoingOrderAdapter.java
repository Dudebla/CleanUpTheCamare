package com.example.front_end_of_clean_up_the_camera_app.MechantAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.MechantData.MOHGoingOrder;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.List;

public class MOHGoingOrderAdapter extends BaseAdapter {

    private Context context;
    private List<MOHGoingOrder> datas;

    //构造函数需要传入两个必要的参数：上下文对象和数据源
    public MOHGoingOrderAdapter(Context context,List<MOHGoingOrder> datas) {

        this.context=context;
        //list类型的数据,多个对象
        this.datas=datas;

    }
    //返回子项的个数
    @Override
    public int getCount() {
        return datas.size();
    }
    //返回子项对应的对象
    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }
    //返回子项的下标
    @Override
    public long getItemId(int position) {
        return position;
    }
    //返回子项视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MOHGoingOrder mohGoingOrder= (MOHGoingOrder) getItem(position);

        View view;
        //创建内部类ViewHolder，可以避免每次调用getView方法
        MOHGoingOrderAdapter.ViewHolder viewHolder;

        if(convertView==null){

            view = LayoutInflater.from(context).inflate(R.layout.fragment_morder_handle_going_chirld,null);

            viewHolder=new MOHGoingOrderAdapter.ViewHolder();

            viewHolder.userImage=(ImageView)view.findViewById(R.id.iv_userImage);

            viewHolder.orderTime=(TextView)view.findViewById(R.id.tv_orderTime);

            viewHolder.reciveTime=(TextView)view.findViewById(R.id.tv_reciveTime);

            viewHolder.userName=(TextView)view.findViewById(R.id.tv_username) ;

            viewHolder.userPhone=(TextView)view.findViewById(R.id.tv_userPhone);

            viewHolder.userRemark=(TextView)view.findViewById(R.id.tv_userRemarks);

            viewHolder.userAddress=(TextView)view.findViewById(R.id.tv_userAddress);

            viewHolder.estimatedAmount=(TextView)view.findViewById(R.id.tv_estimatedAmount);

            view.setTag(viewHolder);
        }

        else{

            view=convertView;

            viewHolder= (MOHGoingOrderAdapter.ViewHolder) view.getTag();

        }

        viewHolder.orderTime.setText(mohGoingOrder.getOrderTime());

        viewHolder.reciveTime.setText(mohGoingOrder.getReciveTime());

        viewHolder.userName.setText(mohGoingOrder.getUserName());

        viewHolder.userAddress.setText(mohGoingOrder.getUserAddress());

        viewHolder.userRemark.setText(mohGoingOrder.getUserRemarks());

        viewHolder.userPhone.setText(mohGoingOrder.getUserPhone());

        viewHolder.estimatedAmount.setText(mohGoingOrder.getEstimatedAmount());

        viewHolder.userImage.setImageResource(mohGoingOrder.getUserImage());

        return view;

    }
    //创建ViewHolder类
    class ViewHolder{

        ImageView userImage;

        TextView userName;

        TextView orderTime;

        TextView reciveTime;

        TextView userPhone;

        TextView userAddress;

        TextView userRemark;

        TextView estimatedAmount;

    }

}
