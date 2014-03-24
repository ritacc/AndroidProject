package com.ritacc.ks;
 
import entity.TI;
import entity.TK;
 

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
 
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TK mtk;
	private TextView txtTitle=null;
	private ImageView imgItems=null;
	//checked box
	CheckBox cbA=null;
	CheckBox cbB=null;
	CheckBox cbC=null;
	CheckBox cbD=null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mtk=new TK();
		 
		initItems();		
		
		LoadItmes();
	}
	
	//INit
	private void initItems()
	{
		txtTitle=(TextView)findViewById(R.id.txtTitle);
		imgItems=(ImageView)findViewById(R.id.imgItems);
		
		cbA=(CheckBox)findViewById(R.id.cbA);
		cbB=(CheckBox)findViewById(R.id.cbB);
		cbC=(CheckBox)findViewById(R.id.cbC);
		cbD=(CheckBox)findViewById(R.id.cbD);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case  R.id.menu_next_ti:
				if(this.mtk.GetNextTi())
				{
					LoadItmes();
				}
			break;
			case R.id.menu_Prev_ti:
				if(this.mtk.GetPrevTi())
				{
					LoadItmes();
				}
				break;
			case R.id.menu_get_anser:
				Toast.makeText(MainActivity.this,mtk.CurrentTi.Answer, 8000).show();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//listTi.add(new TI(1,2,"动画1中有几种违法行为？","","1","B","<p>A.?一种违法行为<br />B.?二种违法行为<br />C.?三种违法行为<br /> D.?四种违法行为<br /><br /></p>","","uploadfiles_subject3_avi1.wmv"));
	public void LoadItmes()
	{
		TI obj=	mtk.CurrentTi;
		if(obj != null)
		{
			//this.txtTitle.setText(obj.IssueSubject);
			this.txtTitle.setText( obj.ID  + ".  " + obj.IssueSubject.toString());
			//显示img
			if(obj.ImagePath.trim().endsWith(".jpg"))
			{
				Log.d("ErrorMsg ","处理图片.");
				//imgItems.setVisibility(View.VISIBLE);
				imgItems.setImageResource(R.drawable.uploadfiles_subject3_img124);
			}
			else
			{
				Log.d("ErrorMsg ","隐藏图片.");
				//imgItems.setEnabled(enabled)
				//imgItems.setVisibility(View.INVISIBLE);
				
				imgItems.setImageResource(R.drawable.aqwmjs_image_02);
			}
//			Log.d("Answer", obj.Answer);
//			Log.d("IssueResult", obj.IssueResult);
//			Log.d("EIssueResult", obj.EIssueResult);
			 
			
			if(obj.IssueResult.length()> 2)
			{
				try
				{
					int Aindex= obj.IssueResult.indexOf("A.");
					int Bindex=obj.IssueResult.indexOf("B.");
					int Cindex=obj.IssueResult.indexOf("C.");
					int Dindex=obj.IssueResult.indexOf("D.");
					
			 		if(Aindex >= 0 && Bindex > 0 &&   Cindex > 0 &&    Dindex> 0  )
			 		{
						String strA=obj.IssueResult.substring(Aindex, Bindex);
						String strB=obj.IssueResult.substring(Bindex, Cindex);
						String strC=obj.IssueResult.substring(Cindex, Dindex);
						String strD=obj.IssueResult.substring(Dindex);
	 				
						cbA.setText(strA);
						cbB.setText(strB);
						cbC.setText(strC);
						cbD.setText(strD);
		 			}
				}
				catch(Exception ex)
				{
					Log.d("Exception indexof ",ex.getMessage());
				}
			}
			
		}
		
		//obj.i
		
	}

}
