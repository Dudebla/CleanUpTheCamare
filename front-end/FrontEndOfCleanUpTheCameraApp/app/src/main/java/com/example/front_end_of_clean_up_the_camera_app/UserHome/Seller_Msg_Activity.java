package com.example.front_end_of_clean_up_the_camera_app.UserHome;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.front_end_of_clean_up_the_camera_app.Adapter.DiscussMessageAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.DiscussMessage;
import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.SellerMessage;
import com.example.front_end_of_clean_up_the_camera_app.R;
import com.example.front_end_of_clean_up_the_camera_app.Tools.LoadingWindow;
import com.example.front_end_of_clean_up_the_camera_app.Tools.ServerConnection;
import com.example.front_end_of_clean_up_the_camera_app.UserHomeActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.os.Handler;

public class Seller_Msg_Activity extends AppCompatActivity{

    public static final int SETDETAIL = 0;
    public static final int MAKEORDER_SUCCESS = 1;
    public static final int MAKEORDER_FAIL = 2;

    private List<DiscussMessage> discussMessageList;
    private TextView sellerName_textView;
    private TextView sellerAddress_textView;
    private TextView sellerStatu_textView;
    private TextView sellerScore_textView;
    private TextView sellerCost_textView;
    private Button make_order_button;
    private Button make_chat_button;



    private LoadingWindow loadingWindow = null;
    private String userId = null;
    private String sellerId = null;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SETDETAIL://get seller message detail
                    Bundle bundle = msg.getData();
                    SellerMessage sellerMessage = (SellerMessage)bundle.getSerializable("sellerMsg");
                    setDetail(sellerMessage);
                    if(loadingWindow != null){
                        loadingWindow.dismiss();
                        loadingWindow = null;
                    }
                    break;
                case MAKEORDER_SUCCESS://success send order message to backend, turn to order fragment
                    if(loadingWindow != null){
                        loadingWindow.dismiss();
                        loadingWindow = null;
                    }
                    Intent intent = new Intent(Seller_Msg_Activity.this, UserHomeActivity.class);
                    break;
                case MAKEORDER_FAIL://
                    if(loadingWindow != null){
                        loadingWindow.dismiss();
                        loadingWindow = null;
                    }
                    Toast.makeText(getApplicationContext(), "下单失败，请重试", Toast.LENGTH_SHORT).show();

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seller_msg_layout);

        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        userId = sharedPreferences.getString("userId", "");
        sharedPreferences = getSharedPreferences("seller", Context.MODE_PRIVATE);
        sellerId = sharedPreferences.getString("sellerId", "");

        sellerName_textView = (TextView)findViewById(R.id.seller_msg_sellerName_textView);
        sellerAddress_textView = (TextView)findViewById(R.id.seller_msg_sellerAddress_textView);
        sellerStatu_textView = (TextView)findViewById(R.id.seller_msg_sellerStatu_textView);
        sellerScore_textView = (TextView)findViewById(R.id.seller_msg_sellerScore_textView);
        sellerCost_textView = (TextView)findViewById(R.id.seller_msg_sellerCost_textView);

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



        loadingWindow = new LoadingWindow(this);
        loadingWindow.show();

        getDetail();


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
                makeOrder();
            }
        });
        make_chat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "make_chat_button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //get init data of seller message
    private void getDetail(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = new ServerConnection("getShopInfo", "POST").getConnection();
                BufferedReader reader = null;
                try{
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.connect();

                    OutputStream outputStream = connection.getOutputStream();
                    String orderMsg = "id=" + sellerId;
                    outputStream.write(orderMsg.getBytes());
                    outputStream.flush();
                    outputStream.close();

                    InputStream inputStream = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder respond = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        respond.append(line);
                    }
                    JSONObject jsonObject = new JSONObject(respond.toString());
                    String result = jsonObject.getString("result");
                    if(result != null){
                        switch (result){
                            case "200":
                                String score = jsonObject.getString("score");
                                String address = jsonObject.getString("address");
                                String intro = jsonObject.getString("intro");
                                String name = jsonObject.getString("name");
                                String status = jsonObject.getString("status");
                                SellerMessage sellerMessage = new SellerMessage(sellerId, name, intro, address, "0.1", score, "100", status);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("sellerMsg", sellerMessage);
                                Message msg = new Message();
                                msg.what = SETDETAIL;
                                msg.setData(bundle);
                                handler.sendMessage(msg);
                                break;
                            case "404":
                                break;
                            default:
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    Log.e("getShopInfo", e + e.getMessage());
                }
            }
        }).start();
    }

    private void setDetail(SellerMessage sellerMessage){

        sellerName_textView.setText(sellerMessage.getSellerName());
        sellerAddress_textView.setText(sellerMessage.getSellerAddress());
        sellerStatu_textView.setText(sellerMessage.getStatus());
        sellerScore_textView.setText(sellerMessage.getSellerScore());
        sellerCost_textView.setText(sellerMessage.getSellerCost());

    }

    private void makeOrder(){
        loadingWindow = new LoadingWindow(this);
        loadingWindow.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = new ServerConnection("makeOrder", "POST").getConnection();
                BufferedReader reader = null;
                try{

                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.connect();

                    OutputStream outputStream = connection.getOutputStream();
                    String orderMsg = "userId=" + userId + "&sellerId=" + sellerId;
                    outputStream.write(orderMsg.getBytes());
                    outputStream.flush();
                    outputStream.close();

                    InputStream inputStream = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder respond = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        respond.append(line);
                    }
                    JSONObject jsonObject = new JSONObject(respond.toString());
                    String result = jsonObject.getString("result");
                    if(result != null){
                        switch (result){
                            case "200":
                                break;
                            case "404":
                                break;
                            default:
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    Log.e("makeOrderError: ", e + e.getMessage());
                }
            }
        }).start();
    }

}
