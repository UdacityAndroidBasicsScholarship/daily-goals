package com.example.dhananjay.dailygoals;

/**
 * Created by kmurali on 13-04-2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kmurali on 11-04-2018.
 */

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {

    private Context mcontext;
    private ArrayList<Items> itemList;


    TextAdapter(Context context,ArrayList<Items> list){
        mcontext=context;
        itemList=list;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){

        LayoutInflater layoutInflater=LayoutInflater.from(mcontext);
        View view=layoutInflater.inflate(R.layout.items,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Items item=itemList.get(position);
        TextView text=holder.text;
        text.setText(item.getText());



    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView text;

        public ViewHolder(View itemView){
            super(itemView);
            text=itemView.findViewById(R.id.text);


        }
    }
}

