package com.example.front_end_of_clean_up_the_camera_app.Tools;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import com.example.front_end_of_clean_up_the_camera_app.R;
import com.wang.avi.AVLoadingIndicatorView;

public class LoadingWindow extends Dialog {

    private View parView;
    private AVLoadingIndicatorView avi;


    public LoadingWindow(Context context){

        super(context);

        getWindow().setBackgroundDrawable(new BitmapDrawable(getContext().getResources()));
        setContentView(R.layout.loading_view_layout);
        avi = findViewById(R.id.avi);
        this.setCanceledOnTouchOutside(false);


//        this.parView = view;
//
//        this.setContentView(View.inflate(view.getContext(), R.layout.loading_view_layout, null));
//        this.getContentView().measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
//        this.avi = (AVLoadingIndicatorView)getContentView().findViewById(R.id.avi);
//        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//        this.setFocusable(false);
//        this.setOutsideTouchable(true);
//        this.setBackgroundDrawable(new BitmapDrawable(view.getContext().getResources()));
//
//        this.setTouchInterceptor(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

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
