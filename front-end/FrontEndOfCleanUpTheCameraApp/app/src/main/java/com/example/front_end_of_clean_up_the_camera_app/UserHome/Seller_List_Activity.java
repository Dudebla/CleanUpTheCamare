package com.example.front_end_of_clean_up_the_camera_app.UserHome;

/*Seller_List_Activity  --  seller_item_layout.xml
*   smRecyclerView: RecyclerView of seller_list_layout
*   sellerItemAdapter: sellerAdapter of seller_item
*   sellerMessageList: List<sellerMessage> */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.Toolbar;

import com.example.front_end_of_clean_up_the_camera_app.Adapter.SellerItemAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MessageCalss.SellerMessage;
import com.example.front_end_of_clean_up_the_camera_app.R;
import com.example.front_end_of_clean_up_the_camera_app.Tools.ServerConnection;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class Seller_List_Activity extends AppCompatActivity {

    private RecyclerView smRecyclerView;
    private SellerItemAdapter sellerItemAdapter;
    private List<SellerMessage> sellerMessageList;
    private String userName;
    private String location;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seller_list_layout);

        getUserMassage();

        //  send request for sellers' message
        sendRequset();
        //  loading

        //  set toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.seller_list_toolBar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("选择商家");
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        initSellerMesssageList();

        smRecyclerView = (RecyclerView)findViewById(R.id.seller_list_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        smRecyclerView.setLayoutManager(linearLayoutManager);

        //  manage item clicked even
        sellerItemAdapter = new SellerItemAdapter(this, sellerMessageList);
        sellerItemAdapter.setSellerItemOnClickerListener(new SellerItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(Seller_List_Activity.this, Seller_Msg_Activity.class);
                startActivity(intent);
            }
        });

        smRecyclerView.setAdapter(sellerItemAdapter);


    }

    private void getUserMassage(){
        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        userName = sharedPreferences.getString("userName", "");
        location = sharedPreferences.getString("location", "");
    }

    //      init the sellerMessageList
    private void initSellerMesssageList(){
//          init massage for test
        sellerMessageList = new ArrayList<SellerMessage>();
        SellerMessage sellerMessage = new SellerMessage("0","第一个商家名字","blablablablablablabla","距离2.3km","4.5","￥50.00");
        sellerMessageList.add(sellerMessage);
        sellerMessage = new SellerMessage("1","第二个商家名字","blablablablablablabla","距离1.2km","5.0","￥40.00");
        sellerMessageList.add(sellerMessage);
        sellerMessage = new SellerMessage("2","第三个商家名字","blablablablabl","距离0km","3.9","￥50.00");
        sellerMessageList.add(sellerMessage);
        sellerMessage = new SellerMessage("3","第四个商家名字aaaa",
                "blablablablablablablabbbbbbbbbbbbbbbbbbbbbbbbbbbbb","距离2.3km","4.5","￥100.00");
        sellerMessageList.add(sellerMessage);
        sellerMessage = new SellerMessage("4","第555555555个商家名字","blablablablabl555555555555555ablabla","距离1.2km","5.0","￥1000.00");
        sellerMessageList.add(sellerMessage);
        sellerMessage = new SellerMessage("5","第666666666666个商家名字","blablablablabl","距离0km","3.9","￥5000.00");
        sellerMessageList.add(sellerMessage);
    }

    private void sendRequset(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader;
                try{
                    connection = new ServerConnection("getSellerList", "POST").getConnection();
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.connect();

                    OutputStream outputStream = connection.getOutputStream();
                    String sendMsg = "userName=" + userName + "&location=" + location;
                    outputStream.write(sendMsg.getBytes());
                    outputStream.flush();
                    outputStream.close();

                    InputStream inputStream = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder respond = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        respond.append(line);
                    }

                    JSONObject jsonObject = new JSONObject(respond.toString());
                    Log.d("sellerList", respond.toString());

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
                    Log.e("CUHMainFragment", e + e.getMessage());
                }
            }
        }).start();

    }
}
