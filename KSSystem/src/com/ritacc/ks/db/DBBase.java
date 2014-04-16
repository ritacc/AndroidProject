package com.ritacc.ks.db;


public class DBBase {
	
	public  SqlHelper db=null;
	public DBBase()
	{	
		//CursorFactory factory=null;
		int version=1;
		final	String DBName="kssystem.db";
		db=new SqlHelper(null,DBName,null,version);	
	}
}
