package com.example.helloproject;

import com.example.helloproject.ImgDraw.ImgDrawPathTestView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ImgDrawPathTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_img_draw_path_test);
		setContentView(new ImgDrawPathTestView(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.img_draw_path_test, menu);
		return true;
	}

}
