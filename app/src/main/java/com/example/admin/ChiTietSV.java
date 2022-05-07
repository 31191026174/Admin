package com.example.admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChiTietSV extends AppCompatActivity {
    TextView tvTen, tvDC, tvSDT, tvMSSV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_tamtru);

        Intent intent1 = getIntent();
        Bundle bundle = intent1.getBundleExtra("chitietsinhvien");
        final String ten = bundle.getString("ten");
        final String dc = bundle.getString("diachi");
        final String dt = bundle.getString("dt");
        final String ms = bundle.getString("masv");

        tvTen = (TextView) findViewById(R.id.tvten);
        tvDC = (TextView) findViewById(R.id.tvDiaCHi);
        tvSDT = (TextView) findViewById(R.id.tvDT);
        tvMSSV = (TextView) findViewById(R.id.tvMASSV);

        tvTen.setText(ten);
        tvDC.setText(dc);
        tvSDT.setText(dt);
        tvMSSV.setText(ms);

//        tvTen.setText("Vu Dinh Kien");
//        tvDC.setText("TDP. nguyen xa 2- Minh Khai- Bac Tu Liem- HN");
//        tvSDT.setText("0969699999");
//        tvMSSV.setText("132898989");


    }
}
