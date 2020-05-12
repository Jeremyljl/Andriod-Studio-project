package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int random;

    public void generate(){
        int min = 0;
        int max = 20;
        random = (int)(Math.random() * (max - min + 1) + min);
    }


    public void clickFunction(View view){

        EditText editText = (EditText)findViewById(R.id.editText);
        int i = Integer.parseInt(editText.getText().toString());
        Log.i("#",Integer.toString(random));

        if(i < random){
            Toast.makeText(this, "Higher", Toast.LENGTH_SHORT).show();
        }
        if(i > random){
            Toast.makeText(this, "Lower", Toast.LENGTH_SHORT).show();
        }
        if (i == random){
            Toast.makeText(this, "BINGO", Toast.LENGTH_SHORT).show();
            generate();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
