package com.ritacc.cardadmin.db;

import DB.SqlHelper;

public class DBBase {
	
	public  SqlHelper db=null;
	public DBBase()
	{	
		//CursorFactory factory=null;
		int version=1;
		final	String DBName="ritaccCard.db";
		db=new SqlHelper(null,DBName,null,version);	
	}
}
