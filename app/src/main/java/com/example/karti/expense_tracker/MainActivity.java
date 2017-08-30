package com.example.karti.expense_tracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button bAddExpense, bTotal;
    public static HashMap<String,ArrayList<Item>> expenselist = new HashMap();
    public static ArrayList<String> spinnerlist = new ArrayList<>();
    TextView tvHashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bAddExpense = (Button) findViewById(R.id.bAddExpense);
        Button bTotal = (Button) findViewById(R.id.bTotal);
        tvHashMap = (TextView) findViewById(R.id.tVHashMap);
        File file = new File(getDir("data", MODE_PRIVATE), "map");
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;


        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(expenselist);
            outputStream.flush();
            outputStream.close();
            inputStream = new ObjectInputStream(new FileInputStream(file));
            expenselist =(HashMap<String, ArrayList<Item>>) inputStream.readObject();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (String key: expenselist.keySet()){
            spinnerlist.add(key);
        }

        String HashMapstuff = "";
        for (String key: expenselist.keySet()){
            HashMapstuff= HashMapstuff + key + expenselist.get(key) + " ";
        }
        tvHashMap.setText(HashMapstuff);
        bAddExpense.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent i = new Intent(getApplication(), AddExpense.class);
                startActivity(i);


            }

        });
        bTotal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent i = new Intent(getApplication(), Totals.class);
                startActivity(i);


            }

        });
    }
}
