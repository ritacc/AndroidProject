package com.example.helloproject.multichoice;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.example.helloproject.R;



public class ArrayAdapterActivity extends SherlockActivity implements OnItemClickListener {
	private MyArrayAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		rebuildList(savedInstanceState);
	}
	
	private ListView getListView() {
		return (ListView) findViewById(android.R.id.list);
	}
	
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
		Toast.makeText(this, "Item click: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				Intent parentActivityIntent = new Intent(this, HomeActivity.class);
				parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(parentActivityIntent);
				finish();
				return true;
			case R.id.menu_select_all:
				selectAll();
				return true;
			case R.id.menu_reset_list:
				rebuildList(null);
			return true;
		}
		return false;
	}
	
	private void selectAll() {
		for (int i = 0; i < adapter.getCount(); ++i) {
			adapter.setItemChecked(i, true);
		}
	}
	
	private void rebuildList(Bundle savedInstanceState) {
		String[] itemArray = getResources().getStringArray(R.array.names);
		ArrayList<String> items = new ArrayList<String>(Arrays.asList(itemArray));
		adapter = new MyArrayAdapter(savedInstanceState, this, items);
		adapter.setOnItemClickListener(this);
		adapter.setAdapterView(getListView());
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		adapter.save(outState);
	}
	}
