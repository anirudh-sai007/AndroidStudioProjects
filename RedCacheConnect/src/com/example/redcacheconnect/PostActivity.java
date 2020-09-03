package com.example.redcacheconnect;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PostActivity extends Activity {
	Spinner sp1,sp2;
	Button bt1,bt2;
	SQLiteDatabase sdb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post);
		sp1=(Spinner) findViewById(R.id.spinner1);
		sp2=(Spinner) findViewById(R.id.spinner2);
		final EditText et1=(EditText) findViewById(R.id.editText1);
		final EditText et2=(EditText) findViewById(R.id.editText2);
		final EditText et3=(EditText) findViewById(R.id.editText3);
		final EditText et4=(EditText) findViewById(R.id.editText4);
		final EditText et5=(EditText) findViewById(R.id.editText5);
		final EditText et6=(EditText) findViewById(R.id.editText6);
		final EditText et7=(EditText) findViewById(R.id.editText7);
		final EditText et8=(EditText) findViewById(R.id.editText8);
		sdb=openOrCreateDatabase("BloodBankFinal",MODE_PRIVATE,null);
		sdb.execSQL("create table if not exists pqr(PatientName varchar(30),Area  varchar(20),HospitalName varchar(20),HospitalAddress varchar(10),onorbefore varchar(30),UserName varchar(30),CONTACT_NUMBER Integer(20),EMAIL_ID varchar(20))");
	
		bt1=(Button) findViewById(R.id.button1);
		 bt2=(Button) findViewById(R.id.button2);
		String[] a={"a+","o","ab-","b+","a-"};
		ArrayAdapter<String> apt=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,a);
		sp1.setAdapter(apt);
	
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String s1=et1.getText().toString().trim();
				String s2=et2.getText().toString().trim();
				String s3=et3.getText().toString().trim();
				String s4=et4.getText().toString().trim();
				String s5=et5.getText().toString().trim();
				String s6=et6.getText().toString().trim();
				String s7=et7.getText().toString().trim();
				String s8=et8.getText().toString().trim();
				
				if(TextUtils.isEmpty(s1)){
					 
					 Toast.makeText(getApplicationContext(), "Patient Name is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s2)){
					 
					 Toast.makeText(getApplicationContext(), "Area is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s3)){
					 
					 Toast.makeText(getApplicationContext(), "Hospital Name is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s4)){
					 
					 Toast.makeText(getApplicationContext(), "Hospital Address is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s5)){
					 
					 Toast.makeText(getApplicationContext(), "on or before is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s6)){
					 
					 Toast.makeText(getApplicationContext(), "User Name is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s7)){
					 
					 Toast.makeText(getApplicationContext(), "Contact Number is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s8)){
					 
					 Toast.makeText(getApplicationContext(), "E-Mail Id is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else
				{
				sdb.execSQL("insert  into pqr values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')");
				 Intent it=new Intent(PostActivity.this,EmergencyActivity.class);
					startActivity(it);
				  
             
				}
				
			}
		});
        bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_post, menu);
		return true;
	}

}
