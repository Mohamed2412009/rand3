package com.example.random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {
    private TextView tvnum10, tvnum11, tvName;
    private Button btnBack;
    private Intent intent, receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tvnum10 = findViewById(R.id.textView7);
        tvnum11= findViewById(R.id.textView8);
        tvName= findViewById(R.id.namename);
        btnBack = findViewById(R.id.button4);
        intent = new Intent(ScoreActivity.this, MainActivity.class);
        receiver = getIntent();
        String name =receiver.getStringExtra("NAME");
        tvName.setText(name);
        tvnum10.setText("Num of games :"+MainActivity.game);
        tvnum11.setText("Num of games :"+MainActivity.correct);





        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });

    }
}