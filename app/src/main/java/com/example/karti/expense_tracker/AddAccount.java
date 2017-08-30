package com.example.karti.expense_tracker;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddAccount extends AppCompatActivity{

    Button bCancel, bAdd;
    EditText etAccountName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        bAdd = (Button) findViewById(R.id.bAdd);
        bCancel = (Button) findViewById(R.id.bCancel);
        etAccountName = (EditText) findViewById(R.id.etAccountName);
        bAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent i = new Intent(getApplication(), AddExpense.class);
                MainActivity.spinnerlist.add(etAccountName.getText().toString());
                ArrayList blank = new ArrayList<Item> ();
                MainActivity.expenselist.put(etAccountName.getText().toString(),blank);
               startActivity(i);


            }

        });
        bCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent i = new Intent(getApplication(), AddExpense.class);
                startActivity(i);


            }

        });
    }
}
