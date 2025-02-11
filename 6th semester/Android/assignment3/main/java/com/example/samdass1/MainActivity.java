package com.example.samdass1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView numericValueText;
    private ScrollView scrollView;
    private TextView scrollText;
    private TextView zoomText;
    private int numericValue = 0;
    private int zoomLevel = 16;
    private VolumeKeyReceiver volumeKeyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numericValueText = findViewById(R.id.numericValue);
        scrollView = findViewById(R.id.scrollView);
        scrollText = findViewById(R.id.scrollText);
        zoomText = findViewById(R.id.zoomText);

        volumeKeyReceiver = new VolumeKeyReceiver();
        VolumeKeyReceiver.setMainActivity(this);
        registerReceiver(volumeKeyReceiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));

        // Check and request WRITE_SETTINGS permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(this)) {
                showWriteSettingsPermissionDialog();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(volumeKeyReceiver);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showWriteSettingsPermissionDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Permission Required")
                .setMessage("This app needs permission to modify system settings.")
                .setPositiveButton("Grant", (dialog, which) -> {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    startActivityForResult(intent, 200);
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    // Handle cancellation if needed
                })
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.System.canWrite(this)) {
                    // Permission granted
                } else {
                    // Permission not granted, handle accordingly
                }
            }
        }
    }

    public void increaseNumericValue() {
        numericValue++;
        numericValueText.setText(String.valueOf(numericValue));
    }

    public void decreaseNumericValue() {
        if (numericValue > 0) {
            numericValue--;
            numericValueText.setText(String.valueOf(numericValue));
        }
    }

    public void scrollUp() {
        scrollView.smoothScrollBy(0, -100);
    }

    public void scrollDown() {
        scrollView.smoothScrollBy(0, 100);
    }

    public void zoomIn() {
        zoomLevel++;
        zoomText.setTextSize(zoomLevel);
    }

    public void zoomOut() {
        if (zoomLevel > 10) {
            zoomLevel--;
            zoomText.setTextSize(zoomLevel);
        }
    }

    public void adjustBrightness(boolean increase) {
        try {
            int brightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
            if (increase) {
                brightness += 10;
            } else {
                brightness -= 10;
            }
            if (brightness > 255) brightness = 255;
            if (brightness < 0) brightness = 0;
            Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightness);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }
}
