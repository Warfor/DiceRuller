package com.example.mobilappers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
int SecondActivity = 10;
    ListView list;
    ArrayList arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofrolls);
        list = findViewById(R.id.ListView);
        Intent intent = new Intent(this, MainActivity.class);

        startActivityForResult(intent, 10);

        Bundle data = getIntent().getExtras();

        ArrayList<Roll> rolls = data.getParcelableArrayList("Rolls");

      //  ListAdapter adapter = new ArrayAdapter<Roll>(this, android.R.layout.simple_list_item_1, rolls);
        //list.setAdapter(adapter);
    }


    public void test()
    {

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data )
    {
        if( requestCode == SecondActivity)
        {
            switch (resultCode){
                case RESULT_OK:
                    arrayList = data.getExtras().getParcelableArrayList("Rolls");
                    break;
                    default:
            }
        }
    }
}