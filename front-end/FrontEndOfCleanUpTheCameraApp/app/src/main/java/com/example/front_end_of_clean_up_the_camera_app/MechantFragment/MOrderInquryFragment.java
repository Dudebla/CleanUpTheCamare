package com.example.front_end_of_clean_up_the_camera_app.MechantFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.front_end_of_clean_up_the_camera_app.DropDownMenu.DropDownMenu;
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

    // private String headers[] = {"日期", "年龄", "性别", "星座"};
//    private int[] types = new int[]{DropDownMenu.TYPE_LIST_CITY, DropDownMenu.TYPE_LIST_SIMPLE, DropDownMenu.TYPE_CUSTOM, DropDownMenu.TYPE_GRID};
    // private String ages[] = {"不限", "18岁以下", "18-22岁", "23-26岁", "27-35岁", "35岁以上"};
    //private String constellations[] = {"不限", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_morder_inqury, container, false);
        //绑定页面
        ButterKnife.bind(this, view);

        mDropDownMenu=  view.findViewById( R.id.DropDownMenu);

        initView();

        return view;

    }

    //初始化View视图
    private void initView() {

        View contentView = getLayoutInflater().inflate(R.layout.fragment_morder_inqury_drop_down_menu_content, null);

        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), initViewData(), contentView);
        //该监听回调只监听默认类型
        mDropDownMenu.addMenuSelectListener(new DropDownMenu.OnDefaultMenuSelectListener() {

            @Override
            public void onSelectDefaultMenu(int index, int pos, String clickstr) {
                //index:点击的tab索引，pos：单项菜单中点击的位置索引，clickstr：点击位置的字符串
//                Toast.makeText(getBaseContext(), clickstr, Toast.LENGTH_SHORT).show();
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

//            switch (types[i]) {
//
//                case DropDownMenu.TYPE_LIST_CITY:
//
//                    map.put(DropDownMenu.VALUE, citys);
//
//                    map.put(DropDownMenu.SELECT_POSITION,2);
//
//                    break;

//                case DropDownMenu.TYPE_LIST_SIMPLE:
//
//                    map.put(DropDownMenu.VALUE, ages);
//
//                    map.put(DropDownMenu.SELECT_POSITION,5);
//
//                    break;

//                case DropDownMenu.TYPE_GRID:
//
//                    map.put(DropDownMenu.VALUE, constellations);
//
//                    break;

//                default:
//
//                    map.put(DropDownMenu.VALUE, getCustomView());
//
//                    break;

//            }

            viewDatas.add(map);

        }

        return viewDatas;

    }

        //获取自定义下拉菜单视图
//    private View getCustomView() {
//
//        View v = getLayoutInflater().inflate(R.layout.morder_inqury_drop_down_menu_custom, null);
//
//        TextView btn = (TextView) v.findViewById(R.id.btn);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                mDropDownMenu.setTabText(2,"自定义");//设置tab标签文字
//
//                mDropDownMenu.closeMenu();//关闭menu
//
//            }
//        });
//
//        return v;
//    }


//    @Override
//    public void onBackPressed() {
//        //退出activity前关闭菜单
//        if (mDropDownMenu.isShowing()) {
//            mDropDownMenu.closeMenu();
//        } else {
//            super.onBackPressed();
//        }
//    }


}
