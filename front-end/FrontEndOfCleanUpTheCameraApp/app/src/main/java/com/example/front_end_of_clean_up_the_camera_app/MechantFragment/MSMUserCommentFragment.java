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
        MStoreManageUserComment order0 = new MStoreManageUserComment("小李","5.0","goodgoodgoodgoodgoodgood","2019年4月24日");
        MStoreManageUserComment order1 = new MStoreManageUserComment("小黑","5.0","","2019年4月24日");
        MStoreManageUserComment order2 = new MStoreManageUserComment("小红","5.0","啦啦","2019年4月24日");
        MStoreManageUserComment order3 = new MStoreManageUserComment("小白","5.0","棒","2019年4月24日");
        MStoreManageUserComment order4 = new MStoreManageUserComment("小兰","5.0","赞","2019年4月24日");
        MStoreManageUserComment order5 = new MStoreManageUserComment("小小","5.0","还可以","2019年4月24日");
        MStoreManageUserComment order6 = new MStoreManageUserComment("小明","5.0","还可以","2019年4月24日");
        MStoreManageUserComment order7 = new MStoreManageUserComment("小明","5.0","还可以","2019年4月24日");
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
