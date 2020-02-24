package com.example.mobilappers;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Time;
import java.util.Date;

public class Roll implements Parcelable {

    private int[] dicerolls;
    private Date date;
    private String time1;
    private Time time;
    public Roll(int[] a, String time)
    {
        this.dicerolls = a;
        time1 = time;
    }


    public int[] getDiceRolls()
    {
        return dicerolls;
    }

    public Time getTime()
    {
        return time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
