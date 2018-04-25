package com.example.dhananjay.dailygoals;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class TodayActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText nameField;
    Spinner spin;
    String[] Names = {"Health & fitness", "Study", "Job", "Sport", "Others"};
    TextView time;
    TimePicker simpleTimePicker;
    TimePicker notify;
    Switch simpleswitch;
    Button simpleButton1 , simpleButton2;
    CheckBox simpleCheckBox,MK,daily,reminder;
    private int hour;
    private int minutes;
    private DatabaseReference mDatabase;
    CalendarView simpleCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_today );
        nameField = (EditText) findViewById(R.id.simple_editText);
        String name = nameField.getText().toString();
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minutes = c.get(Calendar.MINUTE);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        simpleswitch = findViewById(R.id.simpleSwitch);
        //  time = (TextView) findViewById(R.id.time);
        // initiate a check box
        simpleCheckBox = (CheckBox) findViewById(R.id.simpleCheckBox);
        reminder = findViewById(R.id.reminder);
        daily = findViewById(R.id.daily);
        MK = findViewById(R.id.MK);
        notify = findViewById(R.id.notify);

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
                    Intent i = new Intent(getApplicationContext(), TodayActivity.class);
                    startActivity(i);
                }
            });
            simpleButton2 . setOnClickListener ( new View . OnClickListener () {
                @Override
                public void onClick ( View view ) {
                    mDatabase.child("Task").setValue(nameField.getText().toString());
                    mDatabase.child("Type").setValue(spin.getSelectedItem().toString());
                    mDatabase.child("From Hour").setValue(simpleTimePicker.getCurrentHour());
                    mDatabase.child("From Minute").setValue(simpleTimePicker.getCurrentMinute());
                    mDatabase.child("Notify").setValue(simpleCheckBox.isChecked());
                    mDatabase.child("Notify at hour").setValue(notify.getCurrentHour());
                    mDatabase.child("Notify minute").setValue(notify.getCurrentMinute());
                    mDatabase.child("Make habit").setValue(MK.isChecked());
                    mDatabase.child("Daily").setValue(daily.isChecked());
                    mDatabase.child("Super Reminder").setValue(reminder.isChecked());
                    mDatabase.child("Enable notification").setValue(simpleswitch.isActivated());
                    Intent i = new Intent(getApplicationContext(), PopupActivity.class);
                    startActivity(i);
                    Calendar m = Calendar.getInstance();
                    m.set(Calendar.HOUR_OF_DAY, notify.getCurrentHour());
                    m.set(Calendar.MINUTE, notify.getCurrentMinute());
                    Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, m.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
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
