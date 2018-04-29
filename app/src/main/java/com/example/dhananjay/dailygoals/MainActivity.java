package com.example.dhananjay.dailygoals;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.stephentuso.welcome.WelcomeHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    ArrayList<Items> itemList;
    ArrayList<Items1> item1List;
    ArrayList<Items2> item2List;
    ArrayList<Items3> item3List;

    // Variable to create a Welcome Screen

    private WelcomeHelper welcomeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView1=(RecyclerView)findViewById(R.id.recyclerView1);
        recyclerView2=(RecyclerView)findViewById(R.id.recyclerView2);
        recyclerView3=(RecyclerView)findViewById(R.id.recyclerView3);
        itemList=new ArrayList<>();
        item1List=new ArrayList<>();
        item2List=new ArrayList<>();
        item3List=new ArrayList<>();
        itemList.add(new Items("TODAY"));
        itemList.add(new Items("TOMORROW"));
        itemList.add(new Items("NEXT DAY"));
        item1List.add(new Items1("BREAKFAST"+"\n"+"8:00"));
        item1List.add(new Items1("STUDY"+"\n"+"9:00"));
        item1List.add(new Items1("LUNCH"+"\n"+"12:00"));
        item1List.add(new Items1("STUDY"+"\n"+"3:00"));
        item1List.add(new Items1("GAMES"+"\n"+"6:00"));
        item1List.add(new Items1("DINNER"+"\n"+"9:00"));
        item2List.add(new Items2(R.drawable.tick));
        item2List.add(new Items2(R.drawable.wrong));
        item3List.add(new Items3(R.drawable.achievements));

        LinearLayoutManager layoutmanager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager rvlayoutmanager=layoutmanager;
        recyclerView.setLayoutManager(rvlayoutmanager);
        TextAdapter adapter=new TextAdapter(this,itemList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutmanager1=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager rvlayoutmanager1=layoutmanager1;
        recyclerView1.setLayoutManager(rvlayoutmanager1);
        TextAdapter1 adapter1=new TextAdapter1(this,item1List);
        recyclerView1.setAdapter(adapter1);

        LinearLayoutManager layoutmanager2=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager rvlayoutmanager2=layoutmanager2;
        recyclerView2.setLayoutManager(rvlayoutmanager2);
        TextAdapter2 adapter2=new TextAdapter2(this,item2List);
        recyclerView2.setAdapter(adapter2);

        LinearLayoutManager layoutmanager3=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager rvlayoutmanager3=layoutmanager3;
        recyclerView3.setLayoutManager(rvlayoutmanager3);
        TextAdapter3 adapter3=new TextAdapter3(this,item3List);
        recyclerView3.setAdapter(adapter3);
        
         ItemClickSupport.addTo( recyclerView ).setOnItemClickListener( new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                startActivity( new Intent(MainActivity.this,TodayActivity.class) );
            }
        } );





        recyclerView2.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView2, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well


                if(position == 0)
                {
                    Intent intent = new Intent(getApplicationContext(), Goals_Completed.class);
                    startActivity(intent);
                }
                if(position == 1)
                {
                    Intent intent = new Intent(getApplicationContext(), Goals_Missed.class);
                    startActivity(intent);
                }

            }
            @Override
            public void onLongClick(View view, int position) {

                if(position == 0)
                {
                    Toast.makeText(getApplicationContext(), "Daily Goals Completed by You",
                        Toast.LENGTH_SHORT).show();
                }
                if(position == 1)
                {
                    Toast.makeText(getApplicationContext(), "Daily Goals Missed by You",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }));
        recyclerView3.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView3, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well



                    Intent intent = new Intent(getApplicationContext(), Achievements.class);
                    startActivity(intent);


            }
            @Override
            public void onLongClick(View view, int position) {


                    Toast.makeText(getApplicationContext(), "Your Achievements",
                            Toast.LENGTH_SHORT).show();

            }
        }));

        // Show the welcome screen
        welcomeScreen = new WelcomeHelper(this, WelcomeScreenActivity.class);
        welcomeScreen.show(savedInstanceState);
    }


    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener){

            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeScreen.onSaveInstanceState(outState);
    }
}
