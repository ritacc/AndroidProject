package com.example.helloproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListOnLongClickActivity extends Activity {
	private LinearLayout myListViewlayout; 
    private ListView mListView; 
    SimpleAdapter adapter; 
    public int MID;
    
    // ����һ��List������������б����ÿһ��map��Ϣ 
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_on_long_click);
		
		 myListViewlayout = (LinearLayout) findViewById(R.id.myListViewlayout); 
         mListView = new ListView(this); 
      // �������ֲ��� 
         LinearLayout.LayoutParams listviewParams = new LinearLayout.LayoutParams( 
                         LinearLayout.LayoutParams.FILL_PARENT, 
                         LinearLayout.LayoutParams.FILL_PARENT); 
         // �������б��ϣ�Ĭ����ʾ�ĺ�ɫ 
         mListView.setCacheColorHint(Color.WHITE); 
         // ���б���ӵ���ʽ����myListViewlayout�� 
         myListViewlayout.addView(mListView, listviewParams); 

         FillListData(); 
         // �б��ֵĵ����¼� 
         
//         mListView.setOnItemSelectedListener(new OnItemSelectedListener(Object e) { 
//
//                 @Override
//                 public void onItemClick(AdapterView<?> arg0, View arg1, 
//                                 int position, long id) { 
//                         /* 
//                          * ����б���ʱ����onItemClick�������ĸ���������ֱ�Ϊ 
//                          * arg0�����������¼���AdapterView 
//                          * arg1��AdapterView�б������View  
//                          * position����ǰ���������adapter���±� 
//                          * id����ǰ������е�id 
//                          */ 
//                         Toast.makeText(ListOnLongClickActivity.this, 
//                                         "��ѡ�����" + list.get(position).get("name").toString(), 
//                                         Toast.LENGTH_SHORT).show(); 
//                 }
//
//				@Override
//				public void onItemSelected(AdapterView<?> arg0, View arg1,
//						int arg2, long arg3) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void onNothingSelected(AdapterView<?> arg0) {
//					// TODO Auto-generated method stub
//					
//				} 
//         }); 

         /** 
          * Item ������ʽ�����˵���ѡ��ʽ1 
          * Item ������ʽ�����˵���ѡ��ʽ2 
          * ItemOnLongClick1()��ItemOnLongClick2()�����棬��ʵ����Ҫѡ�� 
          */
 //        ItemOnLongClick1(); 
    //     ItemOnLongClick2(); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_on_long_click, menu);
		return true;
	}
	
	 // ���ListView��Դ 
    private void FillListData() { 

            adapter = new SimpleAdapter(ListOnLongClickActivity.this, 
                            getListData(), R.layout.activity_sql_lite_dict_items, new String[] { "name", 
                                            "price" }, new int[] { R.id.title, R.id.info }); 
            mListView.setAdapter(adapter); 
    } 
    
    private List<Map<String, Object>> getListData() { 

        Map<String, Object> _map = new HashMap<String, Object>(); 
        _map.put("name", "С��"); 
        _map.put("price", "2350Ԫ"); 
        list.add(_map); 

        _map = new HashMap<String, Object>(); 
        _map.put("name", "HTC G18"); 
        _map.put("price", "3340Ԫ"); 
        list.add(_map); 

        _map = new HashMap<String, Object>(); 
        _map.put("name", "iphone 5"); 
        _map.put("price", "5450Ԫ"); 
        list.add(_map); 

        _map = new HashMap<String, Object>(); 
        _map.put("name", "iPhone 4S"); 
        _map.put("price", "4650Ԫ"); 
        list.add(_map); 

        _map = new HashMap<String, Object>(); 
        _map.put("name", "MOTO ME525"); 
        _map.put("price", "1345Ԫ"); 
        list.add(_map); 
        return list; 

} 
    
//    private void ItemOnLongClick1() { 
//    	//ע��setOnCreateContextMenuListener��������onContextItemSelected����ʹ�õ� 
//	      mListView.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
//	            public void onCreateContextMenu(ContextMenu menu, View v, 
//	                            ContextMenuInfo menuInfo) { 
//	                    menu.add(0, 0, 0, "����"); 
//	                    menu.add(0, 1, 0, "�ղ�"); 
//	                    menu.add(0, 2, 0, "�Ա�"); 
//	
//	            }
//
//				@Override
//				public void onCreateContextMenu(ContextMenu menu, View v,
//						ContextMenuInfo menuInfo) {
//					// TODO Auto-generated method stub
//					
//				} 
//	      }); 
//    } 
//
//    // �����˵���Ӧ���� 
//    public boolean onContextItemSelected(MenuItem item) { 
//
//            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item 
//                            .getMenuInfo(); 
//            MID = (int) info.id;// �����info.id��Ӧ�ľ������ݿ���_id��ֵ 
//
//            switch (item.getItemId()) { 
//            case 0: 
//                    // ��Ӳ��� 
//                    Toast.makeText(ListOnLongClickActivity.this, "���",Toast.LENGTH_SHORT).show();
//                    break;
//            case 1:
//                    // ɾ������ 
//                    break;
//            case 2: 
//                    // ɾ��ALL���� 
//                    break;
//            default: 
//                    break; 
//            } 
//
//            return super.onContextItemSelected(item); 
//    } 
//    
//    private void ItemOnLongClick2() { 
//        mListView.setOnItemLongClickListener(new OnItemLongClickListener() {
//                @Override
//                public boolean onItemLongClick(AdapterView<?> arg0, View arg1, 
//                                final int arg2, long arg3) { 
//                        list.remove(arg2); 
//                        new AlertDialog.Builder(ListOnLongClickActivity.this) 
//                                        .setTitle("��Item���в���") 
//                                        .setItems(R.array.arrcontent, 
//                                                        new DialogInterface.OnClickListener() { 
//                                                                public void onClick(DialogInterface dialog, 
//                                                                                int which) { 
//                                                                        String[] PK = getResources() 
//                                                                                        .getStringArray(R.array.arrcontent); 
//                                                                        Toast.makeText( 
//                                                                                        ListOnLongClickActivity.this, 
//                                                                                        PK[which], Toast.LENGTH_LONG) 
//                                                                                        .show(); 
//                                                                        if (PK[which].equals("ɾ��")) { 
//                                                                                // �������ַ�ʽ��ɾ�����������if�ڵĴ�����bug��ʵ�ʴ����а������ 
//                                                                                list.remove(arg2); 
//                                                                                adapter = (SimpleAdapter) mListView 
//                                                                                                .getAdapter(); 
//                                                                                if (!adapter.isEmpty()) { 
//                                                                                        adapter.notifyDataSetChanged(); // ʵ�����ݵ�ʵʱˢ�� 
//                                                                                } 
//                                                                        } 
//                                                                } 
//                                                        }) 
//                                        .setNegativeButton("ȡ��", 
//                                                        new DialogInterface.OnClickListener() { 
//                                                                public void onClick(DialogInterface dialog, 
//                                                                                int which) { 
//                                                                        // TODO Auto-generated method stub 
//
//                                                                } 
//                        }).show(); 
//                        return true; 
//                } 
//        }); 
//
//    } 

    
    
    
    
    
    
    
    

}
