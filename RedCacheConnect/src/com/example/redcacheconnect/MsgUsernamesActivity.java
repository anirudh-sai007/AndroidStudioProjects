package com.example.redcacheconnect;





import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MsgUsernamesActivity extends Activity {
	ListView lv;
	SQLiteDatabase sdb;
	ArrayList<String> al=new ArrayList<String>();
	String s2,s3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_msg_usernames);
		Button bt1=(Button) findViewById(R.id.button1);
		Button bt2=(Button) findViewById(R.id.button2);
		Button bt3=(Button) findViewById(R.id.button3);
		final TextView tv1=(TextView) findViewById(R.id.textView5);
		TextView tv2=(TextView) findViewById(R.id.textView6);
		TextView tv3=(TextView) findViewById(R.id.textView7);
		TextView tv4=(TextView) findViewById(R.id.textView8);
		Intent it=getIntent();
		String ss=it.getStringExtra("username");
		
		
		sdb=openOrCreateDatabase("BloodBankFinal",MODE_PRIVATE,null);
		Cursor c=sdb.rawQuery("select * from xyz where USERNAME='"+ss+"'", null);
		c.moveToFirst();
		if(c!=null)
		{
		do {
		int a=c.getColumnIndex("USERNAME");
		String s=c.getString(a);
		tv1.setText(s);
		
		
		int b=c.getColumnIndex("FULLNAME");
		String s1=c.getString(b);
		tv2.setText(s1);
		
		
		int e=c.getColumnIndex("CONTACT_NUMBER");
		 s2=c.getString(e);
		tv3.setText(s2);
		
		
		int f=c.getColumnIndex("EMAIL_ID");
		 s3=c.getString(f);
		tv4.setText(s3);
		
		
		} while (c.moveToNext());
		}
bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+s2));
				startActivity(it);
			}
		});
bt2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent it1=new Intent(MsgUsernamesActivity.this,MsgActivity.class);
		it1.putExtra("message", s2);
		startActivity(it1);
	}
});
bt3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_msg_usernames, menu);
		return true;
	}

}
