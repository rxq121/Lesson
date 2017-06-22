package com.sg.hjs.drivingtest.controllers;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.sg.hjs.drivingtest.MainActivity;
import com.sg.hjs.drivingtest.R;
import com.sg.hjs.drivingtest.databinding.ActivityMainBinding;
import com.sg.hjs.drivingtest.fragments.ExamFragment;
import com.sg.hjs.drivingtest.fragments.SettingsFragment;

/**
 * Created by hjs on 17-6-22.
 */

public class MainActivityController {
    private ActivityMainBinding binding;
    private MainActivity mainActivity;
    private int currenitemId; // 避免重复添加fragment

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int itemId = item.getItemId();
            if (currenitemId == itemId) {
                return false;
            }
            currenitemId = itemId;
            switch (itemId) {
                case R.id.navigation_exam:
                    addExamFragment();
                    return true;
                case R.id.navigation_settings:
                    mainActivity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content, new SettingsFragment())
                            .commit();
                    return true;
            }
            return false;
        }
    };

    public MainActivityController(ActivityMainBinding binding, MainActivity mainActivity) {
        this.binding = binding;
        this.mainActivity = mainActivity;

        addExamFragment();
        addLisenter();
    }

    private void addExamFragment() {
        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new ExamFragment())
                .commit();
        currenitemId = R.id.navigation_exam;
    }

    private void addLisenter() {
        binding.navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }
}
