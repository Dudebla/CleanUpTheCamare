package com.example.front_end_of_clean_up_the_camera_app.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.front_end_of_clean_up_the_camera_app.UserFragment.CUHChatFragment;
import com.example.front_end_of_clean_up_the_camera_app.UserFragment.CUHMainFragment;
import com.example.front_end_of_clean_up_the_camera_app.UserFragment.CUHOrderFragment;

public class ContentUserHomeFragmentAdapter extends FragmentPagerAdapter {

    public ContentUserHomeFragmentAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;

        //  return new value of item due to fragment
        switch (i){
            case 0:
                //  user home
                fragment = new CUHMainFragment();
                break;
            case 1:
                //  order searching
                fragment = new CUHOrderFragment();
                break;
            case 2:
                //  chat
                fragment = new CUHChatFragment();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
