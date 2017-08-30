package com.example.karti.expense_tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Totals extends AppCompatActivity {
    Button bMenuTotal,bBreakdown;
    TextView tvEntries, tvTotalSpent;
    Spinner sAccountTotals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totals);
        bMenuTotal = (Button) findViewById(R.id.bMenuTotal);
        bBreakdown = (Button) findViewById(R.id.bBreakdown);
        tvEntries = (TextView) findViewById(R.id.tvEntries);
        tvTotalSpent = (TextView) findViewById(R.id.tvTotalSpent);
        sAccountTotals = (Spinner) findViewById(R.id.sAccountTotal);
        List<String> spinnerArray =  MainActivity.spinnerlist;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sAccountTotals.setAdapter(adapter);

        ArrayList<Item> itemlist =  MainActivity.expenselist.get(sAccountTotals.getSelectedItem().toString());
     double totalprice = 0;
        for (Item it: itemlist){
            totalprice += it.cost;

        }
            tvEntries.setText(itemlist.size() + "");
            tvTotalSpent.setText("$" + totalprice);

        bMenuTotal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent i = new Intent(getApplication(), MainActivity.class);
                startActivity(i);


            }

        });

        bBreakdown.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){

                ArrayList<Item> itemlist =  MainActivity.expenselist.get(sAccountTotals.getSelectedItem().toString());
                double totalprice = 0;
                for (Item it: itemlist){
                    totalprice += it.cost;

                }
                tvEntries.setText(itemlist.size() + "");
                tvTotalSpent.setText("$" + totalprice);


            }

        });}

}
