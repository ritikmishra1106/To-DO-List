package com.ritik.todolist;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class user_adapter extends RecyclerView.Adapter<user_adapter.ViewHolder> {

    Context context;
    ArrayList<data_model>listData;
    public user_adapter(Context context,ArrayList<data_model>listData){
        this.context=context;
        this.listData=listData;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtNameOutput.setText(listData.get(position).name);
        holder.txtMsgOutput.setText(listData.get(position).Msg);

        holder.llMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder =  new AlertDialog.Builder(context)
                        .setTitle("Delete Message")
                        .setMessage("Are you sure want to delete this list")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.show();
                return true;
            }
        });



    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameOutput,txtMsgOutput;
        LinearLayout llMain;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNameOutput=itemView.findViewById(R.id.txtNameOutput);
            txtMsgOutput=itemView.findViewById(R.id.txtMsgOutput);
            llMain=itemView.findViewById(R.id.llMain);

        }
    }
}
