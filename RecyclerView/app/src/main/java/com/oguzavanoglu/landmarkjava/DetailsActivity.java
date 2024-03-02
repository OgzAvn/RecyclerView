package com.oguzavanoglu.landmarkjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.oguzavanoglu.landmarkjava.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {


    private ActivityDetailsBinding binding;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Intent intent = getIntent();
        Landmark selectedlandmark = (Landmark) intent.getSerializableExtra("landmark");


        binding.nameText.setText(selectedlandmark.name);
        binding.countryText.setText(selectedlandmark.country);
        binding.imageView.setImageResource(selectedlandmark.image);
    }


}