package com.example.architgupta.quakereport;

/*
 * Created by Archit Gupta on 7/19/2017.
 */

public class EarthQuake {
    private double mMagnitude;
    private String mLocation;
    private long mDate;
    private String murl;
    public EarthQuake(double Magnitude,String Location,long Date,String url)
    {
        mMagnitude = Magnitude;
        mLocation = Location;
        mDate = Date;
        murl = url;
    }
    public double getMagnitude()
    {
        return mMagnitude;
    }
    public String getLocation()
    {
        return mLocation;
    }
    public Long getDate()
    {
        return mDate;
    }
    public String getUrl()
    {
        return murl;
    }
}
