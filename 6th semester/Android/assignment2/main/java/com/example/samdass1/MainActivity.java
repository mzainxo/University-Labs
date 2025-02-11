package com.example.samdass1;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {

    public TextView textView;
    Button dialogueButton, fullScreenButton;
    private BroadcastReceiver eventReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            printEvent("onReceive");
            String event = intent.getStringExtra("event");
            printEvent(FullScreenActivity.class.getSimpleName(), event);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        dialogueButton = findViewById(R.id.DlgButton);
        fullScreenButton = findViewById(R.id.FullScreenButton);

        printEvent("onCreate");

        dialogueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printEvent("dialogueButton", "onClick");
                openDialogueActivity();
            }
        });

        fullScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printEvent("fullScreenButton", "onClick");
                openFullScreenActivity();
            }
        });

        LocalBroadcastManager.getInstance(this).registerReceiver(eventReceiver, new IntentFilter("com.example.samdass1.EVENT"));
        openDialogueActivity();
    }

    public void openDialogueActivity() {
        Dialogue dialog = new Dialogue(MainActivity.this);
        dialog.setContentView(R.layout.activity_dialogue);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void openFullScreenActivity() {
        Intent intent = new Intent(MainActivity.this, FullScreenActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        printEvent("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        printEvent("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        printEvent("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        printEvent("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(eventReceiver);
        printEvent("onDestroy");
    }

    public void printEvent(String activityName, String event) {
        textView.append(activityName + "." + event + "()\n");
    }

    private void printEvent(String event) {
        printEvent(this.getClass().getSimpleName(), event);
    }
}
