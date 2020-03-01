package com.example.mobilappers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageView1, imageView2;
    private int[] pics;
    private Button nextView;
    private ArrayList<String> rolls;
    int SecondActivity = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rolls = new ArrayList<>();
        pics = new int[]{R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
            rollDices = findViewById(R.id.rollDices);
            imageView1 = findViewById(R.id.imageView1);
            imageView2 = findViewById(R.id.imageView2);
            nextView = findViewById(R.id.btnNextView);

            nextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            nextView();
                }
            });

        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int value1 = randomDiceValue();
               int value2 = randomDiceValue();

               //int res1 = getResources().getIdentifier("dice1", "drawable", "com.example-mobilappers");
               //int res2 = getResources().getIdentifier("dice1", "drawable", "com.example-mobilappers");


               imageView1.setImageResource(pics[value1]);
               imageView2.setImageResource(pics[value2]);
               rolls.add("" + (value1+1) + ":" + (value2+1));

            }
        });
    }
    public static int randomDiceValue() {
        return RANDOM.nextInt(6);
    }

    public void readRolls()
    {

    }

    private void nextView()
    {

        Intent intent = new Intent(this, SecondActivity.class);
        System.out.println("test");
        intent.putStringArrayListExtra("Rolls",  rolls);
        startActivity(intent);


    //View v = findViewById(R.id.listofrolls);
       //setContentView(R.layout.listofrolls);
    }


}
