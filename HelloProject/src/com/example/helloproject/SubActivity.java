package com.example.helloproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class SubActivity extends Activity {
	public static final int RED_MENU_ID = Menu.FIRST;
	public static final int GREEN_MENU_ID = Menu.FIRST + 1;
	public static final int BLUE_MENU_ID = Menu.FIRST + 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub, menu);
		menu.add(0, RED_MENU_ID, 0, "Red");
		menu.add(0, GREEN_MENU_ID, 0, "green");
		menu.add(0, BLUE_MENU_ID, 0, "blue");
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case RED_MENU_ID:
	
			return true;
		case GREEN_MENU_ID:
	
			return true;
		case BLUE_MENU_ID:
	
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
