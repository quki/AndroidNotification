package com.example.bmac.mynotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by bmac on 2015-10-26.
 */
public class PackageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if (action.equals(Intent.ACTION_PACKAGE_ADDED)) {
            // 앱이 새로 설치 되었을 때
            Toast.makeText(context.getApplicationContext(), "앱이 새로 설치되었을때", Toast.LENGTH_SHORT).show();
        } else if (action.equals(Intent.ACTION_PACKAGE_REMOVED)) {
            // 앱이 삭제 되었을 때
            Toast.makeText(context.getApplicationContext(), "앱이 삭제 되었을 때", Toast.LENGTH_SHORT).show();
        } else if (action.equals(Intent.ACTION_PACKAGE_REPLACED)) {
            // 앱이 업데이트 되었을 때
            Toast.makeText(context.getApplicationContext(), "앱이 업데이트 되었을 때", Toast.LENGTH_SHORT).show();
            // 앱이 업데이트 되었을 때
            /*Intent i = new Intent(context, MyService.class);
            context.startService(i);*/
        }
    }
}
