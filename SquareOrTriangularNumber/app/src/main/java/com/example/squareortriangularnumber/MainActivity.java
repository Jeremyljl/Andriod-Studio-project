package com.example.squareortriangularnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void clickFunction(View view){
        EditText editText = (EditText)findViewById(R.id.editText);
        int number = Integer.valueOf(editText.getText().toString());
        boolean t = triangular(number);
        boolean s = square(number);
        if(editText.getText().toString().isEmpty())
            Toast.makeText(this, "Please enter a number!", Toast.LENGTH_SHORT).show();
        if(number <= 0)
            Toast.makeText(this, "Wrong number", Toast.LENGTH_SHORT).show();
        else {
            if(t && s)
                Toast.makeText(this,"Both", Toast.LENGTH_SHORT).show();
            if(t && !s)
                Toast.makeText(this, "Triangular", Toast.LENGTH_SHORT).show();
            if(!t && s)
                Toast.makeText(this, "square", Toast.LENGTH_SHORT).show();
            if(!t && !s)
                Toast.makeText(this, "Neither", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean triangular(int i){
        boolean result = false;
        int sum = 0;
        int count = 1;
        while(sum < i){
            sum = sum + count;
            if(sum == i){
                result = true;
                break;
            }
            count++;
        }
        return result;
    }

    public boolean square(int i){
        boolean result = false;
        int sum = 0;
        int count = 1;
        while(sum < i){
            sum = count * count;
            if(sum == i){
                result = true;
                break;
            }
            count++;
        }
        return result;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
