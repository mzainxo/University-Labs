package com.example.samdass1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

public class VolumeKeyReceiver extends BroadcastReceiver {
    private static final String TAG = "VolumeKeyReceiver";
    private static MainActivity mainActivity;

    public VolumeKeyReceiver() {
        // Default constructor
    }

    public static void setMainActivity(MainActivity activity) {
        mainActivity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
            AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            int volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            Log.d(TAG, "Volume changed: " + volume);

            if (mainActivity != null) {
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (volume > 10) { // Assuming 5 as a middle point for volume change actions
                            mainActivity.increaseNumericValue();
                            mainActivity.scrollUp();
                            mainActivity.zoomIn();
                            mainActivity.adjustBrightness(true);
                        } else {
                            mainActivity.decreaseNumericValue();
                            mainActivity.scrollDown();
                            mainActivity.zoomOut();
                            mainActivity.adjustBrightness(false);
                        }
                    }
                });
            } else {
                Log.w(TAG, "MainActivity is not set.");
            }
        }
    }
}
