package com.example.front_end_of_clean_up_the_camera_app.Adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ImageView;

import com.example.front_end_of_clean_up_the_camera_app.UserFragment.CUHChatFragment;

import java.util.ArrayList;
import java.util.List;

public class CUHOrderFragmentAdapter extends FragmentPagerAdapter {

    //  tab text
    private List<String> names;

    private List<ImageView> imageViews;

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
//
//        switch (i){
//            case 0:
//                //  order waiting paying
//
//                break;
//            case 1:
//                //  order waiting server
//
//                break;
//            case 2:
//                //  order had send
//
//                break;
//            case 3:
//                //  order history
//
//                break;
//            default:
//        }

        fragment = new CUHChatFragment();
        Bundle bundle = new Bundle();

        bundle.putString("name", names.get(i));

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
