package entity;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

 
import com.ritacc.ks.db.MyDatabaseHelper;

 

public class TK {
	
		private ArrayList<TI> listTi=new ArrayList<TI>();
		MyDatabaseHelper dbHelper;
		
		public TK(Context context)
		{
			dbHelper= new MyDatabaseHelper(context,"kssystem.db",1);
			Cursor cursor=dbHelper.getReadableDatabase().rawQuery(
					"select * from TI ",null);
			
			Log.d("count=", cursor.getCount() +"");
			
			while(cursor.moveToNext())
			{
				TI obj=new TI();
				obj.ID= cursor.getInt(0);
				obj.subjectType= cursor.getInt(1);
				obj.IssueSubject= cursor.getString(2);
				obj.EIssueSubject= cursor.getString(3);
				obj.IssueType_ID= cursor.getString(4);
				obj.Answer= cursor.getString(5);
				obj.IssueResult= cursor.getString(6);
				obj.EIssueResult= cursor.getString(7);
				obj.ImagePath= cursor.getString(8);
				listTi.add(obj);
			}
			
			TiCount=listTi.size();
			if(CurrentIndex> 0 && listTi.size() > CurrentIndex)
			{
				CurrentTi=(TI)listTi.get(CurrentIndex);
			}
		}
		//获取。
		public Boolean GetTI()
		{
			Boolean result=true;
			return result;
		}
		
		//当前序号
		private int CurrentIndex=20;
		
		
		public String ErrorMsg="";
		//题数量
		public int TiCount=0;
		
		public TI CurrentTi;
		
		public boolean setCurrentIndex(int mIndex)
		{
			
			if(mIndex> 0 && listTi.size() > mIndex)
			{
				CurrentIndex=mIndex;
				CurrentTi=(TI)listTi.get(mIndex);
				return true;
			}
			return false;
		}
		public int getCurrentIndex()
		{
			return CurrentIndex;
		}
		
		public boolean GetNextTi()
		{
			int iTemp=this.CurrentIndex+1;
			if(iTemp>=TiCount)
			{
				ErrorMsg="已经是最后一题啦。";
				return false;
			}
			CurrentTi=(TI)listTi.get(iTemp);
			CurrentIndex=iTemp;
			return true;
		}
		
		//获取上一题
		public boolean GetPrevTi()
		{
			int iTemp=this.CurrentIndex-1;
			if(iTemp<0)
			{
				ErrorMsg="已经第一题啦。";
				return false;
			}
			
			CurrentTi=(TI)listTi.get(iTemp);
			CurrentIndex=iTemp;
			return true;
		}
		
		
}

 
