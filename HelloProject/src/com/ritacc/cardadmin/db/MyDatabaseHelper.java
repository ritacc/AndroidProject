package com.ritacc.cardadmin.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*
 * card_id
 * 卡片管理
 * 银行名称： cardName
 * 卡号 ： 	 cardNo
 * 还款类型：房贷、信用卡  cardType
 * 是否固定还款 0：否、1 ：是。 	
 * 固定还款金额
 * 帐单日期
 * 还款：固定日期，  帐单后天数。 
 * 
 * cardRecord_ID
 * card_id
 * 还款记录
 * 年
 * 月份：
 * 帐单日期
 * 最后还款日期
 * 帐单金额
 * 还款日期
 * 还款金额 
 * */
public class MyDatabaseHelper extends SQLiteOpenHelper {
	final String CRETATE_TABLE_Card="create table card("
					+"card_id integer primary key autoincrement,"
					+"cardName varchar(20)," 
					+"cardNo   varchar(20)," 
					+"cardType varchar(10)," 
					+"ISFixedrepayment integer,"
					+"fixedAMT	float,"
					+"RepaymentType varchar(1)" 
					+"RepaymentNum	integer"
					+");";
	final String CRETATE_TABLE_Record="create table cardRecord(" +
			"cardRecord_ID integer primary key autoincrement,"+
			"card_id integer," +
			"year	integer," +
			"month  integer," +
			");";
	public MyDatabaseHelper(Context context, String name,
			int version) {
		super(context, name, null, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CRETATE_TABLE_Card);
		db.execSQL(CRETATE_TABLE_Record);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}
}