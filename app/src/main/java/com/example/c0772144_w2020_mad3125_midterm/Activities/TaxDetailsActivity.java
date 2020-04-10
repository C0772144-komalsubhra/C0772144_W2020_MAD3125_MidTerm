package com.example.c0772144_w2020_mad3125_midterm.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0772144_w2020_mad3125_midterm.Model.CRACustomer;
import com.example.c0772144_w2020_mad3125_midterm.R;
import com.example.c0772144_w2020_mad3125_midterm.Util.MethodsActivity;

import org.joda.time.LocalDate;


public class TaxDetailsActivity extends AppCompatActivity {
    TextView txtRRSP;
    TextView txtSin;
    TextView txtName;
    TextView txtBirthDate;
    TextView txtGender;
    TextView txtAge;
    TextView txtGrossIncome;
    TextView txtFederalTax;
    TextView txtProvincialTax;
    TextView txtCPP;
    TextView txtEI;
    TextView txtCarry;
    TextView txtTotalIncome;
    TextView txtTotalTax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_details);
        init();

        Intent intent = getIntent();
        CRACustomer craCustomer = intent.getParcelableExtra("CRACustomer");
        String firstName = craCustomer.getFirstName();
        String formattedFirstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
        String lastName = craCustomer.getLastName().toUpperCase();
        String fullName = lastName + ", " +formattedFirstName;

        txtName.setText(fullName);
        txtSin.setText(craCustomer.getSIN());
        txtGrossIncome.setText("$ " + MethodsActivity.getInstance().doubleFormatter(craCustomer.getGrossIncome()));
        txtAge.setText(String.valueOf(getAge()));

        CalculatorActivity calculator = new CalculatorActivity(craCustomer.getGrossIncome(), craCustomer.getRrspContributed());
        double totalTaxableIncome = 0.0d;
        double maxRRSP =  0.18d * craCustomer.getGrossIncome();
        double EI = calculator.calculateEI(craCustomer.getGrossIncome());
        double CPP = calculator.calculateCPP(craCustomer.getGrossIncome());
        double RRSP = craCustomer.getRrspContributed();

      

}
