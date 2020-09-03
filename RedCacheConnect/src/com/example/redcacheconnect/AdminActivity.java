package com.example.redcacheconnect;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdminActivity extends Activity {
	Button bt1,bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		bt1=(Button) findViewById(R.id.button1);
		bt2=(Button) findViewById(R.id.button2);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it1=new Intent(AdminActivity.this,AddBloodBankActivity.class);
				startActivity(it1);
				
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it2=new Intent(AdminActivity.this,ViewBloodBankActivity.class);
				startActivity(it2);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_admin, menu);
		return true;
	}

}
