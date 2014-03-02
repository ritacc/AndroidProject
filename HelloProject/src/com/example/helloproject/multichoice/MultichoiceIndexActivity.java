package com.example.helloproject.multichoice;

import java.util.Arrays;
import java.util.List;

import com.actionbarsherlock.app.SherlockListActivity;
import com.example.helloproject.R;
import com.example.helloproject.multichoice.arrayadapter.ArrayAdapterActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MultichoiceIndexActivity extends SherlockListActivity {
	
	 private List<ActivityInfo> activitiesInfo = Arrays.asList(
	            new ActivityInfo(ArrayAdapterActivity.class, R.string.ArrayAdapterActivity)
	            );
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multichoice_index);
		
		 String[] titles = getActivityTitles();
	
		setListAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, titles));
	}

	 @Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        Class<? extends Activity> class_ = activitiesInfo.get(position).activityClass;
	        Intent intent = new Intent(this, class_);
	        startActivity(intent);
	    }
	
	private String[] getActivityTitles() {
        String[] result = new String[activitiesInfo.size()];
        int i = 0;
        for (ActivityInfo info : activitiesInfo) {
            result[i++] = getString(info.titleResourceId);
        }
        return result;
    }

}
