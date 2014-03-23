package com.example.helloproject;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.example.helloproject.multichoice.MultichoiceIndexActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SqlLiteIndexActivity  extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sql_lite_index);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		InitPage();
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		//getMenuInflater().inflate(R.menu.sql_lite_index, menu);
//		return true;
//	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.my_action_mode, menu);
        return true;
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            Intent parentActivityIntent = new Intent(this, MultichoiceIndexActivity.class);
            parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(parentActivityIntent);
            finish();
            return true;
        }
        return false;
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
