package DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelper extends SQLiteOpenHelper {
 
	private SQLiteDatabase _dbRead=null;
	final String CRETATE_TABLE="create table dic(ID integer primary key autoincrement,word,detail);";
	public SqlHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		
		_dbRead=this.getReadableDatabase();
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CRETATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}
	
	public void Insert()
	{
		SQLiteDatabase _dbWrite=this.getWritableDatabase();
		//_dbWrite.insert(table, nullColumnHack, values)
	
	}

}
