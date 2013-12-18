package com.example.helloproject;

import android.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class ImgDrawUserDrawActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_img_draw_user_draw);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.img_draw_user_draw, menu);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		
		switch(item.getItemId())
		{
//		case R.id.c:
//			 
//			return true;
//		case GREEN_MENU_ID:
//			 
//			return true;
//		case BLUE_MENU_ID:
//			 
//			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
