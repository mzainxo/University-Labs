package com.example.samdass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class FullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_screen);
        sendEventToMainActivity("onCreate");
        // Hide the navigation bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        Button exitFullScreenButton = findViewById(R.id.ExitFullScreenButton);
        exitFullScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                sendEventToMainActivity("finish");
            }
        });

    }

    private void sendEventToMainActivity(String event) {
        Intent intent = new Intent("com.example.samdass1.EVENT");
        intent.putExtra("event", event);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sendEventToMainActivity("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        sendEventToMainActivity("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        sendEventToMainActivity("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        sendEventToMainActivity("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sendEventToMainActivity("onDestroy");
    }

}
