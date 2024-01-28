package com.rectering.ranode.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rectering.ranode.R;
import com.rectering.ranode.databinding.ActivityDetailBinding;
import com.rectering.ranode.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {
ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.introBtn.setOnClickListener(v -> startActivity(new Intent(IntroActivity.this, MainActivity.class)));

    }
}