package com.example.front_end_of_clean_up_the_camera_app.Tools;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;

import com.example.front_end_of_clean_up_the_camera_app.R;
import com.wang.avi.AVLoadingIndicatorView;

public class LoadingWindow extends Dialog {

    private AVLoadingIndicatorView avi;


    public LoadingWindow(Context context){

        super(context);

        getWindow().setBackgroundDrawable(new BitmapDrawable(getContext().getResources()));
        setContentView(R.layout.loading_view_layout);
        avi = findViewById(R.id.avi);
        this.setCanceledOnTouchOutside(false);

    }


    @Override
    public void show(){

        super.show();
        this.avi.smoothToShow();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        this.avi.smoothToHide();
    }

    @Override
    public void onBackPressed() {

    }
}
