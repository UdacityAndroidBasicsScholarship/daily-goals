package com.example.dhananjay.dailygoals;

/**
 * Created by kmurali on 13-04-2018.
 */

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

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

public class TextAdapter3 extends RecyclerView.Adapter<TextAdapter3.ViewHolder> {

    private Context mcontext;
    private ArrayList<Items3> item3List;


    TextAdapter3(Context context,ArrayList<Items3> list){
        mcontext=context;
        item3List=list;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){

        LayoutInflater layoutInflater=LayoutInflater.from(mcontext);
        View view=layoutInflater.inflate(R.layout.items3,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Items3 item=item3List.get(position);
        ImageView image3=holder.image3;
        image3.setImageResource(item.getImage());



    }



    @Override
    public int getItemCount() {
        return item3List.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image3;

        public ViewHolder(View itemView){
            super(itemView);
            image3=itemView.findViewById(R.id.image3);


        }
    }
}





