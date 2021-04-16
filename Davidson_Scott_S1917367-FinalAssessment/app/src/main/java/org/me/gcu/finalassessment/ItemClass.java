//Scott William Davidson, Matriculation Number: S1917367
package org.me.gcu.finalassessment;


import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


        public class ItemClass {
    private String title;
    private String description;
    private String link;
    private String pubDate;
    private String category;
    private String geolat;
    private String geolong;
    public InfoStorer infoStorer;
    private Date converted;
        public ItemClass()
    {
        title = "";
        description= " ";
        link = " ";
        pubDate = " ";
        category = " ";
        geolat = " ";
        geolong = " ";
    }

    public ItemClass(String atitle, String adescription, String alink, String apubDate, String acategory, String alat, String along)
    {
        title = atitle;
        description = adescription;
        link = alink;
        pubDate = apubDate;
        category = acategory;
        geolat = alat;
        geolong = along;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String atitle)
    {
        title = atitle;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String adescription) {
        description = adescription;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String alink)
    {
        link = alink;
    }

    public String getPubDate()
    {
        return pubDate;
    }

    public void setPubDate(String apubdate) {
        pubDate = apubdate;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String acategory)
    {
        category = acategory;
        Log.d("MyTag", "Item category Stored: " + category);
    }

    public String getLat()
    {
        return geolat;
    }

    public void setLat(String alat)
    {
        geolat = alat;
    }

    public String getLong() { return geolong; }

    public void setLong(String along)
    {
        geolong = along;
    }

    public String toString()
    {
        String temp;

        temp = title + " " + description + " " + link + " " + pubDate + " " + category + " " + geolat + " " + geolong;

        return temp;
    }

            public void getDepths()
            {
                String[] depthString = getDescription().split(";");
                String part4 = depthString[3].trim();
                String depths = part4.replaceAll("[^0-9]", "");
                Integer depth = Integer.valueOf(depths);
                if(depth > MainActivity.infoStorer.largestDepthValue)
                {
                    MainActivity.infoStorer.largestDepthValue = depth;
                    String[] data = getTitle().split(":");
                    String section2 = data[2].trim();
                    String[] locs = section2.split(", ");
                    String location = locs[0].trim();
                    MainActivity.infoStorer.largestDepth = "Largest depth location: " + location + "\n" + "Largest depth: " + MainActivity.infoStorer.largestDepthValue + "\n" + "Largest depth geo:lat: " + getLat() + "\n" + "Largest depth geo:long: " + getLong();
                }
                else
                if(MainActivity.infoStorer.smallestDepthValue > depth)
                {
                    MainActivity.infoStorer.smallestDepthValue = depth;
                    String[] data = getTitle().split(":");
                    String section2 = data[2].trim();
                    String[] locs = section2.split(", ");
                    String location = locs[0].trim();
                    MainActivity.infoStorer.smallestDepth = "Smallest depth location: " + location + "\n" + "Smallest depth: " + MainActivity.infoStorer.smallestDepthValue + "\n" + "Smallest depth geo:lat: " + getLat() + "\n" + "Smallest depth geo:long: " + getLong();
                }

            }

            public void getMagnitudes()
            {
                String[] dataString = MainActivity.item.getTitle().split(":");
                String section1 = dataString[1].trim();
                String Magnitudes = section1.replaceAll("[^0-9.]", "");
                Float magsNums = Float.valueOf(Magnitudes);
                if(magsNums > MainActivity.infoStorer.largestMagniitudeValue)
                {
                    MainActivity.infoStorer.largestMagniitudeValue = magsNums;
                    String[] data = MainActivity.item.getTitle().split(":");
                    String section2 = data[2].trim();
                    String[] locs = section2.split(", ");
                    String location = locs[0].trim();
                    MainActivity.infoStorer.largestMagnitudeString = "Largest Magnitude Location: " + location + "\n" + "Largest magnitude: " + MainActivity.infoStorer.largestMagniitudeValue + "\n" + "Largest Magnitude geo:lat: " + MainActivity.item.getLat() + "\n" + "Largest Magnitude geo:long: " + MainActivity.item.getLong();

                }
            }

            public Date dateConverted()
            {
                DateFormat formatOfDate = new SimpleDateFormat("EEE, s MMM yyy", Locale.ENGLISH);
                try{
                    Date date = formatOfDate.parse(pubDate);
                    converted = date;
                    Log.d("Date converted: ", String.valueOf(converted));
                } catch (ParseException e){
                    e.printStackTrace();
                    Log.d("Date conversion error: ", "About the converting... it doesn't");
                }
                return converted;
            }

        }