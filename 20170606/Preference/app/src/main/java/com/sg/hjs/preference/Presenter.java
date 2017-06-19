package com.sg.hjs.preference;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.ObservableBoolean;
import android.view.View;
import android.widget.CompoundButton;

import com.sg.hjs.preference.databinding.ActivityMainBinding;

/**
 * Created by hjs on 17-6-6.
 */

public class Presenter {

    private static final String PREFERENCE_NAME = "myCheckState";
    private ActivityMainBinding mBinding;
    public final ObservableBoolean buttonEnabled = new ObservableBoolean(false);
    private SharedPreferences mPreferences;

    public Presenter(ActivityMainBinding binding) {
        this.mBinding = binding;

        mPreferences = this.mBinding.getRoot().getContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);

        addListeners();

        readCheckState();
    }

    void addListeners() {
        this.mBinding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println(isChecked);

                buttonEnabled.set(isChecked);

                saveCheckState();
            }
        });
    }

    public void buttonClickedHandler(View v) {
        new AlertDialog.Builder(v.getContext())
                .setTitle("title")
                .setMessage("Helllo")
                .show();
    }

    private void saveCheckState() {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean("checked", mBinding.checkBox.isChecked());
        editor.apply();
    }

    private void readCheckState() {
        boolean checked = mPreferences.getBoolean("checked", false);
        mBinding.checkBox.setChecked(checked);
        buttonEnabled.set(checked);
    }
}
