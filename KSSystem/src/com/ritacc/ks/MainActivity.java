package com.ritacc.ks;

import entity.TI;
import entity.TK;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private TK mtk;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mtk=new TK();
		 
		LoadItmes();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//listTi.add(new TI(1,2,"����1���м���Υ����Ϊ��","","1","B","<p>A.?һ��Υ����Ϊ<br />B.?����Υ����Ϊ<br />C.?����Υ����Ϊ<br /> D.?����Υ����Ϊ<br /><br /></p>","","uploadfiles_subject3_avi1.wmv"));
	public void LoadItmes()
	{
		TI obj=	mtk.CurrentTi;
		//obj.i
		
	}

}
