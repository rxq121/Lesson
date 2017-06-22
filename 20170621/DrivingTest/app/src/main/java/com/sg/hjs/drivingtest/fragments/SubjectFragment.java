package com.sg.hjs.drivingtest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sg.hjs.drivingtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectFragment extends Fragment {

    public static final String KEY_TITLE = "NONE";

    public SubjectFragment() {
        setArguments(new Bundle());
    }

    public SubjectFragment setTitle(String title) {
        getArguments().putString(KEY_TITLE, title);
        return this;
    }

    public String getTitle() {
        return getArguments().getString(KEY_TITLE);
    }
}
