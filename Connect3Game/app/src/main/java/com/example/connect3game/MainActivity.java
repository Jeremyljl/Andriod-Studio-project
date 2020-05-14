package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;  // 0 for yellow , 1 for red， 2 for empty
    int[] gameState = {2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2};
    int[][] winPosition = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    boolean gameActive = true;


    public void dropIn(View view){


        ImageView counter = (ImageView) view;
        int tag = Integer.parseInt(counter.getTag().toString());
        if(gameState[tag] == 2 && gameActive) {
            gameState[tag] = activePlayer;
            counter.setTranslationY(-1500);   //move out first

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow); //change the resource
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).setDuration(300);  //come back

            for (int[] win : winPosition) {
                if (gameState[win[0]] == gameState[win[1]] && gameState[win[1]] == gameState[win[2]] && gameState[win[0]] != 2) {

                    String winner = "";
                    // activePlayer has been updated before
                    if (activePlayer == 1)
                        winner = "Yellow";
                    else
                        winner = "Red";

                    gameActive = false;

                    Button playButton = (Button)findViewById(R.id.playButton);
                    TextView textView = (TextView)findViewById((R.id.textView));
                    textView.setText(winner + " WIN!");
                    playButton.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);

                }

            }
        }
    }

    public void playAgain (View view){

        Button playButton = (Button)findViewById(R.id.playButton);
        TextView textView = (TextView)findViewById((R.id.textView));
        playButton.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);

        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);
        int counter = gridLayout.getChildCount();
        Log.i("info",String.valueOf(counter));
        for(int i = 0; i < gridLayout.getChildCount(); i++){
            ImageView count = (ImageView)gridLayout.getChildAt(i);
            count.setImageDrawable(null);

        }

        activePlayer = 0;  // 0 for yellow , 1 for red， 2 for empty
        for(int i = 0; i < gameState.length; i++)
            gameState[i] = 2;
        gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playButton = (Button)findViewById(R.id.playButton);
        TextView textView = (TextView)findViewById((R.id.textView));

        playButton.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }
}
