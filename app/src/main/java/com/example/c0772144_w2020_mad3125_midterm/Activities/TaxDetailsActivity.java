package com.example.c0772144_w2020_mad3125_midterm.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0772144_w2020_mad3125_midterm.Model.CRACustomer;
import com.example.c0772144_w2020_mad3125_midterm.R;
import com.example.c0772144_w2020_mad3125_midterm.Util.ExtensionActivity;

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

        txtName = findViewById(R.id.name);
        txtSin = findViewById(R.id.sinNumber);

        txtBirthDate = findViewById(R.id.birthDate);
        txtGender = findViewById(R.id.gender);
        txtAge = findViewById(R.id.age);

        txtGrossIncome = findViewById(R.id.grossIncome);
        txtFederalTax = findViewById(R.id.federalTax);
        txtProvincialTax = findViewById(R.id.provincialTax);
        txtCPP = findViewById(R.id.cPP);
        txtCarry = findViewById(R.id.carryForward);
        txtRRSP = findViewById(R.id.rRSP);
        txtEI = findViewById(R.id.eI);

        txtTotalIncome = findViewById(R.id.totalTaxIncome);
        txtTotalTax = findViewById(R.id.txtPaid);

        Intent intent = getIntent();
        CRACustomer craCustomer = intent.getParcelableExtra("CRACustomer");
        String firstName = craCustomer.getFirstName();
        String formattedFirstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
        String lastName = craCustomer.getLastName().toUpperCase();
        String fullName = lastName + ", " +formattedFirstName;

        txtName.setText(fullName);
        txtSin.setText(craCustomer.getSIN());
        txtGrossIncome.setText("$ " + ExtensionActivity.getInstance().doubleFormatter(craCustomer.getGrossIncome()));
        txtAge.setText(String.valueOf(getAge()));

        CalculatorActivity calculator = new CalculatorActivity(craCustomer.getGrossIncome(), craCustomer.getRrspContributed());
        double totalTaxableIncome = 0.0d;
        double maxRRSP =  0.18d * craCustomer.getGrossIncome();
        double EI = calculator.calculateEI(craCustomer.getGrossIncome());
        double CPP = calculator.calculateCPP(craCustomer.getGrossIncome());
        double RRSP = craCustomer.getRrspContributed();

        if(craCustomer.getRrspContributed() > maxRRSP)
        {
            totalTaxableIncome = craCustomer.getGrossIncome() - (CPP + EI + maxRRSP);
        }
        else
        {
            totalTaxableIncome = craCustomer.getGrossIncome() - (CPP + EI + RRSP);
        }

        double provincialTax = calculator.calculateTaxOfFederal(totalTaxableIncome) * totalTaxableIncome;
        double federalTax = calculator.calculateTaxOfProvince((float) totalTaxableIncome) * totalTaxableIncome;
        double totalTax = provincialTax + federalTax;

        txtProvincialTax.setText("$ " + ExtensionActivity.getInstance().doubleFormatter(provincialTax));
        txtFederalTax.setText("$ " + ExtensionActivity.getInstance().doubleFormatter(federalTax));
        txtCPP.setText("$ " + ExtensionActivity.getInstance().doubleFormatter(CPP));
        txtEI.setText("$ " + ExtensionActivity.getInstance().doubleFormatter(EI));
        txtTotalTax.setText("$ " + ExtensionActivity.getInstance().doubleFormatter(totalTax));
        txtRRSP.setText("$ " + ExtensionActivity.getInstance().doubleFormatter(craCustomer.getRrspContributed()));
        txtTotalIncome.setText("$ " + ExtensionActivity.getInstance().doubleFormatter(totalTaxableIncome));

        if(craCustomer.getRrspContributed() > maxRRSP)
        {
            Double finalCarry = craCustomer.getRrspContributed() - maxRRSP;
            txtCarry.setText("$ " +"-"+ ExtensionActivity.getInstance().doubleFormatter(finalCarry));
            txtCarry.setTextColor(getResources().getColor(R.color.red));
            txtCarry.setTypeface(null, Typeface.BOLD);
        }
        else
        {
            Double finalCarry =  maxRRSP - craCustomer.getRrspContributed();
            txtCarry.setText("$ " + ExtensionActivity.getInstance().doubleFormatter(finalCarry));
        }
    }

    public int getAge()
    {
        int age = 0;
        String bDate = txtBirthDate.getText().toString();
        age = LocalDate.now().getYear() - ExtensionActivity.getInstance().stringToDate(bDate).getYear();
        return age;
    }

}
