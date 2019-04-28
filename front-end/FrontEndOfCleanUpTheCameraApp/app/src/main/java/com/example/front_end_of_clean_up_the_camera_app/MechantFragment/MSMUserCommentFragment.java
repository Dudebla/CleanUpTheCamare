package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MStoreManageUserCommentFragmentAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MechantData.MStoreManageUserComment;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MSMUserCommentFragment extends Fragment {

    private ListView listView;

    private List<MStoreManageUserComment> datas = new ArrayList<MStoreManageUserComment>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initDatas();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_morder_mstore_manage_user_comment, container, false);

        ButterKnife.bind(this, view);

        listView=view.findViewById(R.id.lv_mStoreUserManage);

        MStoreManageUserCommentFragmentAdapter mStoreManageUserCommentFragmentAdapter=new MStoreManageUserCommentFragmentAdapter(getActivity(),datas);

        listView.setAdapter(mStoreManageUserCommentFragmentAdapter);

        return view;

    }

   // String userName,String commentGrade,String commentContent,String commentDate
    private void initDatas() {
        MStoreManageUserComment order0 = new MStoreManageUserComment("小李","5.0","检查很认真，值得信赖","2019年4月24日");
        MStoreManageUserComment order1 = new MStoreManageUserComment("小黑","4.6","","2019年4月25日");
        MStoreManageUserComment order2 = new MStoreManageUserComment("小红","3.7","来的速度太慢了，还催了店家几次","2019年4月26日");
        MStoreManageUserComment order3 = new MStoreManageUserComment("小白","4.6","第一次体验，蛮新奇的","2019年4月26日");
        MStoreManageUserComment order4 = new MStoreManageUserComment("小兰","5.0","居然能查出来了，太意外了","2019年4月27日");
        MStoreManageUserComment order5 = new MStoreManageUserComment("小小","3.3","还可以吧","2019年4月28日");
        MStoreManageUserComment order6 = new MStoreManageUserComment("小明","4.1","","2019年4月29日");
        MStoreManageUserComment order7 = new MStoreManageUserComment("小明","4.4","","2019年4月29日");
        datas.add(order0);
        datas.add(order1);
        datas.add(order2);
        datas.add(order3);
        datas.add(order4);
        datas.add(order5);
        datas.add(order6);
        datas.add(order7);
    }




}
