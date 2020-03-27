package com.kellydouglass.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BigPicStyleNotificationActivity extends AppCompatActivity {

    private Button button;
    private final String CHANNEL_ID = "big_pic_notification";
    private final int NOTIFICATION_ID = 03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_pic_style_notification);

        button = findViewById(R.id.big_pic_notification);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotificationChannel();
                Bitmap bigPicture = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background));
                builder.setContentTitle("Big Pic, Title");
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bigPicture));
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

            }
        });
    }

    private void createNotificationChannel() {

            CharSequence name = "Big Pic Style";
            String description = "Include all the Big Pic notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
    }
}
