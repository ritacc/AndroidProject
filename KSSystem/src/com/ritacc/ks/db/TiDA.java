package com.ritacc.ks.db;

import java.util.ArrayList;

import android.database.Cursor;

import entity.TI;

public class TiDA {
	MyDatabaseHelper dbHelper;
	public TiDA(MyDatabaseHelper _dbHelper)
	{
		dbHelper=_dbHelper;
	}
	
	public ArrayList<TI> GetAllTi()
	{
		Cursor cursor=dbHelper.getReadableDatabase().rawQuery(
				"select * from TI ",null);
		
		return CursorToList(cursor);
	}
	
	public ArrayList<TI> GetErrorTi()
	{
		
		Cursor cursor=dbHelper.getReadableDatabase().rawQuery(
				"select * from TI where EIssueResult !='' and Answer != EIssueResult order by ID asc",null);
		return CursorToList(cursor);
	}
	
	private ArrayList<TI> CursorToList(Cursor cursor)
	{
		ArrayList<TI> listTi=new ArrayList<TI>();
		while(cursor.moveToNext())
		{
			TI obj=new TI();
			obj.ID= cursor.getInt(0);
			obj.subjectType= cursor.getInt(1);
			obj.IssueSubject= cursor.getString(2).trim();
			obj.EIssueSubject= cursor.getString(3).trim();
			obj.IssueType_ID= cursor.getString(4).trim();
			obj.Answer= cursor.getString(5).trim();
			obj.IssueResult= cursor.getString(6).trim();
			obj.EIssueResult= cursor.getString(7).trim();
			obj.ImagePath= cursor.getString(8).trim();
			obj.RightNum=cursor.getInt(9);
			listTi.add(obj);
		}
		return listTi;
	}
	
	public boolean SaveResult(TI obj)
	{
		if(obj.EIssueResult.equals(""))
			return false;
		
		String sql="update TI set EIssueResult=?,RightNum=0 where id=?";
		dbHelper.getReadableDatabase().execSQL(sql, new String[]{
				obj.EIssueResult,
				obj.ID+""
		});
		return true;
	}
	
	public boolean SaveResultRightNum(TI obj)
	{
		if(obj.EIssueResult.equals(""))
			return false;
		
		String sql="update TI set RightNum=? where id=?";
		dbHelper.getReadableDatabase().execSQL(sql, new String[]{
				(obj.RightNum) +"",
				obj.ID+""
		});
		return true;
	}
	
	public boolean ClearResult(){ 
		String sql="update TI set EIssueResult=''";
		dbHelper.getReadableDatabase().execSQL(sql);
		return true;
	}
	
}
