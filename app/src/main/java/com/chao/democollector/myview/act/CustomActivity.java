package com.chao.democollector.myview.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chao.democollector.R;

/**
 * Created by Jeffery on 17/9/11.
 */

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }
}
