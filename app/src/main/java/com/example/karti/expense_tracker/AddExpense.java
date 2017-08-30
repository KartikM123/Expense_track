package com.example.karti.expense_tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class AddExpense extends AppCompatActivity {
    EditText etCost, etExpense;
    Button bMenu, bAddExp, bAccount;
    Spinner sAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        bMenu = (Button) findViewById(R.id.bMenu);
        sAccount = (Spinner) findViewById(R.id.sAccount);
        bAddExp = (Button) findViewById(R.id.bAddExp);
        etCost = (EditText) findViewById(R.id.etCost);
        etExpense = (EditText) findViewById(R.id.etExpense);
        bAccount = (Button) findViewById(R.id.bAddAccount);
        List<String> spinnerArray =  MainActivity.spinnerlist;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sAccount.setAdapter(adapter);
        bAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent i = new Intent(getApplication(), AddAccount.class);
                startActivity(i);


            }

        });
        bMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent i = new Intent(getApplication(), MainActivity.class);
                startActivity(i);


            }

        });
        bAddExp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                String account = sAccount.getSelectedItem().toString();
                double cost = Double.parseDouble( etCost.getText().toString());
                String expense = etExpense.getText().toString();
                ArrayList<Item> temp = MainActivity.expenselist.get(account);
                Item item = new Item (expense, cost);
                temp.add(item);
                MainActivity.expenselist.put(account,temp);
                Intent i = new Intent(getApplication(), MainActivity.class);
                startActivity(i);

            }

        });

    }
}
