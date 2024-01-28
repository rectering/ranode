package com.rectering.ranode.Activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rectering.ranode.Adapter.NearbyAdapter;
import com.rectering.ranode.Adapter.RecommendedAdapter;
import com.rectering.ranode.Domain.PropertyDomain;
import com.rectering.ranode.R;
import com.rectering.ranode.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private RecyclerView.Adapter adapterRecommended, adapterNearby;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initLocation();
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PropertyDomain> items = new ArrayList<>();
        items.add(new PropertyDomain("Apartment", "Royal Apartment", "San Francisco", "h_1",950, 1,1,true, 4.5, "This 1 bed /1 bath home boasts an enormous, open-living plan, accent by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceiling."));
        items.add(new PropertyDomain("Home", "House with Great View", "Florida", "h_2",1600, 2,3,true, 4.9, "This 2 bed /3 bath home boasts an enormous, open-living plan, accent by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceiling."));
        items.add(new PropertyDomain("Villa", "Royal Villa", "Los Angeles", "h_3",1200, 2,2,false, 4.0, "This 2 bed /2 bath home boasts an enormous, open-living plan, accent by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceiling."));

        binding.recommendedView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterRecommended = new RecommendedAdapter(items);
        binding.recommendedView.setAdapter(adapterRecommended);

        binding.nearbyView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterNearby = new NearbyAdapter(items);
        binding.nearbyView.setAdapter(adapterNearby);
    }

    private void initLocation() {
        String[] items = new String[]{"Los Angeles","San Francisco", "New York"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.locationSpin.setAdapter(adapter);
    }
}
