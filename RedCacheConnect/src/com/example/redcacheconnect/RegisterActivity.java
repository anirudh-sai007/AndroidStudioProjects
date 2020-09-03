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

public class RegisterActivity extends Activity {
	SQLiteDatabase sdb;
	int count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		final EditText et1=(EditText) findViewById(R.id.editText1);
		final EditText et2=(EditText) findViewById(R.id.editText2);
		final EditText et3=(EditText) findViewById(R.id.editText3);
		final EditText et4=(EditText) findViewById(R.id.editText4);
		final EditText et5=(EditText) findViewById(R.id.editText5);
		final EditText et6=(EditText) findViewById(R.id.editText6);
		final EditText et7=(EditText) findViewById(R.id.editText7);
		final EditText et8=(EditText) findViewById(R.id.editText8);
		final EditText et9=(EditText) findViewById(R.id.editText9);
		final EditText et10=(EditText) findViewById(R.id.editText10);
		final EditText et11=(EditText) findViewById(R.id.editText11);
		final EditText et12=(EditText) findViewById(R.id.editText12);
		final EditText et13=(EditText) findViewById(R.id.editText13);
		final EditText et14=(EditText) findViewById(R.id.editText14);
		Button bt1=(Button) findViewById(R.id.button1);
		Button bt2=(Button) findViewById(R.id.button2);
		sdb=openOrCreateDatabase("BloodBankFinal",MODE_PRIVATE,null);
		sdb.execSQL("create table if not exists xyz(FULLNAME varchar(30),USERNAME  varchar(20),PASSWORD varchar(20),DOB varchar(10),BLOOD_GROUP varchar(30) ,WEIGHT Integer(30),CONTACT_NUMBER Integer(20),EMAIL_ID varchar(20),STATE varchar(10),POSTAL_CODE  Integer(10),AREA varchar(10),LAST_DONATED_DATE varchar(10),MESSAGE_FOR_VISITORS varchar(50))");
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
				String s9=et9.getText().toString().trim();
				String s10=et10.getText().toString().trim();
				String s11=et11.getText().toString().trim();
				String s12=et12.getText().toString().trim();
				String s13=et13.getText().toString().trim();
				String s14=et14.getText().toString().trim();
				 
				if(TextUtils.isEmpty(s1)){
					 
					 Toast.makeText(getApplicationContext(), "Full Name is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s2)){
					 
					 Toast.makeText(getApplicationContext(), "User Name is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s3)){
					 
					 Toast.makeText(getApplicationContext(), "Password is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s4)){
					 
					 Toast.makeText(getApplicationContext(), "Confirm Password is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s5)){
					 
					 Toast.makeText(getApplicationContext(), "Date Of Birth is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s6)){
					 
					 Toast.makeText(getApplicationContext(), "Blood Group is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s7)){
					 
					 Toast.makeText(getApplicationContext(), "Weight is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s8)){
					 
					 Toast.makeText(getApplicationContext(), "Contact Number is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s9)){
					 
					 Toast.makeText(getApplicationContext(), "E-Mail Id is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s10)){
					 
					 Toast.makeText(getApplicationContext(), "State is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s11)){
					 
					 Toast.makeText(getApplicationContext(), "Postal Code is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s12)){
					 
					 Toast.makeText(getApplicationContext(), "Area is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s13)){
					 
					 Toast.makeText(getApplicationContext(), "Last Donated Date is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				else if(TextUtils.isEmpty(s14)){
					 
					 Toast.makeText(getApplicationContext(), "Message For Visitors is Empty", Toast.LENGTH_LONG).show();
					 
					 }
				
				else
				{
				sdb.execSQL("insert  into xyz values ('"+s1+"','"+s2+"','"+s3+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"','"+s14+"')");
				 Intent it=new Intent(RegisterActivity.this,MainActivity.class);
					startActivity(it);
				  
             
				}
				}
				
			

			
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			et1.setText("");
			et2.setText("");
			et3.setText("");
			et4.setText("");
			et5.setText("");
			et6.setText("");
			et7.setText("");
			et8.setText("");
			et9.setText("");
			et10.setText("");
			et11.setText("");
			et12.setText("");
			et13.setText("");
			et14.setText("");
			
			
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_register, menu);
		return true;
	}

}
