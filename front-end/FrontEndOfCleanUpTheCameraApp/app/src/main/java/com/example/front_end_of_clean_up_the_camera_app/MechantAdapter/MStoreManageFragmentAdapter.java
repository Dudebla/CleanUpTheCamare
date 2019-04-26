package com.example.front_end_of_clean_up_the_camera_app.MechantAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.MechantData.MStoreManageMessage;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.List;

public class MStoreManageFragmentAdapter extends BaseAdapter {

    private Context context;
    private List<MStoreManageMessage> datas;

    //构造函数需要传入两个必要的参数：上下文对象和数据源
    public MStoreManageFragmentAdapter(Context context,List<MStoreManageMessage> datas) {

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

        MStoreManageMessage mStoreManageMessage= (MStoreManageMessage) getItem(position);

        View view;
        //创建内部类ViewHolder，可以避免每次调用getView方法
        MStoreManageFragmentAdapter.ViewHolder viewHolder;

        if(convertView==null){

            view = LayoutInflater.from(context).inflate(R.layout.fragment_mstore_manage,null);

            viewHolder=new MStoreManageFragmentAdapter.ViewHolder();

            viewHolder.MechantImage=(ImageView)view.findViewById(R.id.iv_mechantImage);

            viewHolder.MechantAddress=(TextView)view.findViewById(R.id.tv_mechantAddress);

            viewHolder.MechantName=(TextView)view.findViewById(R.id.tv_mechantName);

            viewHolder.MechantServiceGrade=(TextView)view.findViewById(R.id.tv_mechantServiceGrade) ;

            viewHolder.MechantStoreCondition=(TextView)view.findViewById(R.id.tv_mechantStoreCondition);

            view.setTag(viewHolder);
        }

        else{

            view=convertView;

            viewHolder= (MStoreManageFragmentAdapter.ViewHolder) view.getTag();

        }

        viewHolder.MechantName.setText(mStoreManageMessage.getMechantName());

        viewHolder.MechantAddress.setText(mStoreManageMessage.getMechantAddress());

        viewHolder.MechantStoreCondition.setText(mStoreManageMessage.getMechantStoreCondition());

        viewHolder.MechantServiceGrade.setText(mStoreManageMessage.getMechantServiceGrade());

        viewHolder.MechantImage.setImageResource(mStoreManageMessage.getMechantImage());

        return view;

    }
    //创建ViewHolder类
    class ViewHolder{

        ImageView MechantImage;

        TextView MechantName;

        TextView MechantAddress;

        TextView MechantStoreCondition;

        TextView MechantServiceGrade;

    }

}


