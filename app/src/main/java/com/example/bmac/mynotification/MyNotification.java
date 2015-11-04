package com.example.bmac.mynotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by bmac on 2015-10-26.
 */
public class MyNotification {


    private Context context;

    public MyNotification(Context context) {
        this.context = context;
    }

    public MyNotification() {

    }

    public void setATNotificationBuilder() {

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE); // Notification Manager
        PendingIntent invokeActivity = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        // RemoteView 커스터마이징
        RemoteViews mRemoteView = new RemoteViews(context.getPackageName(), R.layout.progressbar);
        mRemoteView.setTextViewText(R.id.noti_title, "TEST");
        mRemoteView.setTextViewText(R.id.noti_percentage, "100%");
        mRemoteView.setTextViewText(R.id.noti_text_start, "14:30");
        mRemoteView.setTextViewText(R.id.noti_text_end, "17:30");
        mRemoteView.setProgressBar(R.id.noti_progress, 100, 50, false); // public void setProgressBar (int viewId, int max, int current, boolean 진행율표시유무)

        // Notification Builder
        Notification.Builder notificationBuilder = new Notification.Builder(context);
        notificationBuilder.setSmallIcon(R.mipmap.default_character);
        notificationBuilder.setTicker("AT");
        notificationBuilder.setWhen(System.currentTimeMillis());
        notificationBuilder.setContentIntent(invokeActivity);
        notificationBuilder.setAutoCancel(false);

        Notification noti = notificationBuilder.build();
        noti.flags = Notification.FLAG_NO_CLEAR;
        noti.contentView = mRemoteView;

        setATNotify(1, mNotificationManager, noti);

    }

    public void setATNotify(int id, NotificationManager mNotificaionManager, Notification mNotification) {
        mNotificaionManager.notify(id, mNotification);
    }
}