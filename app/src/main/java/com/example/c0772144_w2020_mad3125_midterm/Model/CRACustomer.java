package com.example.c0772144_w2020_mad3125_midterm.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.c0772144_w2020_mad3125_midterm.Util.Gender;

import java.time.LocalDate;

public class CRACustomer implements Parcelable {
    private String SIN;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private Float grossIncome;
    private Float rrspContributed;

  

}
