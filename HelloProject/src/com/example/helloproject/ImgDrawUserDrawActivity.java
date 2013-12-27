package com.example.helloproject;

import com.example.helloproject.ImgDraw.ImgDrawUserDrawView;
 
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;

public class ImgDrawUserDrawActivity extends Activity {
	ImgDrawUserDrawView dv=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_img_draw_user_draw);
		dv=new ImgDrawUserDrawView(this);
		setContentView(dv);
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
			case R.id.red:
				dv.paint.setColor(Color.RED);
				item.setCheckable(true);
				break;
			case R.id.green:
				dv.paint.setColor(Color.GREEN);
				item.setCheckable(true);
				break;
			case R.id.blue:
				dv.paint.setColor(Color.BLUE);
				item.setCheckable(true);
				break;
			case R.id.width_1:
				dv.paint.setStrokeWidth(1);
				break;
			case R.id.width_3:
				dv.paint.setStrokeWidth(3);
				break;
			case R.id.width_5:
				dv.paint.setStrokeWidth(4);
				break;
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


