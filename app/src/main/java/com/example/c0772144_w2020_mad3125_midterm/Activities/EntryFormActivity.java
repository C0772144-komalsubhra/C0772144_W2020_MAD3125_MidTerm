package com.example.c0772144_w2020_mad3125_midterm.Activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0772144_w2020_mad3125_midterm.Util.Gender;
import com.example.c0772144_w2020_mad3125_midterm.Util.MethodsActivity;
import com.example.c0772144_w2020_mad3125_midterm.Model.CRACustomer;
import com.example.c0772144_w2020_mad3125_midterm.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;

public class EntryFormActivity extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private TextInputEditText edtSINText;
    private TextInputLayout edtSIN;
    private TextInputLayout edtFirstName;
    private TextInputEditText edtFirstNameText;
    private TextInputLayout edtLastName;
    private TextInputEditText edtLastNameText;
    private TextInputEditText edtDateText;
    private TextInputLayout edtDate;
    private TextInputEditText edtFilingDateText;
    private TextInputLayout edtGrossIncome;
    private TextInputEditText edtGrossIncomeText;
    private TextInputLayout edtRRSP;
    private TextInputEditText edtRRSPText;
    private RadioButton rdBtnMale;
    private RadioButton rdBtnFemale;
    private RadioButton rdBtnOther;

    private Button btnSubmit;
    private Button btnClear;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_form);

        init();
        datePicker();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldchecker();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        LocalDate date = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MMM-yyyy");
        edtFilingDateText.setText(date.toString(fmt));
    }
    protected void onStart()
    {
        super.onStart();
        clear();
    }
    public void clear()
    {
        edtSINText.getText().clear();
        edtFirstNameText.getText().clear();
        edtLastNameText.getText().clear();
        edtDateText.getText().clear();
        edtGrossIncomeText.getText().clear();
        edtRRSPText.getText().clear();

        rdBtnOther.setChecked(false);
        rdBtnMale.setChecked(false);
        rdBtnFemale.setChecked(false);
    }
    private void init()
    {
        edtDateText = findViewById(R.id.edtDateText);
        edtDate = findViewById(R.id.edtDate);
        edtFilingDateText = findViewById(R.id.edtFilingDateText);
        edtSIN = findViewById(R.id.edtSIN);
        edtSINText = findViewById(R.id.edtSINText);
        btnClear = findViewById(R.id.btnClear);
        btnSubmit = findViewById(R.id.btnSubmit);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtFirstNameText = findViewById(R.id.edtFirstNameText);
        edtLastName = findViewById(R.id.edtLastName);
        edtLastNameText = findViewById(R.id.edtLastNameText);
        edtRRSP = findViewById(R.id.edtRRSP);
        edtRRSPText = findViewById(R.id.edtRRSPtext);
        edtGrossIncome = findViewById(R.id.edtGrossIncome);
        edtGrossIncomeText = findViewById(R.id.edtGrossIncomeText);
        rdBtnFemale = findViewById(R.id.rdBtnFemale);
        rdBtnMale = findViewById(R.id.rdBtnMale);
        rdBtnOther = findViewById(R.id.rdBtnOther);
    }



    




}
