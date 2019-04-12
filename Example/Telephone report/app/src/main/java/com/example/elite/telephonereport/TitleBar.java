package com.example.elite.telephonereport;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


public class TitleBar extends LinearLayout {

    private PopupWindow pop;
    private Button menu;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;

    public TitleBar(Context context,AttributeSet attrs)
    {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title_bar,this);
        menu = findViewById(R.id.menu);
        menu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(v);
            }
        });
    }

    private void showPopupWindow(View v)
    {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.menu, null, false);
        final Button shopsignup,businesssignup,about;
        shopsignup = view.findViewById(R.id.shopsignup);
        businesssignup = view.findViewById(R.id.businesssignup);
        about = view.findViewById(R.id.about);
        pop = new PopupWindow(view,ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT,true);
        pop.setTouchable(true);
        pop.showAsDropDown(v,0,0);

        shopsignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ShopSignUpActivity.class);
                getContext().startActivity(intent);
                pop.dismiss();
            }
        });

        businesssignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AdminSignUpActivity.class);
                getContext().startActivity(intent);
                pop.dismiss();

            }
        });

        about.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                builder = new AlertDialog.Builder(getContext());
                alert = builder.setTitle("About")
                        .setMessage("@SCNU\n\tTover Elite Run")
                        .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setCancelable(false)
                        .create();
                alert.show();
            }
        });
    }

}
