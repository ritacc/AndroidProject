package com.example.helloproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SysActionActivity extends Activity {
	
	final int PICK_CONTACT=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sys_action);
		
//		final Button btn=(Button)findViewById(R.id.btnSelect);
//		btn.setOnClickListener(new OnClickListener()
//		{
//			@Override
//			public void onClick(View v) {
//				Intent intent=new Intent();
//				intent.setAction(Intent.ACTION_GET_CONTENT);
//				intent.setType("vnd.android.cursor.item/phone");
//				startActivityForResult(intent,PICK_CONTACT);
//			}
//			
//		});
	}
	@Override
	public void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		switch(requestCode)
		{
			case(PICK_CONTACT):
				if(resultCode== Activity.RESULT_OK)
				{
					
				}
				break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.sys_action, menu);
		return true;
	}

}
