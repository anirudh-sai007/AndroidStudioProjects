package com.example.redcacheconnect;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class EmergencyActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emergency);
		Button bt1=(Button) findViewById(R.id.button1);
		Button bt2=(Button) findViewById(R.id.button2);
		Button bt3=(Button) findViewById(R.id.button3);
		Button bt4=(Button) findViewById(R.id.button4);
		Button bt5=(Button) findViewById(R.id.button5);
		Button bt6=(Button) findViewById(R.id.button6);
		
	
	bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(EmergencyActivity.this,ViewMsgActivity.class);
				startActivity(it);
				}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(EmergencyActivity.this,PostActivity.class);
				startActivity(it);
				
			}
		});
bt6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(EmergencyActivity.this,MainActivity.class);
				startActivity(it);
				}
		});
bt3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent it=new Intent(EmergencyActivity.this,BloodTipsActivity.class);
		startActivity(it);
		}
});
bt5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent it=new Intent(EmergencyActivity.this,AboutUsActivity.class);
		startActivity(it);
		}
});
bt4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent it=new Intent(EmergencyActivity.this,FeedBackActivity.class);
		startActivity(it);
		}
});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_emergency, menu);
		return true;
	}

}
