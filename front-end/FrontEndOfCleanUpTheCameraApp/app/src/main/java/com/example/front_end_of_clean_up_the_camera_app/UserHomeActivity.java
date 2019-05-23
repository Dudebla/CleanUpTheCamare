package com.example.front_end_of_clean_up_the_camera_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.front_end_of_clean_up_the_camera_app.Adapter.ContentUserHomeFragmentAdapter;
import com.example.front_end_of_clean_up_the_camera_app.UserFragment.CUHOrderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AMapLocationListener {

    private SwitchCompat sound_switcher;
    private SwitchCompat shake_switcher;
    private TextView userName_TextView;
    private TextView userLocation_TextView;

    //  title
    private final int[] USER_TAB_TITLE = new int[]{
            R.string.user_home, R.string.user_order, R.string.user_chat};
    private final int[] USER_TAB_IMGS = new int[]{R.drawable.tab_morder_userhome_selector,
            R.drawable.tab_morder_inqury_selector, R.drawable.tab_morder_chat_selector};

    @BindView(R.id.content_user_home_pager)
    ViewPager viewPager;
    @BindView(R.id.content_user_home_tabLayout)
    TabLayout tabLayout;

    //  pager adapter
    private PagerAdapter pagerAdapter;

    //  for location
    private AMapLocationClient aMapLocationClient = null;
    private AMapLocationClientOption aMapLocationClientOption = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home_layout);



        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        String userName  = sharedPreferences.getString("userName", "");
        int userType = sharedPreferences.getInt("userType", -1);
        String userId = sharedPreferences.getString("userId", "");
        String location = sharedPreferences.getString("location", "");

        //  init Location
        initLocation();

        //  bind
        ButterKnife.bind(this);

        //  init pager
        initPager();

        setTitle("主页");

        setTabs(tabLayout, getLayoutInflater(), USER_TAB_TITLE, USER_TAB_IMGS);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //  set username, set userLocation
        View headerView = navigationView.getHeaderView(0);
        userName_TextView = headerView.findViewById(R.id.nav_userName_textView);
        userName_TextView.setText(userName);
        userLocation_TextView = headerView.findViewById(R.id.nav_userLocation_textView);
        userLocation_TextView.setText(location);

        Menu menu = navigationView.getMenu();
        MenuItem menuItem = menu.findItem(R.id.nav_sound);
        View actionView  = MenuItemCompat.getActionView(menuItem);
        

        sound_switcher = (SwitchCompat)actionView.findViewById(R.id.nav_sound);
        sound_switcher.setChecked(true);
        sound_switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(buttonView.getContext(), "onCheckChanged", Toast.LENGTH_SHORT).show();
                if(isChecked){
                    //  enable the sound of app
                    Toast.makeText(buttonView.getContext(), "onCheckChanged" + String.valueOf(isChecked), Toast.LENGTH_SHORT).show();

                }else{
                    //  disable the sound
                    Toast.makeText(buttonView.getContext(), "onCheckChanged" + String.valueOf(isChecked), Toast.LENGTH_SHORT).show();

                }
            }
        });

        menuItem = menu.findItem(R.id.nav_shake);
        actionView  = MenuItemCompat.getActionView(menuItem);
        shake_switcher = (SwitchCompat)actionView.findViewById(R.id.nav_shake);
        shake_switcher.setChecked(true);
        shake_switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(buttonView.getContext(), "onCheckChanged", Toast.LENGTH_SHORT).show();
                if(isChecked){
                    //  enable the sound of app
                    Toast.makeText(buttonView.getContext(), "onCheckChanged" + String.valueOf(isChecked), Toast.LENGTH_SHORT).show();

                }else{
                    //  disable the sound
                    Toast.makeText(buttonView.getContext(), "onCheckChanged" + String.valueOf(isChecked), Toast.LENGTH_SHORT).show();

                }
            }
        });

        Boolean toOrderFragment = getIntent().getBooleanExtra("toOrderFragment", false);
        if(toOrderFragment){
            tabLayout.getTabAt(1).select();
        }


    }

    private void setTabs(TabLayout tablayout, LayoutInflater inflater, int[] tabTitles, int[] tabImages){
        for(int i = 0; i < tabTitles.length; i++){
            TabLayout.Tab tab = tabLayout.newTab();
            View view = inflater.inflate(R.layout.item_main_menu, null);
            tab.setCustomView(view);

            TextView textViewTitle = (TextView)view.findViewById(R.id.txt_tab);
            textViewTitle.setText(tabTitles[i]);

            ImageView imageViewTab =(ImageView)view.findViewById(R.id.img_tab);
            imageViewTab.setImageResource(tabImages[i]);

            tabLayout.addTab(tab);
        }
    }

    private void initPager(){

        pagerAdapter = new ContentUserHomeFragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);

        //  change bing
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), false);
                switch (tab.getPosition()){
                    case 0:
                        setTitle("主页");
                        break;
                    case 1:
                        setTitle("订单");
                        break;
                    case 2:
                        setTitle("消息");
                        break;
                    default:
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.location_action) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_sound:
                sound_switcher.setChecked(!sound_switcher.isChecked());
                Snackbar.make(item.getActionView(), (sound_switcher.isChecked()) ? "is checked" : "not checked", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                Toast.makeText(this.getApplicationContext(), "tag nav_sound", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_shake:
                Toast.makeText(this.getApplicationContext(), "tag nav_shake", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_feedback:
                Toast.makeText(this.getApplicationContext(), "tag nav_feedback", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_help:
                Toast.makeText(this.getApplicationContext(), "tag nav_help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about:
                Toast.makeText(this.getApplicationContext(), "tag nav_about", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout://log out
                SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().apply();
                Intent intent = new Intent(UserHomeActivity.this, LogIn_Activity.class);
                startActivity(intent);
                finish();
                break;
                default:
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initLocation(){

        //  init location param
        AMapLocationClient.setApiKey("67681b729e757654d7984604d1c54c7a");// set aMap api key
        aMapLocationClient = new AMapLocationClient(getApplicationContext());
        aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClient.setLocationListener(this);//  set location listener
        //  locationMode: high_accuracy, .., device_sensors
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        aMapLocationClientOption.setInterval(2000); //  default = 2000ms
        aMapLocationClientOption.setOnceLocation(true);//   location once time, default = false
        aMapLocationClientOption.setOnceLocationLatest(true);// return best location in 3s while location
        aMapLocationClient.setLocationOption(aMapLocationClientOption);//   set option
        aMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        if(aMapLocationClient != null){
            aMapLocationClient.setLocationOption(aMapLocationClientOption);
            aMapLocationClient.stopLocation();
        }
        aMapLocationClient.startLocation();
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if(aMapLocation.getErrorCode() == 0){
                //  set location at nav_page
                String location = aMapLocation.getAddress();
                SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("location", location).apply();
                if(userLocation_TextView != null){
                    userLocation_TextView.setText(location);
                }

            }else{
                Log.e("AMapError", "location Error, ErrCode:" + aMapLocation.getErrorCode() + "errorInfo: " + aMapLocation.getErrorInfo());
            }
        }
    }

    @Override
    protected void onDestroy() {//destroy locationClient
        super.onDestroy();
        aMapLocationClient.unRegisterLocationListener(this);
        aMapLocationClient = null;
    }

}
