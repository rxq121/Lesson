package com.sg.hjs.userlist;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.LinearLayoutManager;

import com.sg.hjs.userlist.databinding.ActivityMainBinding;

/**
 * Created by hjs on 17-6-6.
 */

public class Controller {
    private SQLiteDatabase database;
    private ActivityMainBinding binding;
    private UserListAdapter adapter;

    public Controller(ActivityMainBinding binding) {
        this.binding = binding;
        adapter = new UserListAdapter(null, binding.getRoot().getContext());

        connectSqlitDatabase();
        initUI();
        readDataFromDB();
    }

    private void connectSqlitDatabase() {
        database = binding.getRoot().getContext().openOrCreateDatabase("users", Context.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL DEFAULT \"\"," +
                "age TEXT NOT NULL DEFAULT \"\")");

//        ContentValues cvs = new ContentValues();
//        cvs.put("name", "张三");
//        cvs.put("age", "12");
//        database.insert("user", "", cvs);
//
//        cvs = new ContentValues();
//        cvs.put("name", "张三");
//        cvs.put("age", "13");
//        database.insert("user", "", cvs);
//
//        cvs = new ContentValues();
//        cvs.put("name", "张三");
//        cvs.put("age", "14");
//        database.insert("user", "", cvs);
//
//        cvs = new ContentValues();
//        cvs.put("name", "张三");
//        cvs.put("age", "15");
//        database.insert("user", "", cvs);
    }

    private void readDataFromDB() {
        Cursor userCursor = database.query("user", null, null, null, null, null, null, null);
        adapter.setCursur(userCursor);
    }


    private void initUI() {
        binding.userlist.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(), LinearLayoutManager.VERTICAL, false));
        binding.userlist.setAdapter(adapter);
    }
}
