package com.example.shippingcalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText weightET;
    ShipItem shipItem;
    TextView baseTV, addedTV, totalTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightET = (EditText)findViewById(R.id.editTextWeight);
        shipItem = new ShipItem();
        baseTV = (TextView)findViewById(R.id.baseCostNum);
        addedTV = (TextView)findViewById(R.id.addCostNum);
        totalTV = (TextView)findViewById(R.id.totalCostNum);

        weightET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    shipItem.setWeight(Double.parseDouble(s.toString()));
                }
                catch(NumberFormatException e){
                    shipItem.setWeight(0.0);
                }
                displayShipping();
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    public void displayShipping()
    {
        baseTV.setText(shipItem.getBaseCost().toString());
        addedTV.setText(shipItem.getAddedCost().toString());
        totalTV.setText(shipItem.getTotalCost().toString());
    }

}
