package com.sg.hjs.drivingtest.controllers;

import com.sg.hjs.drivingtest.adapters.ExamViewPagerAdapter;
import com.sg.hjs.drivingtest.databinding.FragmentExamBinding;
import com.sg.hjs.drivingtest.fragments.ExamFragment;

/**
 * Created by hjs on 17-6-22.
 */

public class ExamFragmentController {
    private FragmentExamBinding binding;
    private ExamFragment fragment;

    public ExamFragmentController(FragmentExamBinding binding, ExamFragment fragment) {
        this.binding = binding;
        this.fragment = fragment;

        configVP();
    }

    //    getChildFragmentManager  控制子集对象
    private void configVP() {
        binding.vp.setAdapter(new ExamViewPagerAdapter(fragment.getContext(), fragment.getChildFragmentManager()));
        binding.tab.setupWithViewPager(binding.vp);
    }
}
