package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SeekBar seekBar;
//    public void generateTimeTable(int timeTableNumber){
//        ArrayList<String> timeTableContent = new ArrayList<String>();
//
//        for(int j = 1; j <=10; j++){
//            timeTableContent.add(Integer.toString(j * timeTableNumber));
//        }
//
////        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listView);
////
////        listView.setAdapter(arrayAdapter);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.listView);


        seekBar.setMax(20);
        seekBar.setProgress(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timeTableNumber;
                if(progress < min){
                    timeTableNumber = min;
                    seekBar.setProgress(min);
                }else{
                    timeTableNumber = progress;
                }

//                generateTimeTable(timeTableNumber);

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