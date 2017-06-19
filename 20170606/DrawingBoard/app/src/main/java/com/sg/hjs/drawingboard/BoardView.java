package com.sg.hjs.drawingboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by hjs on 17-6-6.
 */

public class BoardView extends SurfaceView implements View.OnTouchListener, SurfaceHolder.Callback {
    private float startX, startY;
    private Paint paint = new Paint();

    public BoardView(Context context) {
        super(context);

        getHolder().addCallback(this);
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
//        setBackgroundColor(Color.WHITE);
        setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("ACTION_DOWN");
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("ACTION_MOVE");

                drawLineToPoint(event.getX(), event.getY());
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("ACTION_UP");
                break;
        }

        // 返回值: 事件是否被取消
        return true;
    }

    private void drawLineToPoint(float x, float y) {
        Canvas canvas = getHolder().lockCanvas();
        if (canvas != null) {
            canvas.drawLine(startX, startY, x, y, paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        resetBoard();

    }

    private void resetBoard() {
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(0xffffffff);
        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
