package com.sg.hjs.drawingboard2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by hjs on 17-6-6.
 */

public class BoardView extends SurfaceView implements View.OnTouchListener, SurfaceHolder.Callback {
    private Path path = new Path();  // 路径
    private Paint paint = new Paint();

    public BoardView(Context context) {
        super(context);

        paint.setColor(0xffff0000);  // 画笔颜色
        paint.setStrokeWidth(5);  // 画笔宽度
        paint.setStyle(Paint.Style.STROKE);  // 样式


        setOnTouchListener(this);  // 触摸事件
        getHolder().addCallback(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());
                reDrawPath();  // 重绘
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    /**
     * 重置路径
     */
    private void reDrawPath() {
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(0xffffffff);
        canvas.drawPath(path, paint);
        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        reset();
    }

    private void reset() {
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(0xffffffff);
        getHolder().unlockCanvasAndPost(canvas);

        path.reset();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
