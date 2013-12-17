package com.example.helloproject.ImgDraw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ImgDrawTextView extends View {

	final String DRAW_STR="小猪文本动画文本";
	Path[] paths=new Path[3];
	Paint mPaint;
	public ImgDrawTextView(Context context)
	{
		super(context);
		paths[0]=new Path();
		paths[0].moveTo(0, 0);
		for(int i=0;i<=7;i++)
		{
			paths[0].lineTo(i*30, (float)Math.random()*30);
		}
		paths[1]=new Path();
		RectF rectf=new RectF(0,0,200,120);
		paths[1].addOval(rectf,Path.Direction.CCW);
		
		paths[2]=new Path();
		paths[2].addArc(rectf, 60, 180);
		mPaint=new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.CYAN);
		mPaint.setStrokeWidth(1);
	}
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		canvas.translate(40, 40);
		mPaint.setTextAlign(Paint.Align.RIGHT);
		mPaint.setTextSize(20);
		
		mPaint.setStyle(Paint.Style.STROKE);
		canvas.drawPath(paths[0], mPaint);
		mPaint.setStyle(Paint.Style.FILL);
		canvas.drawTextOnPath(DRAW_STR, paths[0], -8, 20, mPaint);
		canvas.translate(0, 60);
		
		//2
		mPaint.setStyle(Paint.Style.STROKE);
		canvas.drawPath(paths[1], mPaint);
		mPaint.setStyle(Paint.Style.FILL);
		canvas.drawTextOnPath(DRAW_STR, paths[1], -20, 20, mPaint);
		canvas.translate(0, 120);
		
		//3
		mPaint.setStyle(Paint.Style.STROKE);
		canvas.drawPath(paths[2], mPaint);
		mPaint.setStyle(Paint.Style.FILL);
		canvas.drawTextOnPath(DRAW_STR, paths[2], -10, 20, mPaint);
	 
	}

}
