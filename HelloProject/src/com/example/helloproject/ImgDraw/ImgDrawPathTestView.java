package com.example.helloproject.ImgDraw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;
import android.view.View;

public class ImgDrawPathTestView extends View{
	float phase;
	PathEffect[] effects=new PathEffect[7];
	int[] colors;
	private Paint mPaint;
	Path mPath;
	
	public ImgDrawPathTestView(Context context) {
		super(context);
		mPaint=new Paint();
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth(4);
		//创建并初始化Path
		mPath=new Path();
		mPath.moveTo(0, 0);
		for(int i=0;i< 15;i++)
		{
			mPath.lineTo(i*20, (float)Math.random()*60);
		}
		//Init Colors
		colors=new int[]{Color.BLACK,Color.BLUE,Color.CYAN,
				Color.GREEN,Color.MAGENTA,Color.RED,Color.YELLOW};
		
	}
	
	public ImgDrawPathTestView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		//下面初使化7种路径效果
		effects[0]=null;
		effects[1]=new CornerPathEffect(10);
		effects[2]=new DiscretePathEffect(3.0f,5.0f);
		effects[3]=new DashPathEffect(new float[]{20,10,5,10},phase);
		//初使化PathDashPathEffect
		Path p=new Path();
		p.addRect(0, 0,8,8,Path.Direction.CCW);
		effects[4]=new PathDashPathEffect(p,12,phase,PathDashPathEffect.Style.ROTATE);
		effects[5]=new ComposePathEffect(effects[2],effects[4]);
		effects[6]=new SumPathEffect(effects[4],effects[3]);
		
		canvas.translate(8, 8);
		for(int i=0;i<effects.length;i++)
		{
			mPaint.setPathEffect(effects[i]);
			mPaint.setColor(colors[i]);
			canvas.drawPath(mPath, mPaint);
			canvas.translate(0, 60);		
		}
		phase+=1;
		invalidate();
	}
}
