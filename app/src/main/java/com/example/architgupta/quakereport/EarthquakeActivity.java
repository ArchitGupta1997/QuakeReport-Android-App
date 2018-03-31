package com.example.architgupta.quakereport;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<EarthQuake>>{
    private static final String LOG_TAG = EarthquakeActivity.class.getName();
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private TextView mEmptyTextView;
    private ProgressBar pb;
    private static final String URL_NAME = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=2&limit=100";
    private EarthQuakeAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        //List<EarthQuake> earthquakes = QueryUtils.extractEarthquakes();
        /*earthquakes.add(new EarthQuake("6.2","San Francisco","Feb 2,2016"));
        earthquakes.add(new EarthQuake("5.4","London","March 3,2015"));
        earthquakes.add(new EarthQuake("7.5","Tokyo","June 16,2014"));
        earthquakes.add(new EarthQuake("4.6","Mexico City","May 23,2013"));
        earthquakes.add(new EarthQuake("5.9","Moscow","Nov 1,2011"));
        earthquakes.add(new EarthQuake("8.1","RiodeJaneiro","Dec 7,2012"));
        earthquakes.add(new EarthQuake("6.1","Paris","Feb 10,2010"));
        */
        mEmptyTextView = (TextView) findViewById(R.id.empty_view);
        pb = (ProgressBar) findViewById(R.id.progress_bar);
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        earthquakeListView.setEmptyView(mEmptyTextView);
        mAdapter = new EarthQuakeAdapter(this,new ArrayList<EarthQuake>());
        earthquakeListView.setAdapter(mAdapter);
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EarthQuake currentEarthQuake = mAdapter.getItem(position);
                Uri earthquakeuri = Uri.parse(currentEarthQuake.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeuri);
                startActivity(websiteIntent);
            }
        });
        // Get a reference to the LoaderManager, in order to interact with loaders.
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
        }
        else{
            View loadingIndicator = findViewById(R.id.progress_bar);
            loadingIndicator.setVisibility(View.GONE);
            mEmptyTextView.setText("No internet connection");
        }

        //QuakeAsyncTask task = new QuakeAsyncTask();
        //task.execute(URL_NAME);
    }
    @Override
    public Loader<List<EarthQuake>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        Log.e(LOG_TAG, "In OnCreateLoader...");
        return new EarthquakeLoader(this, URL_NAME);
    }



    @Override
    public void onLoadFinished(Loader<List<EarthQuake>> loader, List<EarthQuake> earthquakes) {
        // Clear the adapter of previous earthquake data
        Log.e(LOG_TAG, "In OnLoadFinished...");
        mAdapter.clear();

        mEmptyTextView.setText("No earthquakes found.");
        pb.setVisibility(GONE);

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthquakes != null && !earthquakes.isEmpty()) {
           mAdapter.addAll(earthquakes);
        }
    }
    @Override
    public void onLoaderReset(Loader<List<EarthQuake>> loader) {
        // Loader reset, so we can clear out our existing data.
        Log.e(LOG_TAG, "In OnLoaderReset..");
        mAdapter.clear();
    }
    /*
    private class QuakeAsyncTask extends AsyncTask<String, Void, List<EarthQuake>> {
        private final String LOG_TAG = QuakeAsyncTask.class.getSimpleName();
        @Override
        protected List<EarthQuake> doInBackground(String... str) {
            if (str.length < 1 || str[0] == null) {
                return null;
            }
            List<EarthQuake> result = QueryUtils.fetchEarthquakeData(str[0]);
            return result;
        }


        @Override
        protected void onPostExecute(List<EarthQuake> earthquakes) {
            mAdapter.clear();
            if(earthquakes!=null&&!earthquakes.isEmpty()) {
                mAdapter.addAll(earthquakes);
            }
            // Find a reference to the {@link ListView} in the layout

        }
    }
    */
}

//https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2002-01-01&endtime=2014-01-30&minmagnitude=7
//https://earthquake.usgs.gov/fdsnws/event/1/
//https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_week.geojson
//https://www.instagram.com/developer/endpoints/media/#get_media
//https://developer.android.com/reference/org/json/JSONObject.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics
//https://jsonformatter.curiousconcept.com/
//https://www.programmableweb.com/apis/directory
//https://developers.google.com/apis-explorer/#p/
//https://www.data.gov/
//https://developer.android.com/reference/android/Manifest.permission.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics
//Android Performance pattern videos:https://www.youtube.com/watch?v=s4eAtMHU5gI&index=8&list=PLWz5rJ2EKKc9CBxr3BVjPTPoDPLdPIFCE
//https://developer.android.com/reference/android/app/LoaderManager.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics
//https://developer.android.com/reference/android/app/LoaderManager.LoaderCallbacks.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics