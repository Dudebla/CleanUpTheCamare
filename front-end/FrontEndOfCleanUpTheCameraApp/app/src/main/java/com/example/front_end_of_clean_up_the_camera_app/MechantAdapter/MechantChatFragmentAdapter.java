package com.example.front_end_of_clean_up_the_camera_app.MechantAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.MechantData.MChat;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.List;

public class MechantChatFragmentAdapter extends BaseAdapter {


    private Context context;

    private List<MChat> datas;

    //构造函数需要传入两个必要的参数：上下文对象和数据源
    public MechantChatFragmentAdapter(Context context,List<MChat> datas) {

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

        MChat mChat= (MChat) getItem(position);

        View view;
        //创建内部类ViewHolder，可以避免每次调用getView方法
        MechantChatFragmentAdapter.ViewHolder viewHolder;

        if(convertView==null){

            view = LayoutInflater.from(context).inflate(R.layout.fragment_mchat_child,null);

            viewHolder=new MechantChatFragmentAdapter.ViewHolder();

            viewHolder.chatName=(TextView)view.findViewById(R.id.tv_mChatName);

            viewHolder.chatDate=(TextView)view.findViewById(R.id.tv_mChatDate) ;

            viewHolder.chatLatestMessage=(TextView)view.findViewById(R.id.tv_mChatLatestMessage);

            viewHolder.chatImage=(ImageView)view.findViewById(R.id.iv_mChatImage);

            view.setTag(viewHolder);
        }

        else{

            view=convertView;

            viewHolder= (MechantChatFragmentAdapter.ViewHolder) view.getTag();

        }

        viewHolder.chatName.setText(mChat.getChatName());

        viewHolder.chatDate.setText(mChat.getChatDate());

        viewHolder.chatLatestMessage.setText(mChat.getChatLatestMessage());

        viewHolder.chatImage.setImageResource(mChat.getChatImage());

        return view;

    }
    //创建ViewHolder类
    class ViewHolder{

        TextView chatName;

        TextView chatDate;

        TextView chatLatestMessage;

        ImageView chatImage;

    }
}
