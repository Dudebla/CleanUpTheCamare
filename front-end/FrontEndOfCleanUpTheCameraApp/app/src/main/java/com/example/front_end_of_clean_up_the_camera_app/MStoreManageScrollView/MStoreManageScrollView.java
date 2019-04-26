package com.example.front_end_of_clean_up_the_camera_app.MStoreManageScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class MStoreManageScrollView extends ScrollView {


    public MStoreManageScrollView(Context context) {
        super(context);
    }

    public MStoreManageScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MStoreManageScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        View view = (View) getChildAt(getChildCount() - 1);

        int d = view.getBottom();

        d -= (getHeight() + getScrollY());

        if ((d == 0) && (onScrollBottomListener != null)) {
            onScrollBottomListener.onScrollBottom();
        }
    }

    public OnScrollBottomListener onScrollBottomListener = null;

    public interface OnScrollBottomListener {
        void onScrollBottom();
    }

    public void setOnScrollBottomListener(OnScrollBottomListener onScrollBottomListener) {
        this.onScrollBottomListener = onScrollBottomListener;
    }


}
