package com.ceye.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.ceye.adapter.MyAdapter;

public class MainActivity extends Activity {
    /** RecyclerView对象 */
    private RecyclerView recyclerView;
    /** 图片资源 */
    private int[] mDataset;
    private MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // 初始化图片数据
        mDataset = new int[] { R.drawable.a, R.drawable.b, //
                R.drawable.c, R.drawable.d, R.drawable.e, //
                R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i };
        // 设置布局管理器
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(4,1);
//        GridLayoutManager manager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);
        myAdapter=new MyAdapter(mDataset);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_LONG).show();;
            }
        });
    }
}
