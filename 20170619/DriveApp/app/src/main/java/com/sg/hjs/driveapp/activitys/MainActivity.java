package com.sg.hjs.driveapp.activitys;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sg.hjs.driveapp.R;
import com.sg.hjs.driveapp.controller.MainController;
import com.sg.hjs.driveapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        findViewById()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        controller = new MainController(binding, this);
        binding.setController(controller);

    }
}
