package com.ritacc.cardadmin.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*
 * card_id
 * ��Ƭ����
 * �������ƣ� cardName
 * ���� �� 	 cardNo
 * �������ͣ����������ÿ�  cardType
 * �Ƿ�̶����� 0����1 ���ǡ� 	
 * �̶�������
 * �ʵ�����
 * ����̶����ڣ�  �ʵ��������� 
 * 
 * cardRecord_ID
 * card_id
 * �����¼
 * ��
 * �·ݣ�
 * �ʵ�����
 * ��󻹿�����
 * �ʵ����
 * ��������
 * ������ 
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