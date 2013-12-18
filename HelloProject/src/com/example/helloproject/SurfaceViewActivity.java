package com.example.helloproject;

import com.example.helloproject.ImgDraw.MyView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SurfaceViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_surface_view);
		setContentView(new MyView(this));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.surface_view, menu);
		return true;
	}

}
