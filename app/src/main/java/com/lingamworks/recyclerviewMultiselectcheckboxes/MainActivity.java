package com.lingamworks.recyclerviewMultiselectcheckboxes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
List<String> sourcelist;
List<String> selectedlist;
private RecyclerView mRecyclerView;
private RecyclerView.LayoutManager mLayoutManager;
private adapter madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sourcelist=new ArrayList<>();
        sourcelist.add("Object 1");
        sourcelist.add("Object 2");
        sourcelist.add("Object 3");
        sourcelist.add("Object 4");
        sourcelist.add("Object 5");
        sourcelist.add("Object 6");
        sourcelist.add("Object 7");
        sourcelist.add("Object 8");
        mRecyclerView=findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        madapter = new adapter(sourcelist, getApplicationContext(),mRecyclerView);
        mRecyclerView.setAdapter(madapter);
    }
    public void getData(View V){
        selectedlist=madapter.listofselectedactivites();
        Log.d("list",selectedlist.toString()) ;}
}
