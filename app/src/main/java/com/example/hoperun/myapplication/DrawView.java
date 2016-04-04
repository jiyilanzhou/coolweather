package com.example.hoperun.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2015/7/15.
 */
public class DrawView extends View {
    public float currentX = 40;
    public float currnetY = 50;
    //定义并创建画笔
    Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawCircle(currentX,currnetY,15,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //修改currentX,currentY两个属性
        currentX = event.getX();
        currnetY = event.getY();
        invalidate();

        return true;
    }
}
