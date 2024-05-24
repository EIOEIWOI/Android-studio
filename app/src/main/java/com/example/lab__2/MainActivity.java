package com.example.lab__2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgMeat;
    private RadioButton rBeef, rChicken, rPork;
    private CheckBox cbCheese, cbOnions, cbSalad;
    private Button btnOrder;
    private TextView tvQuestion, tv0;
    private Switch idSwitch;
    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        rgMeat = findViewById(R.id.rgMeat);
        rBeef = findViewById(R.id.rBeef);
        rChicken = findViewById(R.id.rChicken);
        rPork = findViewById(R.id.rPork);
        cbCheese = findViewById(R.id.cbCheese);
        cbOnions = findViewById(R.id.cbOnions);
        cbSalad = findViewById(R.id.cbSalad);
        btnOrder = findViewById(R.id.btnOrder);
        tvQuestion = findViewById(R.id.tvQuestion);
        tv0 = findViewById(R.id.tv0);
        idSwitch = findViewById(R.id.idSwitch);
        navView = findViewById(R.id.nav_view);

        // Set up button click listener
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder orderSummary = new StringBuilder();
                orderSummary.append("You ordered a burger with:\n");

                // Get selected meat
                int selectedMeatId = rgMeat.getCheckedRadioButtonId();
                if (selectedMeatId == rBeef.getId()) {
                    orderSummary.append("Beef\n");
                } else if (selectedMeatId == rChicken.getId()) {
                    orderSummary.append("Chicken\n");
                } else if (selectedMeatId == rPork.getId()) {
                    orderSummary.append("Pork\n");
                }

                // Get selected extras
                if (cbCheese.isChecked()) {
                    orderSummary.append("Cheese\n");
                }
                if (cbOnions.isChecked()) {
                    orderSummary.append("Onions\n");
                }
                if (cbSalad.isChecked()) {
                    orderSummary.append("Salad\n");
                }

                // Show the order summary as a toast
                Toast.makeText(MainActivity.this, orderSummary.toString(), Toast.LENGTH_LONG).show();
            }
        });

        // Set up switch click listener
        idSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idSwitch.isChecked()) {
                    Toast.makeText(MainActivity.this, "Switch is ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Switch is OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
