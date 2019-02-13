package com.rz.usagesexamplcollection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rz.librarycollection.utils.DateUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DateUtils.getGMTToLocalTime("", "", "");
    }
}
