package entity;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

 
import com.ritacc.ks.db.MyDatabaseHelper;
import com.ritacc.ks.db.TiDA;

 

public class TK {
	
		private ArrayList<TI> listTi=new ArrayList<TI>();
		 
		TiDA mda;
		public TK(Context context)
		{
			mda=new TiDA(new MyDatabaseHelper(context,"kssystem.db",1));
			listTi=mda.GetAllTi();
			TiCount=listTi.size();
			if(CurrentIndex> 0 && listTi.size() > CurrentIndex)
			{
				CurrentTi=(TI)listTi.get(CurrentIndex);
			}
		}
		/**
		 Error ,Normal
		 */
		public String TMode="Normal";
		public boolean ErrorRedo()
		{
			listTi.clear();
			listTi=mda.GetErrorTi();
			TiCount=listTi.size();
			if(TiCount == 0){
				return false;
			}

			TMode="Error";
			CurrentIndex=0;
			CurrentTi=(TI)listTi.get(CurrentIndex);
			return true;
		}
		
		/***
		 * ����ѡ������
		 * @return
		 */
		private boolean SaveTiResult()
		{
			if(CurrentTi == null)
				return false;
			return	mda.SaveResult(CurrentTi);		
		}
		
		public boolean ClearResult()
		{ 
			if(	mda.ClearResult())
			{
				for(TI obj : listTi)
				{
					obj.EIssueResult="";
				}
				return true;
			}
			return false;
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
			SaveTiResult();
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
			SaveTiResult();
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

 
