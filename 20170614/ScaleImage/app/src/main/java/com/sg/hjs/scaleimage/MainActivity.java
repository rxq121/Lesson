package com.sg.hjs.scaleimage;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.sg.hjs.scaleimage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ActivityMainBinding binding;
    float lastDiatance = -1;  // 记录

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.getRoot().setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastDiatance = -1;
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getPointerCount() >= 2) {
                    float x1 = event.getX(0);  // 0 第一个触摸点
                    float y1 = event.getY(0);
                    float x2 = event.getX(1);  // 1 第二个触摸点
                    float y2 = event.getY(1);

                    float distanceX = x1 - x2;
                    float distanceY = y1 - y2;

                    // 两点之间的距离
                    float distance = (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);

                    System.out.printf("x1=%f,y1=%f,x2=%f,y2=%f\n", x1, y1, x2, y2);
                    System.out.printf("ditance=%f\n", distance);

                    if (lastDiatance != -1) {

                        // 避免出现 非放大的手势 出现放大
                        if (distance - lastDiatance > 5) {
                            System.out.println("放大");
                            lastDiatance = distance;
                        } else if (distance - lastDiatance < -5) {
                            System.out.println("缩小");
                            lastDiatance = distance;
                        }
                    } else {
                        lastDiatance = distance;
                    }

                }
                break;
        }
        return true;
    }
}
