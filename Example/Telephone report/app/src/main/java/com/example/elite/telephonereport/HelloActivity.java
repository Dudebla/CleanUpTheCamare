package com.example.elite.telephonereport;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class HelloActivity extends AppCompatActivity {

    private ImageView qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        qr = findViewById(R.id.QR);
        Bitmap bitmap = QRCodeUtil.createQRCodeBitmap("https://www.baidu.com", 480, 480);
        qr.setImageBitmap(bitmap);
    }
}
