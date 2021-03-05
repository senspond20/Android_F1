package com.example.blank;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity  extends AppCompatActivity {
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
    private final String TAG = "MainActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView1);
//        textView.append("안녕안녕");
        textView.setText("안녕하십니까?");

        // 버튼 리스너 추가
        onClick(findViewById(R.id.buttonRed), "Red");
        onClick(findViewById(R.id.buttonBlue), "Blue");
        onClick(findViewById(R.id.buttonGreen), "Green");
    }

    public void onClick(Button button, String text){
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Log.v(TAG, text);
                textView.setText(text);
            }
        });
    }
}
