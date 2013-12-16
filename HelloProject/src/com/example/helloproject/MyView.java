package com.example.helloproject;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
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
		canvas.drawCircle(40, 40, 30, _paint);
		canvas.drawRect(10, 80,70,140,_paint);
		canvas.drawRect(10, 80,70,140,_paint);
		 
	}
	
}
