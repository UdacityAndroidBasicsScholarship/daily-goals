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

public class TextAdapter1 extends RecyclerView.Adapter<TextAdapter1.ViewHolder> {

    private Context mcontext;
    private ArrayList<Items1> item1List;


    TextAdapter1(Context context,ArrayList<Items1> list){
        mcontext=context;
        item1List=list;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){

        LayoutInflater layoutInflater=LayoutInflater.from(mcontext);
        View view=layoutInflater.inflate(R.layout.items1,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Items1 item=item1List.get(position);
        TextView text=holder.text1;
        text.setText(item.getText());



    }



    @Override
    public int getItemCount() {
        return item1List.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView text1;

        public ViewHolder(View itemView){
            super(itemView);
            text1=itemView.findViewById(R.id.text1);


        }
    }
}


