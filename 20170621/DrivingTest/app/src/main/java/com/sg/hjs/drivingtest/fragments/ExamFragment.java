package com.sg.hjs.drivingtest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sg.hjs.drivingtest.R;
import com.sg.hjs.drivingtest.controllers.ExamFragmentController;
import com.sg.hjs.drivingtest.databinding.FragmentExamBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamFragment extends Fragment {


    private FragmentExamBinding binding;
    private ExamFragmentController controller;

    public ExamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentExamBinding.inflate(inflater);
        controller = new ExamFragmentController(binding, this);
        binding.setController(controller);
        return binding.getRoot();
    }

}
