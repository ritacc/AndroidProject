//package com.ritacc.ks.db;
//
//import java.util.ArrayList;
//
//import entity.TI;
//import entity.TIInit;
//import entity.TK;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
//
//
//public class SqlHelper extends SQLiteOpenHelper {
// 
//	private SQLiteDatabase _dbRead=null;
//	final String CRETATE_TABLE="create table TI(ID integer,subjectType,IssueSubject,EIssueSubject,IssueType_ID,Answer,IssueResult,EIssueResult,ImagePath);";
//	public SqlHelper(Context context, String name, CursorFactory factory,
//			int version) {
//		super(context, name, factory, version);
//		// TODO Auto-generated constructor stub
//		
//		_dbRead=this.getReadableDatabase();
//	}
//	
//	@Override
//	public void onCreate(SQLiteDatabase db) {
//		// TODO Auto-generated method stub
//		db.execSQL(CRETATE_TABLE);
//		TIInit mtk=new TIInit();
//		ArrayList<TI> listTi=mtk.getTK();
//		for(TI  obj : listTi)
//		{
//			db.execSQL("insert into TI values(?,?,?,?,?,?,?,?,?)"
//					,new String[]{obj.ID+""
//					,obj.subjectType+""
//					,obj.IssueSubject
//					,obj.EIssueSubject
//					,obj.IssueType_ID					
//					,obj.Answer
//					,obj.IssueResult
//					,obj.EIssueResult
//					,obj.ImagePath});
//		}
//	}
//
//	@Override
//	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		
//		
//	}
//	
//	public void Insert()
//	{
//		SQLiteDatabase _dbWrite=this.getWritableDatabase();
//		//_dbWrite.insert(table, nullColumnHack, values)
//	
//	}
//
//}
