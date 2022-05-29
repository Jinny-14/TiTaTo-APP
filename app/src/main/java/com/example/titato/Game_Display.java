package com.example.titato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game_Display extends AppCompatActivity {

    private Button play_again,home;
    private TicTacToeBoard ticTactoeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display_);

        ticTactoeBoard = findViewById(R.id.ticTacToeBoard);

        play_again = (Button) findViewById(R.id.button4);
        home = (Button) findViewById(R.id.button5);
        TextView playerTurn = findViewById(R.id.textView6);

        play_again.setVisibility(View.GONE);
        home.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if(playerNames!= null){
            playerTurn.setText((playerNames[0]+ "'s Turn"));
        }

        ticTactoeBoard.setUpGame(play_again, home, playerTurn, playerNames);

        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play_againButtonClick();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeButtonClick();
            }
        });
    }

    public void play_againButtonClick(){
            ticTactoeBoard.resetGame();
            ticTactoeBoard.invalidate();

    }

    public void homeButtonClick(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}