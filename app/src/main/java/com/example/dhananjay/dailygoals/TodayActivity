package com.example.dhananjay.dailygoals;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class TodayActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText nameField;
    Spinner spin;
    String[] Names = {"Health & fitness", "Study", "Job", "Sport", "Others"};
    TextView time;
    TimePicker simpleTimePicker;
    Button simpleButton1 , simpleButton2;
    CheckBox simpleCheckBox;
    CalendarView simpleCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_today );
        nameField = (EditText) findViewById(R.id.simple_editText);
        String name = nameField.getText().toString();
        //  time = (TextView) findViewById(R.id.time);
        // initiate a check box
        simpleCheckBox = (CheckBox) findViewById(R.id.simpleCheckBox);

        spin = (Spinner) findViewById(R.id.simple_spinner);
        spin.setOnItemSelectedListener(TodayActivity.this);

//Creating the ArrayAdapter instance having the name list

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Names);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner

        spin.setAdapter(aa);


        simpleTimePicker = (TimePicker) findViewById(R.id.simpleTimePicker);
        simpleTimePicker.setIs24HourView(false); // used to display AM/PM mode
// perform set on time changed listener event
        simpleTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
// display a toast with changed values of time picker
                Toast.makeText(getApplicationContext(), hourOfDay + " " + minute, Toast.LENGTH_SHORT).show();
                //   time.setText("Time is :: " + hourOfDay + " : " + minute); // set the current time in text view
            }
        });

        simpleTimePicker.setIs24HourView(false); // used to display AM/PM mode
// perform set on time changed listener event
        simpleTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
// display a toast with changed values of time picker
                Toast.makeText(getApplicationContext(), hourOfDay + " " + minute, Toast.LENGTH_SHORT).show();
                //   time.setText("Time is :: " + hourOfDay + " : " + minute); // set the current time in text view
            }
        });

        CalendarView simpleCalendarView = ( CalendarView ) findViewById ( R . id . simpleCalendarView ); //get the reference of CalendarView
        simpleCalendarView . setFirstDayOfWeek ( 2 ); // set Monday as the first day of the week
        simpleCalendarView . setSelectedDateVerticalBar ( getResources (). getDrawable ( R.drawable.ic_launcher_background )); // set the drawable for the vertical bar
        simpleCalendarView . setSelectedWeekBackgroundColor ( Color. BLACK ); // set black color in the background of selected week

        {
            simpleButton1= ( Button ) findViewById(R . id . simpleButton1); //get id of button 1
            simpleButton2= ( Button ) findViewById( R . id . simpleButton2 ); //get id of button 2
            simpleButton1 . setOnClickListener ( new View. OnClickListener () {
                @Override
                public void onClick ( View view) {
                    Toast . makeText ( getApplicationContext (), "Simple Button 1" ,
                            Toast . LENGTH_LONG ). show (); //display the text of button1
                }
            });
            simpleButton2 . setOnClickListener ( new View . OnClickListener () {
                @Override
                public void onClick ( View view ) {
                    Toast . makeText ( getApplicationContext (), "Simple Button 2" ,
                            Toast . LENGTH_LONG ). show (); //display the text of button2
                }
            });
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        /* Toast.makeText(getApplicationContext(), Names[], Toast.LENGTH_LONG).show();*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
