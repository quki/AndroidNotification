package com.example.bmac.mynotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // Notification Manager
        PendingIntent invokeActivity = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);


        // RemoteView 커스터마이징
        RemoteViews mRemoteView = new RemoteViews(getPackageName(), R.layout.progressbar);
        mRemoteView.setTextViewText(R.id.noti_title, "TEST");
        mRemoteView.setTextViewText(R.id.noti_percentage, "100%");
        mRemoteView.setTextViewText(R.id.noti_text_start, "14:30");
        mRemoteView.setTextViewText(R.id.noti_text_end, "17:30");
        mRemoteView.setProgressBar(R.id.noti_progress, 100, 50, false); // public void setProgressBar (int viewId, int max, int current, boolean 진행율표시유무)





        // Notification Builder
        Notification.Builder notificationBuilder = new Notification.Builder(this);
        notificationBuilder.setSmallIcon(R.mipmap.default_character);
        notificationBuilder.setTicker("AT");
        notificationBuilder.setWhen(System.currentTimeMillis());
        notificationBuilder.setContentIntent(invokeActivity);
        notificationBuilder.setAutoCancel(false);

        Notification noti = notificationBuilder.build();
        noti.flags = Notification.FLAG_NO_CLEAR;
        noti.contentView = mRemoteView;

        mNotificationManager.notify(2, noti);
        mNotificationManager.notify(1, noti);


    }

}
