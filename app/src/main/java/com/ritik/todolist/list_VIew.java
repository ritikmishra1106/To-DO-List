package com.ritik.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class list_VIew extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList <data_model>listData=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        recyclerView=findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(list_VIew.this);
        recyclerView.setLayoutManager(layoutManager);

        Cursor  c = new user_database(this).getInfo();
        while(c.moveToNext()){
            data_model d=new data_model(c.getString(1),c.getString(2));
            listData.add(d);

        }

        user_adapter adapter = new user_adapter(list_VIew.this,listData);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}