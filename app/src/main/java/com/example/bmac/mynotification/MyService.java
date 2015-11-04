package com.example.bmac.mynotification;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by bmac on 2015-10-26.
 */
public class MyService extends Service implements Runnable{

    private Handler mHandler;
    private static final int UPDATE_TIME_INTERVAL = 10000; //millisecond,
    private int count;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(),"SERVICE CREATE",Toast.LENGTH_SHORT).show();


        mHandler= new Handler();
        mHandler.postDelayed(this, 1); // call run()
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Toast.makeText(getApplicationContext(),"onStartCommand",Toast.LENGTH_SHORT).show();
        MyNotification mNotification = new MyNotification(getApplicationContext());
        mNotification.setATNotificationBuilder();

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"SERVICE DESTROY",Toast.LENGTH_SHORT).show();
        mHandler.removeCallbacks(this); // stop run()
        stopSelf(); // stop Service
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void run() {

        int currTime = count * UPDATE_TIME_INTERVAL/1000;
        //Toast.makeText(getApplicationContext(),currTime+"",Toast.LENGTH_SHORT).show();
        mHandler.postDelayed(this, UPDATE_TIME_INTERVAL);
        count++;

    }
}
