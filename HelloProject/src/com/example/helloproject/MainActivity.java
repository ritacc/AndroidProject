package com.example.helloproject;



import com.example.helloproject.multichoice.MultichoiceIndexActivity;
import com.example.helloproject.multichoice.arrayadapter.TwoLinesArrayAdapterActivity;
import com.ritacc.cardadmin.CardAdminIndexActivity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	btnDialog_OnClickListener btnDialog_Click=new btnDialog_OnClickListener(); 
	 
	
	public static final int Red_MENU_ID = Menu.FIRST;
	public static final int GREEN_MENU_ID = Menu.FIRST+1;
	public static final int BLUE_MENU_ID = Menu.FIRST+2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//Context c=(Context)this;  
		
		InitPage();
	}
	final static String strAction="net.ritacc.android.action.SUB_ACTION";
	final static String strCategory="net.ritacc.android.category.SUB_CATEGORY";
	private void InitPage()
	{
		//Dialog
		final Button btnDialog=(Button) findViewById(R.id.btn_Dialog);
		btnDialog.setOnClickListener(btnDialog_Click);
		
		//Other
		final Button btnOther=(Button)findViewById(R.id.btnSqlLite);
		btnOther.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				
//				ComponentName comp=new ComponentName(MainActivity.this, SubActivity.class);
//				Intent intent=new Intent();
//				intent.setComponent(comp);
//				startActivity(intent);
				
//				Intent intent=new Intent();
//				intent.setAction(MainActivity.strAction);
//				intent.addCategory(MainActivity.strCategory);
//				startActivity(intent);//SqlLiteIndexActivity
				Intent intent = new Intent(); // 建立Intent
				intent.setClass(MainActivity.this, SqlLiteIndexActivity.class); // 设置活动
				startActivity(intent);
			}
		});
		
		//ImgDraw
		final Button btnImgDrawIndex=(Button)findViewById(R.id.ImgDrawIndex);
		btnImgDrawIndex.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(); // 建立Intent
				intent.setClass(MainActivity.this, ImgDrawIndexActivity.class); // 设置活动
				startActivity(intent);
			}
		});
		//home
		final Button btnHome=(Button)findViewById(R.id.btnHome);
		btnHome.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				 /*Intent intent=new Intent();
				 intent.setAction(Intent.ACTION_MAIN);
				 intent.addCategory(Intent.CATEGORY_HOME);
				 startActivity(intent);*/
				
				Intent intent = new Intent(); // 建立Intent
				intent.setClass(MainActivity.this, MultichoiceIndexActivity.class); // 设置活动
				startActivity(intent);
			}
		});
		 
		//btnCardAdmin
		final Button btnCardAdmin=(Button)findViewById(R.id.btnCardAdmin);
		btnCardAdmin.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				//Call
				Intent intent = new Intent(); // 建立Intent
				//intent.setClass(MainActivity.this, CardAdminIndexActivity.class);  
				startActivity(intent);
			}
		});
		 
	}
	
	class btnDialog_OnClickListener implements OnClickListener
	{
		public void onClick(View v)
		{
			/*	 跳转到其它 activity */
		    Intent intent = new Intent(); // 建立Intent
			intent.setClass(MainActivity.this, DialogExampleActivity.class); // 设置活动
			startActivity(intent);
			//finish();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add(0,Red_MENU_ID,0,"RED");
		menu.add(0,GREEN_MENU_ID,0,"GREEN");
		menu.add(0,BLUE_MENU_ID,0,"Blue");
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
		case Red_MENU_ID:
			 
			return true;
		case GREEN_MENU_ID:
			 
			return true;
		case BLUE_MENU_ID:
			 
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

}
