package com.kellydouglass.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button simpleButton;
    private Button bigPicButton;
    private Button bigTextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleButton = findViewById(R.id.simpleButton1);
        bigPicButton = findViewById(R.id.bigPicButton);
        bigTextButton = findViewById(R.id.bigTextButton);

        simpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SimpleNotificationActivity.class);
                startActivity(intent);
            }
        });

        bigPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BigPicStyleNotificationActivity.class);
                startActivity(intent);
            }
        });

        bigTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BigTextStyleNotificationActivity.class);
                startActivity(intent);
            }
        });
    }

    public void toInbox(View view) {
        Intent intent = new Intent(MainActivity.this, InboxStyleNotificationActivity.class);
        startActivity(intent);
    }
}
