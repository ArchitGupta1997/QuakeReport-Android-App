package com.example.architgupta.quakereport;

import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
 * Created by Archit Gupta on 7/20/2017.
 */

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {
    private static final String delimitter = "of";
    public EarthQuakeAdapter(EarthquakeActivity context, List<EarthQuake> earthquakes)
    {
        super(context,0,earthquakes);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listItemView = convertView;
        if ( listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }
        EarthQuake currentEarthquake = getItem(position);
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        GradientDrawable magnitudeCirle =(GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCirle.setColor(magnitudeColor);
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        String magnitude = magnitudeFormat.format(currentEarthquake.getMagnitude());
        magnitudeView.setText(magnitude);
        String location = currentEarthquake.getLocation();
        String[] place = location.split("of ");

        String offset,primary;
        if( location.contains(delimitter))
        {
            offset = place[0] + delimitter;
            primary = place[1];
        }
        else
        {
            offset = "Near the";
            primary = location;
        }
        TextView offsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        offsetView.setText(offset);
        TextView primaryView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryView.setText(primary);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        Date dateObject = new Date(currentEarthquake.getDate());
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);
        return listItemView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private int getMagnitudeColor(double magnitude)
    {
        int magnitudeResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch(magnitudeFloor)
        {
            case 0:
            case 1:
                magnitudeResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeResourceId);
    }
}
