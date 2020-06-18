package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SeekBar timerSeekBar;
    boolean active = false;
    Button startButton;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        textView.setText("0:30");
        timerSeekBar.setProgress(30);
        timerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        startButton.setText("START");
        active = false;
    }

    public void onClick(View view){
        if(active){
            resetTimer();
        }else {
            active = true;
            timerSeekBar.setEnabled(false);
            startButton.setText("STOP");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100,1000){
                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int)millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    MediaPlayer player = MediaPlayer.create(getApplicationContext(),R.raw.timeup);
                    player.start();
                    resetTimer();
                }
            }.start();
        }

    }

    public void updateTimer(int progress){
        int minutes = progress / 60;
        int seconds = progress - minutes * 60;

        String secondString = Integer.toString(seconds);
        if(seconds <= 9)
            secondString = "0" + secondString;
        textView.setText(Integer.toString(minutes) + ":" + secondString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.timerSeekBar);
        textView = findViewById(R.id.textView);
        startButton = findViewById(R.id.startButton);
        ImageView eggImageView = findViewById(R.id.eggImageView);

        timerSeekBar.setMax(120);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}