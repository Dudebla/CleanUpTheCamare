package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MStoreManageIncomeRecordFragmentAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MechantData.MStoreManageIncomeRecord;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MSMIncomeRecordFragment extends Fragment {

    private ListView listView;

    private List<MStoreManageIncomeRecord> datas = new ArrayList<MStoreManageIncomeRecord>();




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initDatas();

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_morder_mstore_manage_income_record, container, false);

        ButterKnife.bind(this, view);

        listView=view.findViewById(R.id.lv_mStoreIncomeRecord);

        MStoreManageIncomeRecordFragmentAdapter mStoreManageUserCommentFragmentAdapter=new MStoreManageIncomeRecordFragmentAdapter(getActivity(),datas);

        listView.setAdapter(mStoreManageUserCommentFragmentAdapter);


        return view;

    }

    private void initDatas() {
        MStoreManageIncomeRecord order0 = new MStoreManageIncomeRecord("小李","2019年4月24日","12￥","000000");
        MStoreManageIncomeRecord order1 = new MStoreManageIncomeRecord("小黑","2019年4月24日","12￥","000000");
        MStoreManageIncomeRecord order2 = new MStoreManageIncomeRecord("小红","2019年4月24日","12￥","000000");
        MStoreManageIncomeRecord order3 = new MStoreManageIncomeRecord("小白","2019年4月24日","12￥","000000");
        MStoreManageIncomeRecord order4 = new MStoreManageIncomeRecord("小兰","2019年4月24日","12￥","000000");
        MStoreManageIncomeRecord order5 = new MStoreManageIncomeRecord("小小","2019年4月24日","12￥","000000");
        MStoreManageIncomeRecord order6 = new MStoreManageIncomeRecord("小明","2019年4月24日","12￥","000000");
        MStoreManageIncomeRecord order7 = new MStoreManageIncomeRecord("小明","2019年4月24日","12￥","000000");
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
