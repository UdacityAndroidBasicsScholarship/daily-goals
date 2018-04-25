package com.example.dhananjay.dailygoals;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.EditText;

/**
 * Created by kmurali on 25-04-2018.
 */

public class NotificationActivity extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repeatIntent=new Intent(context,MainActivity.class);
        repeatIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,100,repeatIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.tick)
                .setContentTitle("Goal Notification")
                .setContentText("Time to perform"+"\n"+"task"+"\n"+"Complete your goal")
                .setAutoCancel(true);
        notificationManager.notify(100,builder.build());
    }
}
