package com.example.front_end_of_clean_up_the_camera_app.MechantAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.MechantData.MStoreManageUserComment;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.List;

public class MStoreManageUserCommentFragmentAdapter extends BaseAdapter {

    private Context context;
    private List<MStoreManageUserComment> datas;

    //构造函数需要传入两个必要的参数：上下文对象和数据源
    public MStoreManageUserCommentFragmentAdapter(Context context,List<MStoreManageUserComment> datas) {

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

        MStoreManageUserComment mStoreManageUserComment= (MStoreManageUserComment) getItem(position);

        View view;
        //创建内部类ViewHolder，可以避免每次调用getView方法
        MStoreManageUserCommentFragmentAdapter.ViewHolder viewHolder;

        if(convertView==null){

            view = LayoutInflater.from(context).inflate(R.layout.fragment_morder_mstore_manage_user_comment_child,null);

            viewHolder=new MStoreManageUserCommentFragmentAdapter.ViewHolder();

            viewHolder.userName=(TextView)view.findViewById(R.id.tv_mStoreUserCommentUserName) ;

            viewHolder.commentContent=(TextView)view.findViewById(R.id.tv_mStoreUserCommentContent);

            viewHolder.commentDate=(TextView)view.findViewById(R.id.tv_mStoreUserCommentDate);

            viewHolder.commentGrade=(TextView)view.findViewById(R.id.tv_mStoreUserCommentGrade);

            view.setTag(viewHolder);
        }

        else{

            view=convertView;

            viewHolder= (MStoreManageUserCommentFragmentAdapter.ViewHolder) view.getTag();

        }

        viewHolder.userName.setText(mStoreManageUserComment.getUserName());

        viewHolder.commentGrade.setText(mStoreManageUserComment.getCommentGrade());

        viewHolder.commentContent.setText(mStoreManageUserComment.getCommentContent());

        viewHolder.commentDate.setText(mStoreManageUserComment.getCommentDate());

        return view;

    }
    //创建ViewHolder类
    class ViewHolder{

        TextView userName;

        TextView commentContent;

        TextView commentDate;

        TextView commentGrade;

    }

}
