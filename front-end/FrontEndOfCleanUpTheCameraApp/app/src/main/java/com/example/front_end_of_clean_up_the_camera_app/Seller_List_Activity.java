package com.example.front_end_of_clean_up_the_camera_app;

/*Seller_List_Activity  --  seller_item_layout.xml
*   smRecyclerView: RecyclerView of seller_list_layout
*   sellerItemAdapter: sellerAdapter of seller_item
*   sellerMessageList: List<sellerMessage> */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Seller_List_Activity extends AppCompatActivity {

    private RecyclerView smRecyclerView;
    private SellerItemAdapter sellerItemAdapter;
    private List<SellerMessage> sellerMessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seller_list_layout);


        initSellerMesssageList();

        smRecyclerView = (RecyclerView)findViewById(R.id.seller_list_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        smRecyclerView.setLayoutManager(linearLayoutManager);

        sellerItemAdapter = new SellerItemAdapter(this, sellerMessageList);
        sellerItemAdapter.setSellerItemOnClickerListener(new SellerItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(), "position " + position + " is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        smRecyclerView.setAdapter(sellerItemAdapter);


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
}
