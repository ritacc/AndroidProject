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
		ArrayList<TI> listTi=new ArrayList<TI>();
		Cursor cursor=dbHelper.getReadableDatabase().rawQuery(
				"select * from TI ",null);
		
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
			listTi.add(obj);
		}
		return listTi;
	}
	
	public ArrayList<TI> GetErrorTi()
	{
		ArrayList<TI> listTi=new ArrayList<TI>();
		Cursor cursor=dbHelper.getReadableDatabase().rawQuery(
				"select * from TI where EIssueResult !='' and Answer != EIssueResult",null);
		
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
			listTi.add(obj);
		}
		return listTi;
	}
	
	public boolean SaveResult(TI obj)
	{
		if(obj.EIssueResult.equals(""))
			return false;
		
		String sql="update TI set EIssueResult=? where id=?";
		dbHelper.getReadableDatabase().execSQL(sql, new String[]{
				obj.EIssueResult,
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
