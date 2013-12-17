package com.example.helloproject.ImgDraw;

import com.example.helloproject.R;

import android.R.string;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

@SuppressLint("DrawAllocation")
public class MyView extends View {

	public MyView(Context context)
	{
		super(context);
	}
	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		Paint _paint=new Paint();
		_paint.setAntiAlias(true);
		_paint.setColor(Color.BLUE);
		_paint.setStyle(Paint.Style.STROKE);
		_paint.setStrokeWidth(3);
		//圆形
		canvas.drawCircle(40, 40, 30, _paint);
		//正文形
		canvas.drawRect(10, 80,70,140,_paint);
		//柜形
		canvas.drawRect(10, 150,70,190,_paint);
		
		//绘制圆角矩形
		RectF rel=new RectF(10,200,70,230);
		canvas.drawRoundRect(rel, 15, 15, _paint);
		//绘制椭圆
		RectF rell=new RectF(10,240,70,270);
		canvas.drawOval(rell, _paint);
		
		//定义一个Path 对象，封闭成一个三角形
		Path mPath=new Path();
		mPath.moveTo(10, 340);
		mPath.lineTo(70, 340);
		mPath.lineTo(40, 290);
		mPath.close();
		canvas.drawPath(mPath, _paint);
		
		//定义一个Path 对锡，封闭成一个五角形
		Path path2= new Path();
		path2.moveTo(26,360);
		path2.lineTo(54,360);
		path2.lineTo(70,392);
		path2.lineTo(40,420);
		path2.lineTo(10,392);
		path2.close();		
		canvas.drawPath(path2, _paint);
		
		//---------------设置填充风格后绘制---------------
		_paint.setStyle(Paint.Style.FILL);
		_paint.setColor(Color.GREEN);
		canvas.drawCircle(120,40, 30, _paint);
		//正方形
		canvas.drawRect(90, 80,150,140,_paint);
		
		
		//-----------------设置渐变器后绘制-----------------
		Shader mShader=new LinearGradient(0,0,40,60
				,new int[]{Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW}
				,null,Shader.TileMode.REPEAT);
		_paint.setShader(mShader);
		//_paint.setShadowLayer(45, 10, 10, Color.GRAY);
		
		canvas.drawCircle(200,40, 30, _paint);
		//正方形
		canvas.drawRect(170, 80,230,140,_paint);
		
		
		//---------------设置字符大小后绘制------------
		_paint.setTextSize(24);
		_paint.setShader(null);
		canvas.drawText(getResources().getString(R.string.title_cirecle), 240, 50, _paint);
		canvas.drawText(getResources().getString(R.string.title_rect), 240, 120, _paint);
		
		
	}
	
}
