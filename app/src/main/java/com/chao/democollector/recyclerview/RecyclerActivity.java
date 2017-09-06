package com.chao.democollector.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.chao.democollector.R;
import com.chao.democollector.recyclerview.adapter.WeatherAdapter;
import com.chao.democollector.recyclerview.divider.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<String> mDatas;
    private WeatherAdapter mWeatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        initData();
        //此处是线性布局，设置横向或是纵向
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mRecyclerView.setAdapter(mWeatherAdapter = new WeatherAdapter(this, mDatas));

    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

}
