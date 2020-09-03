package com.example.redcacheconnect;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBloodBankActivity extends Activity {
	SQLiteDatabase sdb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_blood_bank);
		final EditText et1=(EditText) findViewById(R.id.editText1);
		final EditText et2=(EditText) findViewById(R.id.editText2);
		final EditText et3=(EditText) findViewById(R.id.editText3);
		final EditText et4=(EditText) findViewById(R.id.editText4);
		Button bt=(Button) findViewById(R.id.button1);
		sdb=openOrCreateDatabase("BloodBankFinal",MODE_PRIVATE,null);
		sdb.execSQL("create table if not exists abc(Blood_Bank_Name character(10),City character(10),Address varchar(30),Contact_no integer(10)) ");
	bt.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String s1=et1.getText().toString().trim();
			String s2=et2.getText().toString().trim();
			String s3=et3.getText().toString().trim();
			String s4=et4.getText().toString().trim();
			sdb.execSQL("insert into abc values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
			Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();
			Intent it1=new Intent(AddBloodBankActivity.this,AdminActivity.class);
			startActivity(it1);
		}
	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_add_blood_bank, menu);
		return true;
	}

}
