package com.rectering.ranode.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Property;
import android.view.View;

import com.bumptech.glide.Glide;
import com.rectering.ranode.Domain.PropertyDomain;
import com.rectering.ranode.R;
import com.rectering.ranode.databinding.ActivityDetailBinding;
import com.rectering.ranode.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    private PropertyDomain object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getBundles();
        setVariable();
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());

        int drawableResourceID = getResources().getIdentifier(object.getPicPath(),"drawable", DetailActivity.this.getPackageName());

        Glide.with(DetailActivity.this)
                .load(drawableResourceID)
                .into(binding.picDetail);

        binding.titleTxt.setText(object.getTitle());
        binding.typeTxt.setText(object.getType());
        binding.addressTxt.setText(object.getAddress());
        binding.descriptionTxt.setText(object.getDescription());
        binding.scoreTxt.setText(""+object.getScore());
        binding.priceTxt.setText("$"+object.getPrice());
        binding.bedTxt.setText(object.getBed()+" Bed");
        binding.bathTxt.setText(object.getBath()+" Bath");

        if (object.isWifi()){
            binding.wifiTxt.setText("Wifi");
        } else {
            binding.wifiTxt.setText("No Wifi");
        }
    }

    private void getBundles() {
        object = (PropertyDomain) getIntent().getSerializableExtra("object");

    }
}