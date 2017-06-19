package com.sg.hjs.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try {
//            FileOutputStream data = openFileOutput("data", MODE_PRIVATE);
//            data.write("Hello World".getBytes("utf-8"));
//            data.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            FileInputStream data = openFileInput("data");
            // 发生阻塞的时候,是不能使用available
            // 线程不阻塞的情况下可以使用
            byte[] bytes = new byte[data.available()];
            data.read(bytes);

//            BufferedReader br = new BufferedReader(new InputStreamReader(data, "utf-8"));
//            String line = br.readLine();
//            System.out.println(line);
            data.close();

            System.out.println(new String(bytes, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
