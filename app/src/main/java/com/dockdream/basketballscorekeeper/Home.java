package com.dockdream.basketballscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button new_game_btn;
    Button instructions_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        new_game_btn = (Button) findViewById(R.id.new_game_btn);
        instructions_btn = (Button) findViewById(R.id.instructions_btn);

    } // end onCreate

    public void newGamePressed(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    } // end newGamePressed

    public void instructionsPressed(View v){
        Intent intent = new Intent(getApplicationContext(), Instructions.class);
        startActivity(intent);

    } // end instructionsPressed
} // end Home activity
