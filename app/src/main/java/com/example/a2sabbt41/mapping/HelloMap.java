package com.example.a2sabbt41.mapping;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;

import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;import android.content.Intent;

public class HelloMap extends Activity
{

    MapView mv;

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this line tells OpenStreetMap about our app.
        // If you miss this out, you might get banned from OSM servers
        Configuration.getInstance().load
                (this, PreferenceManager.getDefaultSharedPreferences(this));

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(51.05,-0.72));
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_hello_map, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.choosemap)
        {
            Intent intent = new Intent(this,MapChooseActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}