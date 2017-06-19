package com.sg.hjs.driveapp.controller;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sg.hjs.driveapp.R;
import com.sg.hjs.driveapp.activitys.MainActivity;
import com.sg.hjs.driveapp.databinding.ActivityMainBinding;
import com.sg.hjs.driveapp.fragments.SectionFourFragment;
import com.sg.hjs.driveapp.fragments.SectionOneFragment;
import com.sg.hjs.driveapp.fragments.SectionThreeFragment;
import com.sg.hjs.driveapp.fragments.SectionTwoFragment;
import com.sg.hjs.driveapp.fragments.SkiddingFragment;

/**
 * Created by hjs on 17-6-19.
 */

public class MainController {
    private ActivityMainBinding binding;
    private MainActivity mainActivity;

    public MainController(ActivityMainBinding binding, MainActivity mainActivity) {
        this.binding = binding;
        this.mainActivity = mainActivity;

        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, new SectionOneFragment())
                .commit();

        binding.mainRg.setOnCheckedChangeListener(radiogpchange);
    }

    private RadioGroup.OnCheckedChangeListener radiogpchange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        }
    };

    public void rbSectionOneClicked(View view) {
        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, new SectionOneFragment())
                .addToBackStack(SectionOneFragment.NAME)
                .commit();

        Toast.makeText(mainActivity, "one", Toast.LENGTH_SHORT).show();
    }

    public void rbSectionTwoClicked(View view) {
        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, new SectionTwoFragment())
                .addToBackStack(SectionTwoFragment.NAME)
                .commit();

        Toast.makeText(mainActivity, "two", Toast.LENGTH_SHORT).show();
    }

    public void rbSectionThreeClicked(View view) {
        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, new SectionThreeFragment())
                .addToBackStack(SectionThreeFragment.NAME)
                .commit();

        Toast.makeText(mainActivity, "three", Toast.LENGTH_SHORT).show();
    }

    public void rbSectionFourClicked(View view) {
        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, new SectionFourFragment())
                .addToBackStack(SectionFourFragment.NAME)
                .commit();

        Toast.makeText(mainActivity, "three", Toast.LENGTH_SHORT).show();
    }

    public void rbHeadClicked(View v) {
        mainActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.skiddingFrag, new SkiddingFragment())
                .commit();
    }
}
