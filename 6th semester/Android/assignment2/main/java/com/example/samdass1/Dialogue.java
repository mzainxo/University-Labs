package com.example.samdass1;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dialogue extends Dialog {
    private MainActivity mainActivity;
    Button closeButton;
    public Dialogue(MainActivity context) {
        super(context);
        mainActivity = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);
        closeButton = findViewById(R.id.button_close);
        printEvent("onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        printEvent("onStart");
    }


    @Override
    protected void onStop() {
        super.onStop();
        printEvent("onStop");
    }

    @Override
    public void show() {
        super.show();
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        printEvent("show");

    }

    @Override
    public void dismiss() {
        super.dismiss();
        printEvent("dismiss");
    }
    private void printEvent(String event) {
        mainActivity.printEvent(this.getClass().getSimpleName(),event);
    }
}