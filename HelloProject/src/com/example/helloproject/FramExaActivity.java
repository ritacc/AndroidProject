package com.example.helloproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FramExaActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fram_exa);
		
		FragmentManager fm = getSupportFragmentManager();  
		addListener(R.id.firstButton, fm.findFragmentById(R.id.firstFragment));  
		addListener(R.id.secondButton, fm.findFragmentById(R.id.secondFragment)); 
	}

	private void addListener(int buttonID, final Fragment fragment) {
        final Button button = (Button)findViewById(buttonID);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                if (fragment.isHidden()) {
                    ft.show(fragment);
                    button.setText("Òþ²Ø");
                } else {
                    ft.hide(fragment);
                    button.setText("ÏÔÊ¾");
                }
                ft.commit();
            }
        });
   }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.fram_exa, menu);
		return true;
	}

}
