package com.example.helloproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ImgDrawIndexActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_img_draw_index);
		
		InitPage();
	}
	private void InitPage()
	{
		// Basic View
		final Button btnBasicView=(Button)findViewById(R.id.btn_BasicView);
		btnBasicView.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(); // 建立Intent
				intent.setClass(ImgDrawIndexActivity.this, SurfaceViewActivity.class); // 设置活动
				startActivity(intent);
			}
		});
		//btnPathTest
		// Basic View
		final Button btnPathTest=(Button)findViewById(R.id.btnPathTest);
		btnPathTest.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(); // 建立Intent
				intent.setClass(ImgDrawIndexActivity.this, ImgDrawPathTestActivity.class); // 设置活动
				startActivity(intent);
			}
		});
		//btnTextView
		final Button btnTextView=(Button)findViewById(R.id.btnTextView);
		btnTextView.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(); // 建立Intent
				intent.setClass(ImgDrawIndexActivity.this, ImgDrawTextActivity.class); // 设置活动
				startActivity(intent);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.img_draw_index, menu);
		return true;
	}

}
