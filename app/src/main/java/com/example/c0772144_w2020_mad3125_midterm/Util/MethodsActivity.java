package com.example.c0772144_w2020_mad3125_midterm.Util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MethodsActivity {
    private static MethodsActivity repoObj = new MethodsActivity();
    public static MethodsActivity getInstance() {
        return repoObj;
    }

    public LocalDate stringToDate(String aDate)
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MMM-yyyy");
        return formatter.parseLocalDate(aDate);
    }

    public String doubleFormatter(Double d)
    {
        return String.format("%.2f", d);
    }
}

