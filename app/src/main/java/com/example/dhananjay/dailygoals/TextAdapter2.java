package com.example.dhananjay.dailygoals;

/**
 * Created by kmurali on 13-04-2018.
 */

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

public class TextAdapter2 extends RecyclerView.Adapter<TextAdapter2.ViewHolder> {

    private Context mcontext;
    private ArrayList<Items2> item2List;


    TextAdapter2(Context context,ArrayList<Items2> list){
        mcontext=context;
        item2List=list;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){

        LayoutInflater layoutInflater=LayoutInflater.from(mcontext);
        View view=layoutInflater.inflate(R.layout.items2,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Items2 item=item2List.get(position);
        ImageView image2=holder.image2;
        image2.setImageResource(item.getImage());



    }



    @Override
    public int getItemCount() {
        return item2List.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image2;

        public ViewHolder(View itemView){
            super(itemView);
            image2=itemView.findViewById(R.id.image2);


        }
    }
}



