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
    public CRACustomer(Parcel in) {
        SIN = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        if (in.readByte() == 0) {
            grossIncome = null;
        } else {
            grossIncome = in.readFloat();
        }
        if (in.readByte() == 0) {
            rrspContributed = null;
        } else {
            rrspContributed = in.readFloat();
        }
    }

    


}
