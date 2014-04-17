package com.ritacc.ks.db;

import java.util.ArrayList;

import entity.TI;
import entity.TIInit;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDatabaseHelper extends SQLiteOpenHelper {
	final String CRETATE_TABLE="create table TI(ID integer,subjectType integer,IssueSubject NVARCHAR(500),EIssueSubject NVARCHAR(50),IssueType_ID NVARCHAR(10),Answer NVARCHAR(20),IssueResult NVARCHAR(100),EIssueResult NVARCHAR(800),ImagePath NVARCHAR(200));";
	
	public MyDatabaseHelper(Context context, String name,
			int version) {
		super(context, name, null, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.d("msg", "CRETATE_TABLE");
		
		db.execSQL(CRETATE_TABLE);
		TIInit mtk=new TIInit();
		ArrayList<TI> listTi=mtk.getTK();
		Log.d("msg", "mtk.getTK()");
		for(TI  obj : listTi)
		{
			db.execSQL("insert into TI (ID,subjectType,IssueSubject,EIssueSubject,IssueType_ID,Answer,IssueResult,EIssueResult,ImagePath) values(?,?,?,?,?,?,?,?,?)"
					,new String[]{obj.ID+""
					,obj.subjectType+""
					,obj.IssueSubject
					,obj.EIssueSubject
					,obj.IssueType_ID
					,obj.Answer
					,obj.IssueResult
					,obj.EIssueResult
					,obj.ImagePath});
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}
}
