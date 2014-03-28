package com.ritacc.ks;
 
import entity.TI;
import entity.TK; 
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
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
	
	RadioButton rdiClear2=null;
	RadioButton rdiA=null;
	RadioButton rdiB=null;
	RadioButton rdiC=null;
	RadioButton rdiD=null;
	
	RadioButton rdiClear1=null;	
	RadioButton rdiRight=null;
	RadioButton rdiError=null;
	
	RelativeLayout RLayCB=null;
	RelativeLayout RLayBoolean=null;
	RelativeLayout RLayRDI=null;
	RadioGroup	rg1=null;
	RadioGroup	rg2=null;
	//INit
	private void initItems()
	{
		txtTitle=(TextView)findViewById(R.id.txtTitle);
		imgItems=(ImageView)findViewById(R.id.imgItems);
		
		cbA=(CheckBox)findViewById(R.id.cbA);
		cbB=(CheckBox)findViewById(R.id.cbB);
		cbC=(CheckBox)findViewById(R.id.cbC);
		cbD=(CheckBox)findViewById(R.id.cbD);
		
		cbA.setOnCheckedChangeListener(cbClick);
		cbB.setOnCheckedChangeListener(cbClick);
		cbC.setOnCheckedChangeListener(cbClick);
		cbD.setOnCheckedChangeListener(cbClick);
		
		rdiA=(RadioButton)findViewById(R.id.rdiA);
		rdiB=(RadioButton)findViewById(R.id.rdiB);
		rdiC=(RadioButton)findViewById(R.id.rdiC);
		rdiD=(RadioButton)findViewById(R.id.rdiD);
		
		
		
		rdiRight=(RadioButton)findViewById(R.id.rdiRight);
		rdiError=(RadioButton)findViewById(R.id.rdiError);
		
		RLayCB=(RelativeLayout)findViewById(R.id.RLayCB);
		RLayBoolean=(RelativeLayout)findViewById(R.id.RLayBoolean);
		RLayRDI=(RelativeLayout)findViewById(R.id.RLayRDI);
		
		rg1=(RadioGroup)findViewById(R.id.radioGroup1);
		rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(IsSaveValue)
				{
					SaveSelectVlaue();
				}
			}
		});
		
		rg2=(RadioGroup)findViewById(R.id.radioGroup2);
		rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(IsSaveValue)
				{
					SaveSelectVlaue();
				}
			}
		});
		
	}
	CompoundButton.OnCheckedChangeListener cbClick=new CompoundButton.OnCheckedChangeListener()
	{
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			if(IsSaveValue)
			{
				SaveSelectVlaue();
			}
		}		
	};
 
	boolean IsSaveValue=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mtk=new TK();
		
		initItems();
		LoadItmes();
	}
	
	private void LoadDefultValue()
	{
		TI obj=	mtk.CurrentTi;
		Log.d("LoadDefultValue ","加载默认值。");
		if(obj != null)
		{
			Log.d("LoadDefultValue ",obj.EIssueResult);
			if(obj.EIssueResult != "")
			{
				if(obj.IssueType_ID=="0"){
					if(obj.EIssueResult=="√")
					{
						this.rdiRight.setChecked(true);
					}
					else
					{
						this.rdiError.setChecked(true);
					}
				}
				else if(obj.IssueType_ID=="1"){
					if(obj.EIssueResult=="A")
					{
						this.rdiA.setChecked(true);
					}
					else if(obj.EIssueResult=="B")
					{
						this.rdiB.setChecked(true);
					}
					else if(obj.EIssueResult=="C")
					{
						this.rdiC.setChecked(true);
					}
					else if(obj.EIssueResult=="D")
					{
						this.rdiD.setChecked(true);
					}
				}
				else if(obj.IssueType_ID=="2"){
					String[] strArr=obj.EIssueResult.split(",");
					for(String str : strArr)
					{
						if(str=="A")
						{
							this.cbA.setChecked(true);
						}
						else if(str=="B")
						{
							this.cbB.setChecked(true);
						}
						else if(str=="C")
						{
							this.cbC.setChecked(true);
						}
						else if(str=="D")
						{
							this.cbD.setChecked(true);
						}
					}
				}
			}
		}
		
	}
	
	private void SaveSelectVlaue()
	{
		String Result="";
		TI obj=	mtk.CurrentTi;
		if(obj != null)
		{
			if(obj.IssueType_ID=="0"){
				if(this.rdiRight.isChecked())
				{
					Result="√";
				}
				else if(this.rdiError.isChecked())
				{
					Result="×"; 
				}
			}
			else if(obj.IssueType_ID=="1"){
				if(this.rdiA.isChecked())
				{
					Result="A";
				}
				else if(this.rdiB.isChecked())
				{
					Result="B";
				}
				else if(this.rdiC.isChecked())
				{
					Result="C";
				}
				else if(this.rdiD.isChecked())
				{
					Result="D";
				}
			}
			else if(obj.IssueType_ID=="2"){
				String multResult="";
				if(this.cbA.isChecked())
				{
					multResult="A,";
				}
				else if(this.cbA.isChecked())
				{
					multResult+="B,";
				}
				else if(this.cbA.isChecked())
				{
					multResult+="C,";
				}
				else if(this.cbA.isChecked())
				{
					multResult+="D";
				}
				if(multResult.endsWith(","))
				{
					multResult=multResult.substring(0, multResult.length()-1);
				}
				Result=multResult;
			}
			if(Result !="")
			{
				mtk.CurrentTi.EIssueResult=Result;
				
				if(obj.IssueType_ID=="0" || obj.IssueType_ID=="1")
				{
					if(mtk.CurrentTi.EIssueResult !="")
					{
						//判断是否正确
						if(mtk.CurrentTi.EIssueResult==mtk.CurrentTi.Answer)
						{
							Toast.makeText(MainActivity.this,"回答正确。", Toast.LENGTH_LONG).show();
						}
						else
						{
							Toast.makeText(MainActivity.this,"回答错误,正确答案是："+ mtk.CurrentTi.Answer, Toast.LENGTH_LONG).show();
						}
					}
				}
				if(obj.IssueType_ID=="2")
				{
					if(mtk.CurrentTi.EIssueResult==mtk.CurrentTi.Answer)
					{
						Toast.makeText(MainActivity.this,"回答正确。", Toast.LENGTH_LONG).show();
					}				
				}
			}
		}//if(obj != null)
	}
	
	private void GetNextTi()
	{
		//SaveSelectVlaue();
		if(this.mtk.GetNextTi())
		{
			LoadItmes();
		}
	}
	private void GetPrevTi()
	{
		//SaveSelectVlaue();
		if(this.mtk.GetPrevTi())
		{
			LoadItmes();
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case  R.id.menu_next_ti:
				GetNextTi();
			break;
			case R.id.menu_Prev_ti:
				GetPrevTi();
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
	
	public void ClearValue()
	{
		this.cbA.setChecked(false);
		this.cbB.setChecked(false);
		this.cbC.setChecked(false);
		this.cbD.setChecked(false); 
		
 		rg1.clearCheck();
 		rg2.clearCheck();
 	}
	
	//listTi.add(new TI(1,2,"动画1中有几种违法行为？","","1","B","<p>A.?一种违法行为<br />B.?二种违法行为<br />C.?三种违法行为<br /> D.?四种违法行为<br /><br /></p>","","uploadfiles_subject3_avi1.wmv"));
	public void LoadItmes()
	{
		IsSaveValue=false;
		TI obj=	mtk.CurrentTi;
		if(obj != null)
		{ 
			ClearValue();
			this.txtTitle.setText( obj.ID  + ".  " + obj.IssueSubject.toString());
			//显示img
			if(obj.ImagePath.trim().endsWith(".jpg"))
			{
				Log.d("ErrorMsg ","处理图片.");
				imgItems.setVisibility(View.VISIBLE);
				//imgItems.setImageResource(R.drawable.uploadfiles_subject3_img124);
				int resID = getResources().getIdentifier(obj.ImagePath.replace(".jpg", ""), "drawable", "com.ritacc.ks");
				imgItems.setImageResource(resID);
			}
			else
			{
				Log.d("ErrorMsg ","隐藏图片."); 
				imgItems.setVisibility(View.GONE);
			}
			
			RLayCB.setVisibility(View.GONE);
			RLayBoolean.setVisibility(View.GONE);
			RLayRDI.setVisibility(View.GONE);
			
			if(obj.IssueType_ID=="0")//判断
			{
				RLayBoolean.setVisibility(View.VISIBLE);
			}
			else if(obj.IssueType_ID=="1" || obj.IssueType_ID=="2")//单选 ,2多选
			{
				 
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
							
							if(obj.IssueType_ID=="1")//单选 
							{
								RLayRDI.setVisibility(View.VISIBLE);
								rdiA.setText(strA);
								rdiB.setText(strB);
								rdiC.setText(strC);
								rdiD.setText(strD);
							}
							else if(obj.IssueType_ID=="2")//多选
							{
								RLayCB.setVisibility(View.VISIBLE);
								cbA.setText(strA);
								cbB.setText(strB);
								cbC.setText(strC);
								cbD.setText(strD);
							}
			 			}
					}
					catch(Exception ex)
					{
						Log.d("Exception indexof ",ex.getMessage());
					}
				}
			}
			//加载默认值
			
			LoadDefultValue();
		}// end if(obj != null)
		IsSaveValue=true;
	}

	
	float dx=0;
	float dy=0;
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x=event.getX();
		float y=event.getY();
		switch(event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				dx=x;
				dy=y;
			break;
			case MotionEvent.ACTION_MOVE:
				break;
			case MotionEvent.ACTION_UP:
				 if((x-dx)*-1 >30)
				 {
					 GetNextTi();
				 }
				 if((x-dx) > 30)
				 {
					 this.GetPrevTi();
				 }
				break;
		}
		return true; 
	}
	
	 
	
	
}
