package com.example.front_end_of_clean_up_the_camera_app.DropDownMenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.front_end_of_clean_up_the_camera_app.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//自定义DropDownMenu控件
public class DropDownMenu extends LinearLayout {

    //顶部菜单布局
    private LinearLayout tabMenuView;
    //底部容器，包含popupMenuViews，maskView
    private FrameLayout containerView;
    //弹出菜单父布局
    private FrameLayout popupMenuViews;
    //遮罩半透明View，点击可关闭DropDownMenu
    private View maskView;
    //tabMenuView里面选中的tab位置，-1表示未选中
    private int current_tab_position = -1;
    //分割线颜色
    //private int dividerColor = 0xffcccccc;
    //tab选中颜色
    private int textSelectedColor = 0xff890c85;
    //tab未选中颜色
    private int textUnselectedColor = 0xff111111;
    //遮罩颜色
    private int maskColor = 0x88888888;
    //tab字体大小
    private int menuTextSize = 14;
    //最大高度
    private int menuMaxHeight = -1;

    private boolean needSetSelectedColor = false;
    //tab选中图标
    private int menuSelectedIcon;
    //tab未选中图标
    private int menuUnselectedIcon;

    //构造方法
    public DropDownMenu(Context context) {
        super(context, null);
    }

    public DropDownMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropDownMenu(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        //设置线性布局方向
        setOrientation(VERTICAL);
        //为DropDownMenu添加自定义属性
        //设置背景颜色
        int menuBackgroundColor = 0xffffffff;
        //下划线颜色
        int underlineColor = 0xffcccccc;
        //从layout 设置的属性中获取 attrs 中的属性。
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DropDownMenu);
        //设置空间的颜色、字体、大小等属性
        textSelectedColor = a.getColor(R.styleable.DropDownMenu_ddtextSelectedColor, textSelectedColor);

        needSetSelectedColor = a.getBoolean(R.styleable.DropDownMenu_ddneedSetSlectedColor, needSetSelectedColor);

        textUnselectedColor = a.getColor(R.styleable.DropDownMenu_ddtextUnselectedColor, textUnselectedColor);

        menuBackgroundColor = a.getColor(R.styleable.DropDownMenu_ddmenuBackgroundColor, menuBackgroundColor);

        maskColor = a.getColor(R.styleable.DropDownMenu_ddmaskColor, maskColor);

        menuTextSize = a.getDimensionPixelSize(R.styleable.DropDownMenu_ddmenuTextSize, menuTextSize);

        menuMaxHeight = a.getDimensionPixelSize(R.styleable.DropDownMenu_ddmenuMaxHeight, menuMaxHeight);

        menuSelectedIcon = a.getResourceId(R.styleable.DropDownMenu_ddmenuSelectedIcon, menuSelectedIcon);

        menuUnselectedIcon = a.getResourceId(R.styleable.DropDownMenu_ddmenuUnselectedIcon, menuUnselectedIcon);

        a.recycle();

        //初始化tabMenuView并添加到tabMenuView
        tabMenuView = new LinearLayout(context);

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        tabMenuView.setOrientation(HORIZONTAL);

        tabMenuView.setBackgroundColor(menuBackgroundColor);

        tabMenuView.setLayoutParams(params);

        addView(tabMenuView, 0);

        //为tabMenuView添加下划线
        View underLine = new View(getContext());

        underLine.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpTpPx(1.0f)));

        underLine.setBackgroundColor(underlineColor);

        addView(underLine, 1);

        //初始化containerView并将其添加到DropDownMenu
        containerView = new FrameLayout(context);
        //为展示页面设置布局参数
        containerView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        addView(containerView, 2);

    }
    //默认选择监听？？
    public interface OnDefaultMenuSelectListener {

        void onSelectDefaultMenu(int index, int pos, String clickstr);

    }

    private OnDefaultMenuSelectListener listener;

    public void addMenuSelectListener(OnDefaultMenuSelectListener lis) {
        this.listener = lis;
    }
    //下拉菜单类型
    public static final String KEY = "type_key";
    //下拉菜单内容的值
    public static final String VALUE = "type_value";
    //选择位置
    public static final String SELECT_POSITION = "type_position";

    //一共包含四中类型：三种默认和自定义
    public static final int TYPE_LIST_DATE = 1;


    /**
     * 初始化DropDownMenu
     *
     * @param tabTexts    tab标签字符串集合
     * @param viewDatas   每个tab标签对应的类型和数据源
     * @param contentView 内容展示主页面view
     */
    public void setDropDownMenu(@NonNull List<String> tabTexts, @NonNull List<HashMap<String, Object>> viewDatas, @NonNull View contentView) {
        //tab长度与view长度不一致，抛出异常
        if (tabTexts.size() != viewDatas.size()) {

            throw new IllegalArgumentException("params not match, tabTexts.size() should be equal viewDatas.size()");

        }
        //为顶部下拉筛选菜单添加筛选类型
        for (int i = 0; i < tabTexts.size(); i++) {

            addTab(tabTexts, i);

        }
       //页面显示内容
        containerView.addView(contentView, 0);
        maskView = new View(getContext());
        //为中间灰色层设置布局参数（下拉之后的背景灰色）
        maskView.setLayoutParams(new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
       //设置背景颜色
        maskView.setBackgroundColor(maskColor);
       //设置点击监听事件
        maskView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView) tabMenuView.getChildAt
                        (current_tab_position)).setTextColor(textUnselectedColor);
                closeMenu();
            }
        });
        containerView.addView(maskView, 1);
        maskView.setVisibility(GONE);
        //下设置拉菜单显示属性
        popupMenuViews = new FrameLayout(getContext());
        popupMenuViews.setVisibility(GONE);
        containerView.addView(popupMenuViews, 2);
        View view = null;
        for (int i = 0; i < viewDatas.size(); i++) {

            HashMap<String, Object> map = viewDatas.get(i);

            int key = (int) map.get(KEY);

            Object value = map.get(VALUE);

            int select_position = -1;

            try {

                select_position = (int) map.get(SELECT_POSITION);

            } catch (Exception e) {
            }

            if (select_position != -1 && select_position < 0) {

                throw new IllegalArgumentException("the select_position must be >= 0");

            }


            switch (key) {

                case TYPE_LIST_DATE:

                    if (value instanceof String[] && select_position < ((String[]) value).length)
                        //自定义view
                        view = setDateListView((String[]) value, i, select_position);

                    else

                        throw new IllegalArgumentException("the type TYPE_LIST_CITY should mapping String[] and the select_position must be < array length");

                    break;

            }
            //设置下拉选择菜单参数
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, menuMaxHeight == -1 ? ViewGroup.LayoutParams.WRAP_CONTENT : menuMaxHeight));

            popupMenuViews.addView(view, i);

        }

    }
    //设置VityListView视图
    private View setDateListView(final String[] arr, final int index, int select_position) {

        ListView view = new ListView(getContext());
        //设置分割线高度
        view.setDividerHeight(0);
        //新建适配器
        final GirdDropDownAdapter adapter = new GirdDropDownAdapter(getContext(), Arrays.asList(arr));

        if (select_position != -1) {

            adapter.setCheckItem(select_position);

            setTabText(index, arr[select_position]);

        }

        view.setAdapter(adapter);
        //设置点击监听
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                adapter.setCheckItem(position);

                setTabText(current_tab_position, arr[position]);

                closeMenu();

                listener.onSelectDefaultMenu(index, position, adapter.getItem(position));

            }
        });

        return view;
    }

    //设置ListView视图
    private View setSimpleListView(final String[] arr, final int index, int select_position) {

        ListView view = new ListView(getContext());

        view.setDividerHeight(0);

        final ListDropDownAdapter adapter = new ListDropDownAdapter(getContext(), Arrays.asList(arr));

        if (select_position != -1) {

            adapter.setCheckItem(select_position);

            setTabText(index, arr[select_position]);

        }

        view.setAdapter(adapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                adapter.setCheckItem(position);

                setTabText(current_tab_position, arr[position]);

                closeMenu();

                listener.onSelectDefaultMenu(index, position, adapter.getItem(position));

            }
        });

        return view;

    }
    //设置GridView视图
    private View setGridView(final String[] arr, final int index, int select_position) {

        final ConstellationAdapter adapter = new ConstellationAdapter(getContext(), Arrays.asList(arr));

        LayoutInflater li = LayoutInflater.from(getContext());

        View v = li.inflate(R.layout.morder_drop_menu_grid_layout, null);

        GridView grid = (GridView) v.findViewById(R.id.constellation);

        if (select_position != -1) {

            adapter.setCheckItem(select_position);

            setTabText(index, arr[select_position]);

        }

        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                adapter.setCheckItem(position);

                setTabText(current_tab_position, arr[position]);

                closeMenu();

                listener.onSelectDefaultMenu(index, position, adapter.getItem(position));

            }
        });

        return v;

    }
    //增加Tab
    private void addTab(@NonNull List<String> tabTexts, int i) {
        //设置tab的属性
        final TextView tab = new TextView(getContext());

        tab.setSingleLine();

        tab.setEllipsize(TextUtils.TruncateAt.END);

        tab.setGravity(Gravity.CENTER);

        tab.setTextSize(TypedValue.COMPLEX_UNIT_PX, menuTextSize);

        tab.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));

        tab.setTextColor(textUnselectedColor);

        tab.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(menuUnselectedIcon), null);

        tab.setText(tabTexts.get(i));

        tab.setPadding(dpTpPx(5), dpTpPx(12), dpTpPx(5), dpTpPx(12));
        //添加点击事件
        tab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switchMenu(tab);
            }
        });
       //为顶部tabMenu添加tab视图
        tabMenuView.addView(tab);

        tabMenuView.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);

        tabMenuView.setDividerDrawable(getResources().getDrawable(R.drawable.morder_inqury_divider_line));

    }

    /**
     * 改变tab文字
     *
     * @param text
     */
    public void setTabText(int tabIndex, String text) {

        if (tabIndex != -1) {

            if (needSetSelectedColor) {

                ((TextView) tabMenuView.getChildAt(tabIndex)).setTextColor(textSelectedColor);

            } else {

                ((TextView) tabMenuView.getChildAt(tabIndex)).setTextColor(textUnselectedColor);

            }

            ((TextView) tabMenuView.getChildAt(tabIndex)).setText(text);

        }

    }

    //设置tab可点击
    public void setTabClickable(boolean clickable) {

        for (int i = 0; i < tabMenuView.getChildCount(); i = i + 2) {

            tabMenuView.getChildAt(i).setClickable(clickable);

        }

    }

    /**
     * 关闭菜单
     */
    public void closeMenu() {

        if (current_tab_position != -1) {

            ((TextView) tabMenuView.getChildAt(current_tab_position)).setCompoundDrawablesWithIntrinsicBounds(null, null,
                    getResources().getDrawable(menuUnselectedIcon), null);
        //设置点击下拉菜单关闭
            popupMenuViews.setVisibility(View.GONE);

            popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_out));
        //设置点击灰色背景关闭菜单
            maskView.setVisibility(GONE);

            maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_out));
        //还原tab位置
            current_tab_position = -1;

        }

    }

    /**
     * DropDownMenu是否处于可见状态
     *
     * @return
     */
    public boolean isShowing() {
        return current_tab_position != -1;
    }

    /**
     * 切换菜单
     *
     * @param target
     */
    private void switchMenu(View target) {

        for (int i = 0; i < tabMenuView.getChildCount(); i++) {

            if (target == tabMenuView.getChildAt(i)) {

                if (current_tab_position == i) {
            //关闭menu
                    closeMenu();

                } else {

                    if (current_tab_position == -1) {
                        //设置下拉菜单视图可见
                        popupMenuViews.setVisibility(View.VISIBLE);

                        popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_in));
                        //设置灰色背景可见
                        maskView.setVisibility(VISIBLE);

                        maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_in));

                        popupMenuViews.getChildAt(i).setVisibility(View.VISIBLE);

                    } else {

                        popupMenuViews.getChildAt(i).setVisibility(View.VISIBLE);

                    }
                    //更换当前tab_position值
                    current_tab_position = i;

                    ((TextView) tabMenuView.getChildAt(i)).setTextColor(textSelectedColor);

                    ((TextView) tabMenuView.getChildAt(i)).setCompoundDrawablesWithIntrinsicBounds(null, null,

                            getResources().getDrawable(menuSelectedIcon), null);

                }

            } else {
//                ((TextView) tabMenuView.getChildAt(i)).setTextColor(textUnselectedColor);
                ((TextView) tabMenuView.getChildAt(i)).setCompoundDrawablesWithIntrinsicBounds(null, null,
                        getResources().getDrawable(menuUnselectedIcon), null);

                popupMenuViews.getChildAt(i).setVisibility(View.GONE);

            }

        }

    }
        //用于设置展示属性
    public int dpTpPx(float value) {

        DisplayMetrics dm = getResources().getDisplayMetrics();

        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, dm) + 0.5);

    }

}
