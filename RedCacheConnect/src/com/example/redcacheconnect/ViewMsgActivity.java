package com.example.redcacheconnect;



import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewMsgActivity extends Activity {
	ListView lv;
	SQLiteDatabase sdb;
	ArrayList<String> al=new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_msg);
		
		lv=(ListView) findViewById(R.id.listView1);
		 sdb=openOrCreateDatabase("BloodBankFinal",MODE_PRIVATE,null);
		Cursor c=sdb.rawQuery("select * from pqr", null);
		c.moveToFirst();
		if(c!=null)
		{
		do {
		int a=c.getColumnIndex("PatientName");
		String s=c.getString(a);
		ArrayAdapter<String>  apt=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, al);
		lv.setAdapter(apt);
		al.add(s);
		} while (c.moveToNext());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_msg, menu);
		return true;
	}

}
