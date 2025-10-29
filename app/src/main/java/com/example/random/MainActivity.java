package com.example.random;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button start, new1;
    private TextView tvnum, tvnum2, tvnum3, tvnum4, tvnum5, tvnum6, tvnum7, tvnum8;
    private int a1, a2, a3, a4, a5, a6, n = 0 , x=0;
    private boolean isRunning = false;
    private Handler handler = new Handler();
    private Random rand = new Random();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.button);
        new1 = findViewById(R.id.button2);
        tvnum = findViewById(R.id.textView2);
        tvnum2 = findViewById(R.id.textView);
        tvnum3 = findViewById(R.id.textView3);
        tvnum4 = findViewById(R.id.textView4);
        tvnum5 = findViewById(R.id.textView5);
        tvnum6 = findViewById(R.id.textView6);
        tvnum7 = findViewById(R.id.textViewR);
        tvnum8 = findViewById(R.id.textViewOf);


        new1.setOnClickListener(v -> {
            a1 = rand.nextInt(40);
            tvnum.setText(String.valueOf(a1));
            a2 = rand.nextInt(40);
            tvnum2.setText(String.valueOf(a2));
            a3 = rand.nextInt(40);
            tvnum3.setText(String.valueOf(a3));
            a4 = rand.nextInt(40);
            tvnum4.setText(String.valueOf(a4));
            a5 = rand.nextInt(40);
            tvnum5.setText(String.valueOf(a5));
            a6 = rand.nextInt(40);
            tvnum6.setText(String.valueOf(a6));
            tvnum.setBackgroundColor(0);
            tvnum2.setBackgroundColor(0);
            tvnum3.setBackgroundColor(0);
            tvnum4.setBackgroundColor(0);
            tvnum5.setBackgroundColor(0);
            tvnum6.setBackgroundColor(0);

            tvnum8.setText("0 of 6");
            n = 0;

            if (start.getText().toString().equals("stop"))
                start.setText("start");
            start.setBackgroundColor(Color.GREEN);
        });


        start.setOnClickListener(v -> {

            if (!isRunning&&x<6) {
                x++;
                isRunning = true;
                start.setText("stop");
                start.setBackgroundColor(Color.RED);

                runnable = new Runnable() {
                    @Override
                    public void run() {
                        int number = rand.nextInt(39) + 1;
                        tvnum7.setText(String.valueOf(number));

                        if (isRunning)
                            handler.postDelayed(this, 100);
                    }
                };
                handler.post(runnable);

            } else {

                isRunning = false;
                handler.removeCallbacks(runnable);
                start.setText("start");
                start.setBackgroundColor(Color.GREEN);


                int current = Integer.parseInt(tvnum7.getText().toString());


                if (tvnum.getText().toString().equals(String.valueOf(current))) {
                    tvnum.setBackgroundColor(Color.RED);
                    n++;
                }
                if (tvnum2.getText().toString().equals(String.valueOf(current))) {
                    tvnum2.setBackgroundColor(Color.RED);
                    n++;
                }
                if (tvnum3.getText().toString().equals(String.valueOf(current))) {
                    tvnum3.setBackgroundColor(Color.RED);
                    n++;
                }
                if (tvnum4.getText().toString().equals(String.valueOf(current))) {
                    tvnum4.setBackgroundColor(Color.RED);
                    n++;
                }
                if (tvnum5.getText().toString().equals(String.valueOf(current))) {
                    tvnum5.setBackgroundColor(Color.RED);
                    n++;
                }
                if (tvnum6.getText().toString().equals(String.valueOf(current))) {
                    tvnum6.setBackgroundColor(Color.RED);

                    n++;
                }


                tvnum8.setText(n + " of 6");
            }
        });
    }
}





























