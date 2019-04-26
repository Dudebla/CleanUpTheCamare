package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.front_end_of_clean_up_the_camera_app.DropDownMenu.DropDownMenu;
import com.example.front_end_of_clean_up_the_camera_app.MechantAdapter.MOrderInquryContentFragmentAdapter;
import com.example.front_end_of_clean_up_the_camera_app.MechantData.MOrderInqury;
import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;


//商家订单查询页面
public class MOrderInquryFragment extends Fragment {

    DropDownMenu mDropDownMenu;

    private String headers[] = {"日期"};

    private int[] types = new int[]{DropDownMenu.TYPE_LIST_DATE};

    private String date[] = {"不限", "近两天", "近一周", "近一个月", "近三个月", "近半年", "近一年"};

    //用于展示列表内容
    private ListView listView;

    private List<MOrderInqury> datas = new ArrayList<MOrderInqury>();

    private MOrderInquryContentFragmentAdapter mOrderInquryContentFragmentAdapter;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initDatas();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_morder_inqury, container, false);
        //绑定页面
        ButterKnife.bind(this, view);

        mDropDownMenu=  view.findViewById(R.id.DropDownMenu);

        initView();

        return view;

    }

    //初始化View视图
    private void initView() {

        View contentView = getLayoutInflater().inflate(R.layout.fragment_morder_inqury_drop_down_menu_content, null);

        listView=contentView.findViewById(R.id.lv_morderInqury);

        MOrderInquryContentFragmentAdapter mOrderInquryContentFragmentAdapter=new MOrderInquryContentFragmentAdapter(getActivity(),datas);

        listView.setAdapter(mOrderInquryContentFragmentAdapter);

        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), initViewData(), contentView);
        //该监听回调只监听默认类型
        mDropDownMenu.addMenuSelectListener(new DropDownMenu.OnDefaultMenuSelectListener() {

            @Override
            public void onSelectDefaultMenu(int index, int pos, String clickstr) {
                //index:点击的tab索引，pos：单项菜单中点击的位置索引，clickstr：点击位置的字符串
                Toast.makeText(getActivity(), clickstr, Toast.LENGTH_SHORT).show();

            }

        });


    }

    /**
     * 设置类型和数据源：
     * DropDownMenu.KEY对应类型（DropDownMenu中的常量，参考上述核心源码）
     * DropDownMenu.VALUE对应数据源：key不是TYPE_CUSTOM则传递string[],key是TYPE_CUSTOM类型则传递对应view
     */
    private List<HashMap<String, Object>> initViewData() {

        List<HashMap<String, Object>> viewDatas = new ArrayList<>();

        HashMap<String, Object> map;

        for (int i = 0; i < headers.length; i++) {

            map = new HashMap<String, Object>();
            //设置下拉菜单类型
            map.put(DropDownMenu.KEY, types[i]);
            //设置下拉菜单内容的值
            map.put(DropDownMenu.VALUE, date);

            map.put(DropDownMenu.SELECT_POSITION,2);

            viewDatas.add(map);

        }

        return viewDatas;

    }


//String orderTime,String userName,String userPhone,String userComment,String TransactionAmount,String orderNumber
    private void initDatas() {
        MOrderInqury order0 = new MOrderInqury("2019-04-22","小黑","12345678","nice","12￥","00000000");
        MOrderInqury order1 = new MOrderInqury("2019-04-22","小红","12345678","nice","12￥","00000000");
        MOrderInqury order2 = new MOrderInqury("2019-04-22","小李","12345678","nice","12￥","00000000");
        MOrderInqury order3 = new MOrderInqury("2019-04-22","小白","12345678","nice","12￥","00000000");
        MOrderInqury order4 = new MOrderInqury("2019-04-22","小兰","12345678","balabala","12￥","00000000");
        MOrderInqury order5 = new MOrderInqury("2019-04-22","小黄","12345678","哈哈啊哈哈哈","12￥","00000000");
        datas.add(order0);
        datas.add(order1);
        datas.add(order2);
        datas.add(order3);
        datas.add(order4);
        datas.add(order5);
    }

}
