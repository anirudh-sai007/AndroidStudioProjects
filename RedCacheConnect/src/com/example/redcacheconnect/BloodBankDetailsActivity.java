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

public class BloodBankDetailsActivity extends Activity {
	ListView lv;
	SQLiteDatabase sdb;
	ArrayList<String> al=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blood_bank_details);
		lv=(ListView) findViewById(R.id.listView1);
		 sdb=openOrCreateDatabase("BloodBankFinal",MODE_PRIVATE,null);
		Cursor c=sdb.rawQuery("select * from abc", null);
		c.moveToFirst();
		if(c!=null)
		{
		do {
		int a=c.getColumnIndex("Blood_Bank_Name");
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
				Intent it=new Intent(BloodBankDetailsActivity.this,BloodBankFullDetailsActivity.class);
				it.putExtra("BloodBankName", s);
				startActivity(it);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_blood_bank_details, menu);
		return true;
	}

}
