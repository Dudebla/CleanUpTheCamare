package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MechantChatFragmentAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MechantData.MChat;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

//商家聊天子页
public class MChatFragment extends Fragment {


    private ListView listView;

    private List<MChat> datas = new ArrayList<MChat>();


    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initDatas();

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mchat, container, false);

        ButterKnife.bind(this, view);

        listView=view.findViewById(R.id.lv_mChat);

        MechantChatFragmentAdapter mechantChatFragmentAdapter=new MechantChatFragmentAdapter(getActivity(),datas);

        listView.setAdapter(mechantChatFragmentAdapter);

        return view;

    }



    //String orderTime,String reciveTime,String userName,String userPhone,String userAddress,String userRemarks,String estimatedAmount,int userImage) {
    private void initDatas() {
        MChat order0 = new MChat("小明","12:35","你好",R.drawable.user_image);
        MChat order1 = new MChat("小红","13:05","请问现在下单大概什么时候都能到？",R.drawable.user_image);
        MChat order2 = new MChat("小兰","15:00","好的谢谢",R.drawable.user_image);
        MChat order3 = new MChat("小黑","15:04","能尽快来检查吗",R.drawable.user_image);
        MChat order4 = new MChat("小兵","15:22","好的",R.drawable.user_image);
        MChat order5 = new MChat("小黄","15:46","不用谢",R.drawable.user_image);
        datas.add(order0);
        datas.add(order1);
        datas.add(order2);
        datas.add(order3);
        datas.add(order4);
        datas.add(order5);
    }


    //private static final String TAG = ChatConnThread.class.getSimpleName();
    private Context mContext;
    private Socket socket;
    //输入输出流保持唯一，不要多次创建，避免错误
    private ObjectOutputStream out;
    private ObjectInputStream in;


}
