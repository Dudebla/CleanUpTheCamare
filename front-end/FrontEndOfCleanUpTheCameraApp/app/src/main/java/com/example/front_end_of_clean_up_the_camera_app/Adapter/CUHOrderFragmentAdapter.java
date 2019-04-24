package com.example.front_end_of_clean_up_the_camera_app.Adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ImageView;

import com.example.front_end_of_clean_up_the_camera_app.UserFragment.CUHChatFragment;
import com.example.front_end_of_clean_up_the_camera_app.UserFragment.CUHOrderManageFragment;

import java.util.ArrayList;
import java.util.List;

public class CUHOrderFragmentAdapter extends FragmentPagerAdapter {

    //  tab text
    private List<String> names;

    public CUHOrderFragmentAdapter(FragmentManager fm){

        super(fm);

        this.names = new ArrayList<>();
    }

    //  set tab text
    public void setList(List<String> datas){

        this.names.clear();

        this.names.addAll(datas);

        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = null;



        fragment = new CUHOrderManageFragment();
        Bundle bundle = new Bundle();

        bundle.putString("name", names.get(i));

        bundle.putInt("type", i);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    //  return tab text
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String plateName = names.get(position);

        if(plateName == null){
            plateName = "";
        }
        else if(plateName.length() > 15){
            plateName = plateName.substring(1, 15) + "...";
        }

        return plateName;
    }
}
