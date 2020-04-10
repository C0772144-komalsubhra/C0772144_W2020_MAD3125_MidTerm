package com.example.c0772144_w2020_mad3125_midterm.Activities;

public class CalculatorActivity {
    double grossInc;
    double rrspAmt;

    public CalculatorActivity(double grossIncome, double rrspAmount) {
        this.grossInc = grossIncome;
        this.rrspAmt = rrspAmount;
    }

    public double getGrossInc() {
        return grossInc;
    }

    public void setGrossInc(double grossInc) {
        this.grossInc = grossInc;
    }

    public double getRrspAmt() {
        return rrspAmt;
    }

    public void setRrspAmt(double rrspAmt) {
        this.rrspAmt = rrspAmt;
    }

    public double calculateTaxOfProvince(double TaxableIncome)
    {
        if(TaxableIncome <= 10500.0d) {
            return 0.0d;
        }
        else if(TaxableIncome >= 10570.0d && TaxableIncome <=42000.0d)
        {
            return 0.0505d;
        }
        else if(TaxableIncome >= 42000.0d && TaxableIncome <= 87045.0d)
        {
            return 0.0915d;
        }
        else if (TaxableIncome >= 87045.0d && TaxableIncome <= 150000.0d) {
            return 0.1116d;
        }
        else if (TaxableIncome >= 150000.0d && TaxableIncome <= 220000.0d)
        {
            return 0.1216d;
        }
        else
        {
            return 0.1316d;
        }
    }

    public double calculateTaxOfFederal(double TaxableIncome)
    {
        if(TaxableIncome <=  12059.0d) {
            return 0.0d;
        }
        else if(TaxableIncome >= 12059.0d && TaxableIncome <= 46530.0d){
            return 0.15d;
        }
        else if(TaxableIncome >= 46530.01d && TaxableIncome <= 94350.0d){
            return 0.2050d;
        }
        else if(TaxableIncome >= 94350.01d && TaxableIncome <= 146430.0d){
            return 0.26d;
        }
        else if(TaxableIncome >= 146430.01d && TaxableIncome <= 210272.0d){
            return 0.29d;
        }
        else {
            return 0.33d;
        }
    }

    public double calculateCPP(double grossIncome)
    {
        double cpp;
        if(this.grossInc >= 56400)
        {
            cpp = 56400*0.051;
        }
        else {
            cpp = grossIncome*0.051;
        }
        return cpp;
    }

    public double calculateEI(double grossIncome)
    {
        double ei;
        if(this.grossInc >= 54000)
        {
            ei = 54000*0.0162;
        }
        else
        {
            ei = grossIncome*0.0162;
        }
        return ei;
    }
}