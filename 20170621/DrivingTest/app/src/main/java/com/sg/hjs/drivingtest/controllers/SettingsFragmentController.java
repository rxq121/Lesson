package com.sg.hjs.drivingtest.controllers;

import com.sg.hjs.drivingtest.databinding.FragmentSettingsBinding;
import com.sg.hjs.drivingtest.fragments.SettingsFragment;

/**
 * Created by hjs on 17-6-22.
 */

public class SettingsFragmentController {
    private FragmentSettingsBinding binding;
    private SettingsFragment fragment;

    public SettingsFragmentController(FragmentSettingsBinding binding, SettingsFragment fragment) {
        this.binding = binding;
        this.fragment = fragment;
    }
}
