package com.example.mobilappers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageView1, imageView2,imageView3,imageView4,imageView5,imageView6;
    private int[] pics;
    private Button nextView;
    private ArrayList<String> rolls = new ArrayList<>();
    private Spinner spinner;
    Bundle data;
    private ArrayList<ImageView> imageViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent() != null)
        {
            data= getIntent().getExtras();
            if( data != null &&data.getBoolean("cleared"))
            {
                rolls.clear();
            }
        }

        if(savedInstanceState != null)
        {
            rolls = savedInstanceState.getStringArrayList("array");

        }
        else
        {
            rolls  = new ArrayList<>();

        }

        pics = new int[]{R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
        rollDices = findViewById(R.id.rollDices);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        nextView = findViewById(R.id.btnNextView);
        spinner = findViewById(R.id.spinner);

        imageViews.add(imageView1);
        imageViews.add(imageView2);
        imageViews.add(imageView3);
        imageViews.add(imageView4);
        imageViews.add(imageView5);
        imageViews.add(imageView6);

        nextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextView();
            }
        });


        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int numberOfDice = Integer.parseInt(spinner.getSelectedItem().toString());
                String currentRolls = "";

                for (int i = 0; i< numberOfDice; i++)
                {
                    int value = randomDiceValue();
                    imageViews.get(i).setImageResource(pics[value]);
                    currentRolls += (value+1) + ":";
                }

                if(numberOfDice < 6)
                {
                    for (int i = numberOfDice; i <6; i++)
                    {
                        imageViews.get(i).setImageResource(0);
                    }
                }

                rolls.add(currentRolls);

            }
        });
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6);
    }


    private void nextView() {

        Intent intent = new Intent(this, SecondActivity.class);

        intent.putStringArrayListExtra("Rolls", rolls);
        startActivity(intent);

    }


    @Override
    protected void onSaveInstanceState(Bundle state)
    {
        super.onSaveInstanceState(state);
        state.putStringArrayList("array", rolls);
    }


}
