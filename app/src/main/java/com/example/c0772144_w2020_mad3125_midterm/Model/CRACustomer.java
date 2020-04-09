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

    public static final Creator<CRACustomer> CREATOR = new Creator<CRACustomer>() {
        @Override
        public CRACustomer createFromParcel(Parcel in) {
            return new CRACustomer(in);
        }

        @Override
        public CRACustomer[] newArray(int size) {
            return new CRACustomer[size];
        }
    };

    public CRACustomer(String SIN, String firstName, String lastName, Gender gender, org.joda.time.LocalDate stringToDate, float grossIncome, float rrspContributed) {
        this.SIN = SIN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.grossIncome = grossIncome;
        this.rrspContributed = rrspContributed;
    }


    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SIN);
        dest.writeString(firstName);
        dest.writeString(lastName);
        if (grossIncome == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(grossIncome);
        }
        if (rrspContributed == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(rrspContributed);
        }
    }


   /*getter setter*/
    public String getFullName()
    {
        return lastName.toUpperCase() + ", " + firstName;
    }

    public String getSIN() {
        return SIN;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Float grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getRrspContributed() {
        return rrspContributed;
    }

    public void setRrspContributed(Float rrspContributed) {
        this.rrspContributed = rrspContributed;
    }

}
