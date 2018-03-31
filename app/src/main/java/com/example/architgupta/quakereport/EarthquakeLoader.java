package com.example.architgupta.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by Archit Gupta on 8/7/2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<EarthQuake>> {
    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;
    public EarthquakeLoader(Context context , String url)
    {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.e(LOG_TAG, "In OnStartLoading...");
        forceLoad();
            }

    @Override
    public List<EarthQuake> loadInBackground() {
        Log.e(LOG_TAG, "In loadInBackground...");
        if(mUrl == null){
            return null;
        }
        List<EarthQuake> earthQuakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthQuakes;
    }
}
