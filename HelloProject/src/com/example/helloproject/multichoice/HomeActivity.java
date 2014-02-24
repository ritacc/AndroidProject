package com.example.helloproject.multichoice;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListActivity;
import com.example.helloproject.R;

public class HomeActivity extends SherlockListActivity{
	private List<ActivityInfo> activitiesInfo = Arrays.asList(
            new ActivityInfo(ArrayAdapterActivity.class, R.string.activity_title_array_adapter)
			);
	
//		@Override
//	    protected void onCreate(Bundle savedInstanceState) {
//	        super.onCreate(savedInstanceState);
//	        setContentView(R.layout.activity_main);
//	        String[] titles = getActivityTitles();
//	        setListAdapter(new ArrayAdapter<String>(
//	                this, android.R.layout.simple_list_item_1, android.R.id.text1, titles));
//	    }
//	    
//	    @Override
//	    protected void onListItemClick(ListView l, View v, int position, long id) {
//	        Class<? extends Activity> class_ = activitiesInfo.get(position).activityClass;
//	        Intent intent = new Intent(this, class_);
//	        startActivity(intent);
//	    }
}
