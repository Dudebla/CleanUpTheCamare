package com.example.front_end_of_clean_up_the_camera_app;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.front_end_of_clean_up_the_camera_app.Adapter.DiscussMessageAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.DiscussMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seller_Msg_Activity extends AppCompatActivity{

    private List<DiscussMessage> discussMessageList;
    private Button make_order_button;
    private Button make_chat_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seller_msg_layout);

        //  set top bar of view
        Toolbar toolbar = (Toolbar)findViewById(R.id.seller_msg_toolbar);
        setSupportActionBar(toolbar);
        setTitle("blabla");


        //  init button
        make_order_button = findViewById(R.id.seller_msg_makeOrder_button);
        make_chat_button = findViewById(R.id.seller_msg_makeChat_button);

        final ActionBar actionBar =  getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //  set button onClicked event
        setButtonOnClickedLinstener();


        //  set discussion recyclerView
        RecyclerView dmRecyclerView;
        DiscussMessageAdapter discussMessageAdapter;
        initDiscussMessageList();
        dmRecyclerView = (RecyclerView)findViewById(R.id.seller_msg_discuss_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dmRecyclerView.setLayoutManager(linearLayoutManager);

        discussMessageAdapter = new DiscussMessageAdapter(this, discussMessageList);

        dmRecyclerView.setAdapter(discussMessageAdapter);


    }


    private void initDiscussMessageList(){
        discussMessageList = new ArrayList<>();

        String userDiscussion = "blablablablablablablablablablablablablablablablablablablablablablablabla" +
                "blablablablablablablablablablablablablablablabla";
        DiscussMessage discussMessage = new DiscussMessage("李*华", new Date(),"4.9", "服务很认真，很满意");
        discussMessageList.add(discussMessage);
        discussMessage = new DiscussMessage("王*", new Date(),"4.8", "下单之后等了很久才派人过来检查，好在服务态度很认真，挺好的");
        discussMessageList.add(discussMessage);
        discussMessage = new DiscussMessage("林*梅", new Date(),"4.8", "出门在外还是要多注意隐私安全啊，第一次使用这个app，有专业认真检查之后住酒店放心安心多了！");
        discussMessageList.add(discussMessage);
        discussMessage = new DiscussMessage("username", new Date(),"4.9", "blablabla");
        discussMessageList.add(discussMessage);
        discussMessage = new DiscussMessage("username", new Date(),"4.9", userDiscussion);
        discussMessageList.add(discussMessage);
        discussMessage = new DiscussMessage("username", new Date(),"4.9", userDiscussion);
        discussMessageList.add(discussMessage);
        discussMessage = new DiscussMessage("username", new Date(),"4.9", userDiscussion+userDiscussion);
        discussMessageList.add(discussMessage);
        discussMessage = new DiscussMessage("username", new Date(),"4.9", "blablabla");
        discussMessageList.add(discussMessage);
        discussMessage = new DiscussMessage("username", new Date(),"4.9", userDiscussion);
        discussMessageList.add(discussMessage);
    }

    private void setButtonOnClickedLinstener(){
        make_order_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "make_order_button", Toast.LENGTH_SHORT).show();
            }
        });
        make_chat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "make_chat_button", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
