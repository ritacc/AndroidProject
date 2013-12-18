package com.example.helloproject;

import com.example.helloproject.ImgDraw.ImgDrawTextView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ImgDrawTextActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_img_draw_text);
		setContentView(new ImgDrawTextView(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.img_draw_text, menu);
		return true;
	}

}
