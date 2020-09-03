package com.example.redcacheconnect;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBackActivity extends Activity {
	SQLiteDatabase sdb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feed_back);
		final EditText et1=(EditText) findViewById(R.id.editText1);
		final EditText et2=(EditText) findViewById(R.id.editText2);
		final EditText et3=(EditText) findViewById(R.id.editText3);
		final EditText et4=(EditText) findViewById(R.id.editText4);
		Button bt1=(Button) findViewById(R.id.button1);
		sdb=openOrCreateDatabase("BloodBankFinal",MODE_PRIVATE,null);
		sdb.execSQL("create table if not exists lmn(Name varchar(30),CONTACT_NUMBER Integer(20),EMAIL_ID varchar(20),Messageforvisitors varchar(20))");
		
	bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String s1=et1.getText().toString().trim();
				String s2=et2.getText().toString().trim();
				String s3=et3.getText().toString().trim();
				String s4=et4.getText().toString();
				
				if(TextUtils.isEmpty(s1)){
					 
					 Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_LONG).show();
				}
				else if(TextUtils.isEmpty(s2)){
					 
					 Toast.makeText(getApplicationContext(), "Contact Number is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s3)){
					 
					 Toast.makeText(getApplicationContext(), "E-Mail Id is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s4)){
					 
					 Toast.makeText(getApplicationContext(), "Message For Visitors is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				
				else
				{
				sdb.execSQL("insert  into lmn values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
				 Intent it=new Intent(FeedBackActivity.this,EmergencyActivity.class);
					startActivity(it);
				  
             
				}
				
				
			}

			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_feed_back, menu);
		return true;
	}

}
