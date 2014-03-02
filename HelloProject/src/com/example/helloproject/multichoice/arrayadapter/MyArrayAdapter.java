package com.example.helloproject.multichoice.arrayadapter;

import java.util.ArrayList;
import java.util.Set;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.example.helloproject.R;
import com.manuelpeinado.multichoiceadapter.MultiChoiceArrayAdapter;
 


@SuppressLint("ViewConstructor")
public class MyArrayAdapter extends MultiChoiceArrayAdapter<String> {

	protected static final String TAG = MyArrayAdapter.class.getSimpleName();

	public MyArrayAdapter(Bundle savedInstanceState, Context context,
			ArrayList<String> items) {
		super(savedInstanceState, context,
				R.layout.mca__simple_list_item_checkable_1, android.R.id.text1,
				items);
	}

	@Override
	public boolean onCreateActionMode(ActionMode mode, Menu menu) {
		MenuInflater inflater = mode.getMenuInflater();
		inflater.inflate(R.menu.my_action_mode, menu);
		return true;
	}

	@Override
	public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
		if (item.getItemId() == R.id.menu_share) {
			Toast.makeText(getContext(), "Share", Toast.LENGTH_SHORT).show();
			return true;
		}
		if (item.getItemId() == R.id.menu_discard) {
			discardSelectedItems();
			return true;
		}
		return false;
	}

	private void discardSelectedItems() {
		Set<Long> selection = getCheckedItems();
		String[] items = new String[selection.size()];
		int i = 0;
		for (long position : selection) {
			items[i++] = getItem((int) position);
		}
		for (String item : items) {
			remove(item);
		}
		finishActionMode();
	}

	@Override
	public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
		return false;
	}

	@Override
	protected View getViewImpl(int position, View convertView, ViewGroup parent) {
		View view = super.getViewImpl(position, convertView, parent);
		view.setBackgroundResource(R.drawable.custom_list_item_background);
		return view;
	}
}

