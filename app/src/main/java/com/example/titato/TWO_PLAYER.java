package com.example.titato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TWO_PLAYER extends AppCompatActivity {

    private EditText player1;
    private EditText player2;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);

        player1 = findViewById(R.id.editTextTextPersonName);
        player2 = findViewById(R.id.editTextTextPersonName2);

        submit = (Button) findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitButtonClick();
            }
        });

    }

    public void submitButtonClick(){
        String player1name = player1.getText().toString();
        String player2name = player2.getText().toString();

        Intent intent = new Intent(this, Game_Display.class);
        intent.putExtra("PLAYER_NAMES", new String[] {player1name,player2name});
        startActivity(intent);
    }

}