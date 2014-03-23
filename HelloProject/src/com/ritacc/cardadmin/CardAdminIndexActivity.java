package com.ritacc.cardadmin;

import com.example.helloproject.R;
import com.example.helloproject.R.layout;
import com.example.helloproject.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CardAdminIndexActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_admin_index);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		 
		return true;
	}

}
