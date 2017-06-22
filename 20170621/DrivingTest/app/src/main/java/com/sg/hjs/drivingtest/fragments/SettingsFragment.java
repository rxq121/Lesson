package com.sg.hjs.drivingtest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sg.hjs.drivingtest.R;
import com.sg.hjs.drivingtest.controllers.SettingsFragmentController;
import com.sg.hjs.drivingtest.databinding.FragmentSettingsBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {


    private FragmentSettingsBinding binding;
    private SettingsFragmentController controller;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater);
        controller = new SettingsFragmentController(binding, this);
        binding.setController(controller);
        return binding.getRoot();
    }

}
