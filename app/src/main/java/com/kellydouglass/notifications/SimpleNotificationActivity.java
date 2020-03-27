package com.kellydouglass.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SimpleNotificationActivity extends AppCompatActivity {

    private Button button;

    private final String CHANNEL_ID = "simple_notification";
    private final int NOTIFICATION_ID = 01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_notification);

        button  = findViewById(R.id.simple_notification);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background));
                builder.setContentTitle("Android Learning, Title");
                builder.setContentText("Simple notification text");
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

            }
        });
    }

    // TODO: Practice making a todo
    /*
    Stuff and things

     */

    private void createNotificationChannel() {

            CharSequence name = "Simple";
            String description = "Include all the simple notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
    }
}
