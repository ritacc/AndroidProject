package com.example.helloproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DB.MyDatabaseHelper;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class SqlLiteDictActivity extends Activity {

	MyDatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sql_lite_dict);
		dbHelper= new MyDatabaseHelper(this,"myDict.db3",1);
		InitPage();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.sql_lite_dict, menu);
		return true;
	}
	
	private void InitPage()
	{
		
		final Button btn_Insert=(Button)findViewById(R.id.btn_Insert);
		btn_Insert.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				EditText txtWord=(EditText)findViewById(R.id.txtWorld);
				String str=txtWord.getText().toString();
				//Clear
				txtWord.setText("");
				
				InsertData(dbHelper.getReadableDatabase(),str,"");				
				Toast.makeText(SqlLiteDictActivity.this, "Ìí¼Ó³É¹¦¡£", 8000).show();
			}
		});	
		
		final Button btnRead=(Button)findViewById(R.id.btnRead);
		btnRead.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
		
				Cursor cursor=dbHelper.getReadableDatabase().rawQuery(
						"select * from dict ",null);
				//Intent intent=new Intent(SqlLiteDictActivity.this,ResultActivity.class);
				
				//converCursorToList(cursor);
				ListView lvList=(ListView)findViewById(R.id.lvList);
				SimpleAdapter listAdap=new SimpleAdapter(SqlLiteDictActivity.this
						,converCursorToList(cursor)
						,R.layout.activity_sql_lite_dict_items
						,new String[]{"title","info"},
						new int[]{R.id.title,R.id.info});
				
				//lvList.setAdapter(new ArrayAdapter<String>(this, null,converCursorToList(cursor));
				//lvList.setAdapter(adapter);
				//setContentView(lvList);
				lvList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
				lvList.setAdapter(listAdap);
				lvList.setOnItemClickListener(new OnItemClickListener(){

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						Toast.makeText(SqlLiteDictActivity.this, "1", 1).show();
					}
				});			 
			}
		});
	}
	
	private List<Map<String, Object>> converCursorToList(Cursor cursor)
	{
		List<Map<String, Object>> result=new ArrayList<Map<String, Object>>();
		while(cursor.moveToNext())
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title",cursor.getString(1));
			map.put("info", cursor.getString(2));
			result.add(map);
			/*Map<String,String> map=new HashMap<String,String>();
			map.put("word", cursor.getString(1));
			map.put("detail", cursor.getString(2));
			result.add(map);*/
		}
		return result;
	}
	
	private void InsertData(SQLiteDatabase db,String word,String detail)
	{
		db.execSQL("insert into dict values(null,?,?)",new String[]{word,detail});
	}
	
	public void onDestroy()
	{
		super.onDestroy();
		if(dbHelper != null)
		{
			dbHelper.close();
		}
	}

}
