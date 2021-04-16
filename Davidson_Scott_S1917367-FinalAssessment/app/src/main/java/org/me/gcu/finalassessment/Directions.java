//Scott William Davidson, Matriculation Number: S1917367
package org.me.gcu.finalassessment;

import android.util.Log;

public class Directions {
    public String mostNorthern;
    public double mostNorthernVariable = 0.00 ;
    public String mostEasternString;
    public double mostEasternVariable = -10.00;
    public String mostSouthern;
    public double mostSouthernVariable = 100.00;
    public String mostWestern;
    public double mostWesternVariable = 100.00;

    public void getMostNorthern()
    {
        if(Double.parseDouble(MainActivity.item.getLat()) > MainActivity.direction.mostNorthernVariable)
        {
            MainActivity.direction.mostNorthernVariable = Double.parseDouble(MainActivity.item.getLat());
            String[] dataString = MainActivity.item.getTitle().split(":");
            String section2 = dataString[2].trim();
            String[] locs = section2.split(", ");
            String location = locs[0].trim();
            MainActivity.direction.mostNorthern = "Most Northern location: " + location + "\n" + "Most Northern geo:lat: " + MainActivity.direction.mostNorthernVariable + "\n" + "Most Northern geo:long: " + MainActivity.item.getLong();
            Log.d("Northern", String.valueOf(MainActivity.direction.mostNorthernVariable));
        }
    }

    public void getMostWestern()
    {
        if(MainActivity.direction.mostWesternVariable > Double.parseDouble(MainActivity.item.getLong()))
        {
            MainActivity.direction.mostWesternVariable = Double.parseDouble(MainActivity.item.getLong());
            String[] dataString = MainActivity.item.getTitle().split(":");
            String section2 = dataString[2].trim();
            String[] locs = section2.split(", ");
            String location = locs[0].trim();
            MainActivity.direction.mostWestern = "Most Western Location: " + location + "\n" + "Most Western geo:lat: " + MainActivity.item.getLat() + "\n" + "Most western geo:long: " + MainActivity.direction.mostWesternVariable;
        }
    }

    public void getMostSouthern()
    {
        if(MainActivity.direction.mostSouthernVariable > Double.parseDouble(MainActivity.item.getLat()))
        {
            MainActivity.direction.mostSouthernVariable = Double.parseDouble(MainActivity.item.getLat());
            String[] dataString = MainActivity.item.getTitle().split(":");
            String section2 = dataString[2].trim();
            String[] locs = section2.split(", ");
            String location = locs[0].trim();
            MainActivity.direction.mostSouthern = "Most Southern Location: " + location + "\n" + "Most Southern geo: lat: " + MainActivity.direction.mostSouthernVariable + "\n" + "Most Southern geo:long: " + MainActivity.item.getLong();
        }
    }


    public void getMostEastern()
    {
        if(Double.parseDouble(MainActivity.item.getLong()) > MainActivity.direction.mostEasternVariable)
        {
            MainActivity.direction.mostEasternVariable = Double.parseDouble(MainActivity.item.getLong());
            String[] dataString = MainActivity.item.getTitle().split(":");
            String section2 = dataString[2].trim();
            String[] locs = section2.split(", ");
            String location = locs[0].trim();
            MainActivity.direction.mostEasternString = "Most Eastern Location: " + location + "\n" + "Most Eastern geo:lat: " + MainActivity.item.getLat() + "\n" + "Most Eastern geo: long: " + MainActivity.direction.mostEasternVariable;
        }
    }

    public void AddToTextview()
    {
        MainActivity.MostNorthern.setText(MainActivity.direction.mostNorthern);
        MainActivity.mostEastern.setText(MainActivity.direction.mostEasternString);
        MainActivity.mostSouthernly.setText(MainActivity.direction.mostSouthern);
        MainActivity.mostWesterly.setText(MainActivity.direction.mostWestern);
        MainActivity.largestMagnitude.setText(MainActivity.infoStorer.largestMagnitudeString);
        MainActivity.deepestQuake.setText(MainActivity.infoStorer.largestDepth);
        MainActivity.shallowestQuake.setText(MainActivity.infoStorer.smallestDepth);
    }

    public void recalculateDirections()
    {
        mostNorthernVariable = 0;
        mostNorthern = "New value " + mostNorthernVariable;
        mostSouthernVariable = 100.0;
        mostSouthern = "New southern variable: " + mostSouthernVariable;
        mostWesternVariable = 100.0;
        mostWestern = "Most western variable: " + mostWesternVariable;
        mostEasternVariable  = -10;
        mostEasternString = "Most Eastern Variable: " + mostEasternVariable;
    }
}
