package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText heightEditText;
    private EditText weightEditText;
    private TextView result;
    private TextView status;
    private Button clickBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEditText = findViewById(R.id.height);
        weightEditText = findViewById(R.id.weight);
        result = findViewById(R.id.result);
        status = findViewById(R.id.status);
        clickBtn = findViewById(R.id.btn);

        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(heightEditText.getText().toString().length() == 0){
                    heightEditText.setText("0");
                }
                if(weightEditText.getText().toString().length() == 0){
                    weightEditText.setText("0");
                }
                double height = Double.parseDouble(heightEditText.getText().toString()) / 100; //get height and convert to meter
                double weight = Double.parseDouble(weightEditText.getText().toString()) ; // get weight and convert to double
                double res = weight / (height * height);

                if(res <= 18.5){
                    status.setText("Underweight");
                }
                else if(res >= 18.-5 && res <= 24.9 ){
                    status.setText("Normal weight");
                }
                else if(res >= 25 && res <= 29.9){
                    status.setText("Overweight");
                }
                else{
                    status.setText("Obesity");
                }
                result.setText(String.format("%.2f", res));
            }
        });

    }
}