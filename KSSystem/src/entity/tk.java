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
		//��ȡ��
		public Boolean GetTI()
		{
			Boolean result=true;
			return result;
		}
		
		//��ǰ���
		private int CurrentIndex=20;
		
		
		public String ErrorMsg="";
		//������
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
				ErrorMsg="�Ѿ������һ������";
				return false;
			}
			CurrentTi=(TI)listTi.get(iTemp);
			CurrentIndex=iTemp;
			return true;
		}
		
		//��ȡ��һ��
		public boolean GetPrevTi()
		{
			int iTemp=this.CurrentIndex-1;
			if(iTemp<0)
			{
				ErrorMsg="�Ѿ���һ������";
				return false;
			}
			
			CurrentTi=(TI)listTi.get(iTemp);
			CurrentIndex=iTemp;
			return true;
		}
		
		
}

 
