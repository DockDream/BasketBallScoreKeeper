package com.dockdream.basketballscorekeeper;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Instructions extends AppCompatActivity {

    Button sample_button1;
    Button sample_button2;
    Button sample_button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        sample_button1 = (Button) findViewById(R.id.sample_button1);
        sample_button1.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        sample_button2 = (Button) findViewById(R.id.sample_button2);
        sample_button2.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        sample_button3 = (Button) findViewById(R.id.sample_button3);
        sample_button3.getBackground().setColorFilter(0xFFFFFF33, PorterDuff.Mode.MULTIPLY);


    } // end onCreate
} // end Instructions activity
