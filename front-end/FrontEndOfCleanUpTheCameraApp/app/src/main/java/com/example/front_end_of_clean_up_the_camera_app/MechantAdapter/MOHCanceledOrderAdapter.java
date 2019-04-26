package com.example.front_end_of_clean_up_the_camera_app.MechantAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.MechantData.MOHCanceledOrder;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.List;

public class MOHCanceledOrderAdapter extends BaseAdapter {

    private Context context;
    private List<MOHCanceledOrder> datas;

    //构造函数需要传入两个必要的参数：上下文对象和数据源
    public MOHCanceledOrderAdapter(Context context,List<MOHCanceledOrder> datas) {

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

        MOHCanceledOrder mohCanceledOrder= (MOHCanceledOrder) getItem(position);

        View view;
        //创建内部类ViewHolder，可以避免每次调用getView方法
        MOHCanceledOrderAdapter.ViewHolder viewHolder;

        if(convertView==null){

            view = LayoutInflater.from(context).inflate(R.layout.fragment_morder_handle_canceled_child,null);

            viewHolder=new MOHCanceledOrderAdapter.ViewHolder();

            viewHolder.orderTime=(TextView)view.findViewById(R.id.tv_orderTime);

            viewHolder.userName=(TextView)view.findViewById(R.id.tv_username) ;

            viewHolder.userPhone=(TextView)view.findViewById(R.id.tv_userPhone);

            view.setTag(viewHolder);
        }

        else{

            view=convertView;

            viewHolder= (MOHCanceledOrderAdapter.ViewHolder) view.getTag();

        }

        viewHolder.orderTime.setText(mohCanceledOrder.getOrderTime());

        viewHolder.userName.setText(mohCanceledOrder.getUserName());

        viewHolder.userPhone.setText(mohCanceledOrder.getUserPhone());

        return view;

    }
    //创建ViewHolder类
    class ViewHolder{

        TextView userName;

        TextView orderTime;

        TextView userPhone;

    }
}
