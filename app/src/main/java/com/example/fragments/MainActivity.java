package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements NumbersMultiplier {

    private FragmentManager fM = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public Double stringsMultiplier(String x, String y) {
        Double a = Double.parseDouble(x);
        Double b = Double.parseDouble(y);
        return a * b;
    }

    @Override
    public void multiply(String x, String y) {
        TopFragment topFragment = (TopFragment) fM.findFragmentById(R.id.topFrag);
        topFragment.setTextView(stringsMultiplier(x,y).toString());
    }
}
