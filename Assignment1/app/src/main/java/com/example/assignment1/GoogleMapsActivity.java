package com.example.assignment1;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.assignment1.provider.Category;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.assignment1.databinding.ActivityGoogleMapsBinding;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import com.example.assignment1.CategoryActivity;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityGoogleMapsBinding binding;
    private String locationToFocus, categoryName;
    //fix this later
    private Geocoder geocoder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Inside onCreate", "");
        //modify this later
        geocoder = new Geocoder(this, Locale.getDefault());
        binding = ActivityGoogleMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //getting the value from intent
        locationToFocus = getIntent().getExtras().getString("categoryLocation");
        categoryName = getIntent().getExtras().getString("categoryName");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        findLocation();


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                // Implement the logic for map click here
                // Save current location
                String msg;
                String selectedCountry = "";

                List<Address> addresses = new ArrayList<>();
                try {
                    // The results of getFromLocation are a best guess and are not guaranteed to be meaningful or correct.
                    // It may be useful to call this method from a thread separate from your primary UI thread.
                    addresses = geocoder.getFromLocation(point.latitude, point.longitude, 1); // Last param means only return the first address object
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (addresses.size() == 0) {
                    msg = "No Country at this location! Sorry!";

                } else {
                    android.location.Address address = addresses.get(0);
                    selectedCountry = address.getCountryName();
                    msg = "The Selected Country is:  " + selectedCountry;

                }

                // Show Snackbar with appropriate message and action
                Snackbar.make(binding.getRoot(), msg, Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }

    public void findLocation() {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        if (!locationToFocus.isEmpty()) {
            geocoder.getFromLocationName(locationToFocus, 1, location -> {
                // if there are results, this condition would return true
                if (!location.isEmpty()) {
                    // run on UI thread as the user interface will update once set map location
                    runOnUiThread(() -> {
                        // define new LatLng variable using the first address from list of location
                        LatLng newAddressLocation = new LatLng(
                                location.get(0).getLatitude(),
                                location.get(0).getLongitude()
                        );

                        // repositions the camera according to newAddressLocation
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(newAddressLocation));

                        // add a new Marker
                        mMap.addMarker(
                                new MarkerOptions()
                                        .position(newAddressLocation)
                                        .title(categoryName)
                        );

                        // set zoom level to 8.5f or any number between range of 2.0 to 21.0
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(10f));
                        Snackbar.make(binding.getRoot(),
                                        "Location: " + locationToFocus, Snackbar.LENGTH_LONG)
                                .show();
                    });
                }
            });
        } else {
            Snackbar.make(binding.getRoot(),
                            "Category address not found", Snackbar.LENGTH_LONG)
                    .show();
        }

    }
}

