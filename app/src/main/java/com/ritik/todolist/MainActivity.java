package com.ritik.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    EditText edtName,edtMsg;;
    AppCompatButton btnsbt;
    FloatingActionButton btnView;
    user_database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new user_database(MainActivity.this);
        FindActivityId();

        btnsbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String msg = edtMsg.getText().toString();

                if (!name.isEmpty() && !msg.isEmpty()){
                    boolean check  = db.insert_data(name,msg);
                    if (check == true){
                        Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                        edtName.setText("");
                        edtMsg.setText("");
                    }else{
                        Toast.makeText(MainActivity.this, "Data Not Saved", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Please Fill All Boxes", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,list_VIew.class));
            }
        });

    }



    private void FindActivityId() {
        edtName=findViewById(R.id.edtName);
        edtMsg=findViewById(R.id.edtMsg);
        btnsbt=findViewById(R.id.btnsbt);
        btnView=findViewById(R.id.btnList);
    }
}