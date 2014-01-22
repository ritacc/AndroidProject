package com.example.helloproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SqlLiteIndexActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sql_lite_index);
		InitPage();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sql_lite_index, menu);
		return true;
	}
	private void InitPage()
	{ 
		final Button btnDitc=(Button)findViewById(R.id.btnDitc);
		btnDitc.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(); // 建立Intent
				intent.setClass(SqlLiteIndexActivity.this, SqlLiteDictActivity.class); //生词本
				startActivity(intent);
			}
		});
		
		
	}

}
