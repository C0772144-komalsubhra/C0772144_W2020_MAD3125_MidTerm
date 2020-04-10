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
        else if(TaxableIncome >= 43906.0d && TaxableIncome <= 87813.0d)
        {
            return 0.0915d;
        }
        else if (TaxableIncome >= 87813.0d && TaxableIncome <= 150000.0d) {
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
        if(TaxableIncome <=  12069.0d) {
            return 0.0d;
        }
        else if(TaxableIncome >= 12069.0d && TaxableIncome <= 47630.0d){
            return 0.15d;
        }
        else if(TaxableIncome >= 47630.01d && TaxableIncome <= 95259.0d){
            return 0.2050d;
        }
        else if(TaxableIncome >= 95259.01d && TaxableIncome <= 147667.0d){
            return 0.26d;
        }
        else if(TaxableIncome >= 147667.01d && TaxableIncome <= 210371.0d){
            return 0.29d;
        }
        else {
            return 0.33d;
        }
    }

    public double calculateCPP(double grossIncome)
    {
        double cpp;
        if(this.grossInc >= 57400)
        {
            cpp = 57400*0.051;
        }
        else {
            cpp = grossIncome*0.051;
        }
        return cpp;
    }

    public double calculateEI(double grossIncome)
    {
        double ei;
        if(this.grossInc >= 53100)
        {
            ei = 53100*0.0162;
        }
        else
        {
            ei = grossIncome*0.0162;
        }
        return ei;
    }
}