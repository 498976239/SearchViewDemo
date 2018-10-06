package com.ss.www.searchviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SearchView mSearchView;
    private List<String> mList = new ArrayList();
    private MyAdapter adapter;
    private List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setQueryHint("请输入关键字");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                list = Filter(mList,newText);
                adapter.setFilter(list);
                return true;
            }
        });
    }

    private void initData() {
        mList.add("qqq");
        mList.add("www");
        mList.add("eee");
        mList.add("rrr");
        mList.add("幼儿园");
        mList.add("小学");
        mList.add("uuu");
        mList.add("太阳");

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        mSearchView = (SearchView) findViewById(R.id.search);
        adapter = new MyAdapter(this,mList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private List<String> Filter(List<String> mList, String str){
        if (list != null){
            list.clear();
        }
        for (String str2 : mList){
            if (str2.contains(str)){
                list.add(str2);
            }
        }
        return list;
    }
}
