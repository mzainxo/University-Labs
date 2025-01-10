package com.example.samdass1;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox1, checkBox2, checkBox3;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.singleSelectionCheckBox1);
        checkBox2 = findViewById(R.id.singleSelectionCheckBox2);
        checkBox3 = findViewById(R.id.singleSelectionCheckBox3);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        //radioGroup = findViewById(R.id.multiSelectionRadioGroup);

        // Checkbox behavior like radio buttons
        checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBox1.setChecked(true);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
            }
        });

        checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBox2.setChecked(true);
                checkBox1.setChecked(false);
                checkBox3.setChecked(false);
            }
        });

        checkBox3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBox3.setChecked(true);
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
            }
        });
        AtomicBoolean r1 = new AtomicBoolean(false);
        AtomicBoolean r2 = new AtomicBoolean(false);
        AtomicBoolean r3 = new AtomicBoolean(false);
        AtomicBoolean r4 = new AtomicBoolean(false);
        AtomicBoolean r5 = new AtomicBoolean(false);

        // Radio button behavior like checkboxes
        radioButton1.setOnClickListener(v -> {
            if (radioButton1.isChecked() & r1.get()==true) {
                radioButton1.setChecked(false);
                r1.set(false);
            } else {
                radioButton1.setChecked(true);
                r1.set(true);
            }
        });

        radioButton2.setOnClickListener(v -> {
            if (radioButton2.isChecked() & r2.get()==true) {
                radioButton2.setChecked(false);
                r2.set(false);
            } else {
                radioButton2.setChecked(true);
                r2.set(true);
            }
        });
        radioButton3.setOnClickListener(v -> {
            if (radioButton3.isChecked() & r3.get()==true) {
                radioButton3.setChecked(false);
                r3.set(false);
            } else {
                radioButton3.setChecked(true);
                r3.set(true);
            }
        });
        radioButton4.setOnClickListener(v -> {
            if (radioButton4.isChecked() & r4.get()==true) {
                radioButton4.setChecked(false);
                r4.set(false);
            } else {
                radioButton4.setChecked(true);
                r4.set(true);
            }
        });
        radioButton5.setOnClickListener(v -> {
            if (radioButton5.isChecked() & r5.get()==true) {
                radioButton5.setChecked(false);
                r5.set(false);
            } else {
                radioButton5.setChecked(true);
                r5.set(true);
            }
        });
        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_enabled}, //disabled
                        new int[]{android.R.attr.state_enabled} //enabled
                },
                new int[] {
                        Color.BLACK, //disabled
                        Color.RED//enabled //enabled
                }
        );
        radioButton1.setButtonTintList(colorStateList);
        radioButton2.setButtonTintList(colorStateList);
        radioButton3.setButtonTintList(colorStateList);
        radioButton4.setButtonTintList(colorStateList);
        radioButton5.setButtonTintList(colorStateList);
    }

}

