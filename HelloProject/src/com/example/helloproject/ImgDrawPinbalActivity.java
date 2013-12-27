package com.example.helloproject;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;

public class ImgDrawPinbalActivity extends Activity {

	private int tableWidth;
	private int tableHeight;
	private int racketY;
	//定义球拍的高度和宽度
	private final int RACKET_HEIGHT=20;
	private final int RACKET_WIDTH=70;
	//小球的大小
	private final int BALL_SIZE=12;
	//小球纵向的运行速度
	private int ySpeed=10;
	//控制小球的运行方向
	Random rand=new Random();
	private double xyRate=rand.nextDouble()-0.5;
	private int xSpeed=(int)(ySpeed * xyRate)*2;
	private int ballX=rand.nextInt(200)+20;
	private int ballY=rand.nextInt(10)+20; 
	//racketX 球拍的水平位置
	private int racketX=rand.nextInt(200);
	private boolean isLose=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//全屏显示
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
				, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		final ImgDrawPinbalView gameView=new ImgDrawPinbalView(this);
		setContentView(gameView);
		//获取窗口管理
		
		WindowManager windowManager=getWindowManager();
		Display display=windowManager.getDefaultDisplay();
		DisplayMetrics metrics=new DisplayMetrics();
		display.getMetrics(metrics);
		//获取屏幕宽和高
		this.tableHeight=metrics.heightPixels;
		this.tableWidth=metrics.widthPixels;
		racketY=tableHeight-80;
		final Handler handler=new Handler()
		{
			public void handleMessage(Message msg)
			{
				if(msg.what==0x123)
				{
					gameView.invalidate();
				}
			}
		};
		gameView.setOnKeyListener(new OnKeyListener(){

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				switch(event.getKeyCode())
				{
				case KeyEvent.KEYCODE_A:
					if(racketX> 0) racketX-=10;
					break;
				case KeyEvent.KEYCODE_D:
					if(racketX < tableWidth-RACKET_WIDTH) racketX+=10;
					break;
				}
				gameView.invalidate();
				return true;
			}
		});
		
		final Timer timer=new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				//如果小球碰到左边框
				if(ballX<=10 || ballX>= tableWidth-BALL_SIZE)
					xSpeed=-xSpeed;
				//超出了球拍位置，且横向不在球拍范围之类，游戏结束。
				if(ballY>= racketY-BALL_SIZE 
						&& (ballX< racketX || ballX> racketX + RACKET_WIDTH))
				{
					timer.cancel();
					isLose=true;
				}
				else if(ballY<=0
						|| (ballY>= racketY - BALL_SIZE
						&& ballX> racketX && ballX<= racketX+RACKET_WIDTH))
				{
					
					ySpeed=-ySpeed;
				}
				ballY+=ySpeed;
				ballX+= xSpeed;
				handler.sendEmptyMessage(0x123);
			}
		}, 0,100);
		//setContentView(R.layout.activity_img_draw_pinbal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.img_draw_pinbal, menu);
		return true;
	}
	
	public class ImgDrawPinbalView extends View {
		Paint paint=new Paint();
		public ImgDrawPinbalView(Context context)
		{
			super(context);
			setFocusable(true);
		}
		
		@Override
		protected void onDraw(Canvas canvas)
		{
			paint.setStyle(Paint.Style.FILL);
			paint.setAntiAlias(true);
			if(isLose)
			{
				paint.setColor(Color.RED);
				paint.setTextScaleX(40);
				canvas.drawText("游戏结束。", 50,200, paint);
			}
			else
			{
				//绘制小球
				paint.setColor(Color.rgb(240, 240, 80));
				canvas.drawCircle(ballX, ballY, BALL_SIZE, paint);
				//设置颜色并绘制球拍
				paint.setColor(Color.rgb(80, 80, 200));
				canvas.drawRect(racketX, racketY,racketX+RACKET_WIDTH,
						racketY+RACKET_HEIGHT,paint);
				
			}
			super.onDraw(canvas);
		}
	}

}
