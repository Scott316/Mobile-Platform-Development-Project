//Scott William Davidson, Matriculation Number: S1917367

package org.me.gcu.finalassessment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.me.gcu.equakestartercode.R;

import java.util.StringTokenizer;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener, PopupMenu.OnMenuItemClickListener
{

    private GoogleMap mMap;

    private ViewSwitcher avw;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Log.e(getPackageName(), "just before avw");
        avw = (ViewSwitcher) findViewById(R.id.vwSwitch);
        if (avw == null)
        {
            Toast.makeText(getApplicationContext(), "Null ViewSwicther", Toast.LENGTH_LONG).show();
            Log.e(getPackageName(), "null pointer");
        }


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }

    public void showPopUpMenu(View view)
    {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.pop_up_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.ListViewTransition:
                startActivity(new Intent(MapsActivity.this, MainActivity.class));
                return true;
            case R.id.NormalViewButton:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.TerrainViewButton:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            case R.id.HybridViewButton:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case R.id.satelliteViewButton:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
             default:
                return false;
        }
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        for (int i = 0; i < InfoStorer.itemGeoLat.size(); i++)
        {
            LatLng eq = new LatLng(Double.valueOf(InfoStorer.itemGeoLat.get(i)), Double.valueOf(InfoStorer.itemGeoLong.get(i)));
            //mMap.addMarker(new MarkerOptions().position(eq).title(InfoStorer.itemTitles.get(i)));
            for(int z = 0; z < InfoStorer.itemMags.size(); z++) {
                if (Integer.valueOf(String.valueOf(InfoStorer.itemMags.get(i) * 10).replaceAll("[^0-9]", "")) <= 100) {
                    mMap.addMarker(new MarkerOptions().position(eq).title(InfoStorer.itemTitles.get(i)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                }
                else
                    if (Integer.parseInt(String.valueOf(InfoStorer.itemMags.get(i) * 10).replaceAll("[^0-9]", "")) > 100 && Integer.parseInt(String.valueOf(InfoStorer.itemMags.get(i) * 10).replaceAll("[^0-9]", "")) <= 200) {
                    mMap.addMarker(new MarkerOptions().position(eq).title(InfoStorer.itemTitles.get(i)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                }
                else
                    if (Integer.parseInt(String.valueOf(InfoStorer.itemMags.get(i) * 10).replaceAll("[^0-9]", "")) > 200 && Integer.parseInt(String.valueOf(InfoStorer.itemMags.get(i) * 10).replaceAll("[^0-9]", "")) <= 300) {
                        mMap.addMarker(new MarkerOptions().position(eq).title(InfoStorer.itemTitles.get(i)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));

                    }
                    else
                    if (Integer.parseInt(String.valueOf(InfoStorer.itemMags.get(i) * 10).replaceAll("[^0-9]", "")) > 300 && Integer.parseInt(String.valueOf(InfoStorer.itemMags.get(i) * 10).replaceAll("[^0-9]", "")) <= 400) {
                        mMap.addMarker(new MarkerOptions().position(eq).title(InfoStorer.itemTitles.get(i)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                    }
                    else
                    if (Integer.parseInt(String.valueOf(InfoStorer.itemMags.get(i) * 10).replaceAll("[^0-9]", "")) > 400 && Integer.parseInt(String.valueOf(InfoStorer.itemMags.get(i) * 10).replaceAll("[^0-9]", "")) <= 500) {
                        mMap.addMarker(new MarkerOptions().position(eq).title(InfoStorer.itemTitles.get(i)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    }

            }
        }
        LatLng eq1 = new LatLng(Double.valueOf(InfoStorer.itemGeoLat.get(0)), Double.valueOf(InfoStorer.itemGeoLong.get(0)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(eq1));
    }

    @Override
    public void onClick(View arg0)
    {

    }


} // End of Main Activity