//Scott William Davidson, Matriculation Number: S1917367
package org.me.gcu.finalassessment;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;


public class InfoStorer {
    public static ArrayList<String> itemInfo = new ArrayList<>();
    public static ArrayList<String> itemTitles = new ArrayList<>();
    public static ArrayList<String> itemLinks = new ArrayList<>();
    public static ArrayList<String> itemDescription = new ArrayList<>();
    public static ArrayList<String> itemPubdate = new ArrayList<>();
    public static ArrayList<String> itemCategories = new ArrayList<>();
    public static ArrayList<String> itemGeoLat = new ArrayList<>();
    public static ArrayList<String> itemGeoLong = new ArrayList<>();
    public static ArrayList<String> strengthAndLocation = new ArrayList<>();
    public static ArrayList<Float> itemMags = new ArrayList<>();
    public float largestMagniitudeValue = 0;
    public String largestMagnitudeString;
    public Integer largestDepthValue = 10;
    public String largestDepth;
    public Integer smallestDepthValue = 9;
    public String smallestDepth;



    public void magsAndLocationGetter()
    {
        for (int i = 0; i < itemTitles.size(); i++) {
            String[] dataString = itemTitles.get(i).split(":");
            String section = dataString[0].trim();
            String section1 = dataString[1].trim();
            String section2 = dataString[2].trim();
            Log.d("Stuff", section + section1 + section2);
            String Magnitudes = section1.replaceAll("[^0-9.]", "");
            Log.d("Mags", Magnitudes);
            Float magsNums = Float.valueOf(Magnitudes);
            Log.d("Mags", String.valueOf(magsNums));
            String[] locs = section2.split(", ");
            String loc1 = locs[0].trim();
            Log.d("Locs", loc1);
            itemMags.add(magsNums);
            strengthAndLocation.add("Location of the earthquake: " + loc1 + "\n" + "Magnitude of earthquake:" + " " + magsNums + "\n" + "Earthquake's Geo Lat: " + InfoStorer.itemGeoLat.get(i) + "\n" +"Earthquakes's Geo Long: " + InfoStorer.itemGeoLong.get(i));
        }
    }

    public void AddToLists()
    {
        itemTitles.add(MainActivity.item.getTitle());
        itemDescription.add(MainActivity.item.getDescription());
        itemLinks.add(MainActivity.item.getLink());
        itemPubdate.add(MainActivity.item.getPubDate());
        itemCategories.add(MainActivity.item.getCategory());
        itemGeoLat.add(MainActivity.item.getLat());
        itemGeoLong.add(MainActivity.item.getLong());
        Log.d("Full Info", InfoStorer.itemInfo.toString());
        Log.d("Item Titles", InfoStorer.itemTitles.toString());
        Log.d("Item Descriptions", InfoStorer.itemDescription.toString());
        Log.d("Item Links", InfoStorer.itemLinks.toString());
        Log.d("Item pubDates", InfoStorer.itemPubdate.toString());
        Log.d("Item categories",InfoStorer.itemCategories.toString());
        Log.d("Item Geo Lats", InfoStorer.itemGeoLat.toString());
        Log.d("Item Geo Longs", InfoStorer.itemGeoLong.toString());
    }

    public void reset()
    {
        largestDepthValue = -10;
        largestDepth = "new largest: " + largestDepthValue;
        smallestDepthValue = 9;
        smallestDepth = "new smallest depth: " + smallestDepthValue;
        largestMagniitudeValue = 0;
        largestMagnitudeString = "Largest Magnitude: " + largestMagniitudeValue;

    }
}