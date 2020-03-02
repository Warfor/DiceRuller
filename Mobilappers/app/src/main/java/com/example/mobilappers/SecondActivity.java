package com.example.mobilappers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView list;

    Button back;
    Button clear;
    ArrayList<String> test = new ArrayList<>();
    Boolean hasBeenCleared = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofrolls);
        list = findViewById(R.id.ListView);
        back = findViewById(R.id.btnBack);
        clear = findViewById(R.id.btnClear);



        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearList();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });

        Bundle data = getIntent().getExtras();

        ArrayList<String> rolls = data.getStringArrayList("Rolls");

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rolls);
        list.setAdapter(adapter);

    }

    private void clearList()
    {
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, test);
        list.setAdapter(adapter);
        hasBeenCleared = true;
    }

    private void Back()
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("cleared", hasBeenCleared);
        startActivity(intent);
    }

}