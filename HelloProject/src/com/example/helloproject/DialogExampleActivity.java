package com.example.helloproject;

import android.os.Bundle;
import android.R.drawable;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DialogExampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog_example);
		
		final Button btnNormal=(Button) findViewById(R.id.btnNormal);
		btnNormal.setOnClickListener(btnNormal_Click);
		
		final Button btnTxtInput=(Button) findViewById(R.id.btnTxtInput);
		btnTxtInput.setOnClickListener(btnTxtInput_Click);
		
		final Button btnRdiSelect=(Button) findViewById(R.id.btnRdiSelect);
		btnRdiSelect.setOnClickListener(btnRdiSelect_Click);
		
		final Button btnMuliSelect=(Button) findViewById(R.id.btnMuliSelect);
		btnMuliSelect.setOnClickListener(btnMuliSelect_Click);
		
		final Button btnSimpleSelect=(Button) findViewById(R.id.btnSimpleSelect);
		btnSimpleSelect.setOnClickListener(btnSimpleSelect_Click);
		
		final Button btnUserDefine=(Button) findViewById(R.id.btnUserDefine);
		btnUserDefine.setOnClickListener(btnUserDefine_Click);
		//getResources().getText(id)
		//getWindow().setBackgroundDrawable(drawable)
	}
	
	//提示按钮
	btnNormal_OnClickListener btnNormal_Click=new btnNormal_OnClickListener(); 
	class btnNormal_OnClickListener implements OnClickListener
	{
		public void onClick(View v)
		{
			AlertDialog.Builder builder =new AlertDialog.Builder(DialogExampleActivity.this)
			//.setIcon(R.drawable.alert_dialog_icon)
			.setMessage("确认退出吗？")
			.setTitle("提示")
			.setPositiveButton("退出", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			/* 左键事件 */
				 dialog.dismiss();
				 DialogExampleActivity.this.finish();
			}
			})
			
			.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			/* 右键事件 */
			}
			});
			
			builder.setNeutralButton("重试", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			
			builder.setIcon(drawable.ic_menu_save);
			builder.create().show();
		}
	}
	
	public void ShowMsg(String msg)
	{	
		new AlertDialog.Builder(DialogExampleActivity.this)
		//.setIcon(R.drawable.alert_dialog_icon)
		.setMessage(msg)
		.setTitle("提示")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int whichButton) {	 
		}}).show();
	}
	
	//输入框
	btnTxtInput_OnClickListener btnTxtInput_Click=new btnTxtInput_OnClickListener(); 
	class btnTxtInput_OnClickListener implements OnClickListener
	{
		//EditText txtt=new EditText(DialogExampleActivity.this);
		public void onClick(View v)
		{
			
			new AlertDialog.Builder(DialogExampleActivity.this).setTitle("请输入")
						.setIcon(android.R.drawable.ic_dialog_info)
				        .setView(new EditText(DialogExampleActivity.this))
				        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								//ShowMsg(txtt.getText().toString());
							}
						})
				        .setNegativeButton("取消", null).show();
		}
	}
	
	//单选框
	btnRdiSelect_OnClickListener btnRdiSelect_Click=new btnRdiSelect_OnClickListener(); 
	
	class btnRdiSelect_OnClickListener implements OnClickListener
	{
		int checkedItem=1;
		 String[] strArr=new String[]{"Items1","Items2","Items3","Items4"};
		public void onClick(View v)
		{
			
			new AlertDialog.Builder(DialogExampleActivity.this).setTitle("请输入")
			.setIcon(android.R.drawable.ic_dialog_info)
	        .setSingleChoiceItems(strArr, checkedItem, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                	checkedItem = whichButton;                	 
                }
	        })
	        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							String str="你选择的id为" + String.valueOf(checkedItem)+ " , " + strArr[checkedItem];
							 
							ShowMsg(str);
						}
					})
	        .setNegativeButton("取消", null).show();
						
		}
	}
	
	//多选选框
	btnMuliSelect_OnClickListener btnMuliSelect_Click=new btnMuliSelect_OnClickListener(); 
	class btnMuliSelect_OnClickListener implements OnClickListener
	{
		 String[] strArr=new String[]{"Items1","Items2","Items3","Items4"};
		 boolean[] bSelectArr=new boolean[]{false,true,true,false};
		public void onClick(View v)
		{
			new AlertDialog.Builder(DialogExampleActivity.this).setTitle("请输入")
					.setIcon(android.R.drawable.ic_dialog_info)
			        .setMultiChoiceItems(strArr, bSelectArr, new DialogInterface.OnMultiChoiceClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which, boolean isChecked) {
							// TODO Auto-generated method stub
							bSelectArr[which]=isChecked;
						}
					} )
			        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							String str="";
							for(int i=0;i< bSelectArr.length;i++)
							{
								if(bSelectArr[i]){
									str+="选择项：" + i + " Value:"+ strArr[i]+"\r\n";
								}
							}
							ShowMsg(str);
						}
					})
			        .setNegativeButton("取消", null).show();
		}
	}
			
	//简单选择选框
	btnSimpleSelect_OnClickListener btnSimpleSelect_Click=new btnSimpleSelect_OnClickListener(); 
	class btnSimpleSelect_OnClickListener implements OnClickListener
	{
		public void onClick(View v)
		{
			new AlertDialog.Builder(DialogExampleActivity.this).setTitle("请输入")
						.setIcon(android.R.drawable.ic_dialog_info)
				        .setItems(new String[]{"Items1","Items2","Items3","Items4"}, null)
				        .setPositiveButton("确定", null)
				        .setNegativeButton("取消", null).show();
		}
	}
	
	//自定义
	btnUserDefine_OnClickListener btnUserDefine_Click=new btnUserDefine_OnClickListener(); 
	class btnUserDefine_OnClickListener implements OnClickListener
	{
		public void onClick(View v)
		{

//			LayoutInflater inflater = getLayoutInflater();
//			View vlayout = inflater.inflate(R.layout.dialoglayout,(LinearLayout)findViewById(R.id.dialogname));
			  LayoutInflater factory = LayoutInflater.from(DialogExampleActivity.this);
	            final View textEntryView = factory.inflate(R.layout.dialoglayout, null);
	            
			new AlertDialog.Builder(DialogExampleActivity.this).setTitle("请输入")
						.setIcon(android.R.drawable.ic_dialog_info)
				        .setView(textEntryView)
				        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								EditText userName = (EditText) textEntryView.findViewById(R.id.etUserName);
								EditText pwd = (EditText) textEntryView.findViewById(R.id.etPassWord);
								
								String str="用户名：" +userName.getText().toString()+"\r\n";
								str+="密码："+pwd.getText().toString();
								ShowMsg(str);
							}
						})
				        .setNegativeButton("取消", null).show();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.dialog_example, menu);
		return true;
	}

}
