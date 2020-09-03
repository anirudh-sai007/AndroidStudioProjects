package com.example.redcacheconnect;





import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MsgNamesActivity extends Activity {
	ListView lv;
	SQLiteDatabase sdb;
	ArrayList<String> al=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_msg_names);
		lv=(ListView) findViewById(R.id.listView1);
		 sdb=openOrCreateDatabase("BloodBankFinal",MODE_PRIVATE,null);
		Cursor c=sdb.rawQuery("select * from xyz", null);
		c.moveToFirst();
		if(c!=null)
		{
		do {
		int a=c.getColumnIndex("USERNAME");
		String s=c.getString(a);
		ArrayAdapter<String>  apt=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, al);
		lv.setAdapter(apt);
		al.add(s);
		} while (c.moveToNext());
		}
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method 	
				String s=lv.getItemAtPosition(arg2).toString();
				Intent it=new Intent(MsgNamesActivity.this,MsgUsernamesActivity.class);
				it.putExtra("username", s);
				startActivity(it);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_msg_names, menu);
		return true;
	}

}
