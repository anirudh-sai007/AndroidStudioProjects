package com.example.redcacheconnect;





import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);
		setContentView(R.layout.activity_user);
		Button bt1=(Button) findViewById(R.id.button1);
		Button bt2=(Button) findViewById(R.id.button2);
		Button bt3=(Button) findViewById(R.id.button3);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UserActivity.this,SendMsgActivity.class);
				startActivity(it);
				}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UserActivity.this,BloodBankDetailsActivity.class);
				startActivity(it);
				
			}
		});
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UserActivity.this,EmergencyActivity.class);
				startActivity(it);	
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_user, menu);
		return true;
	}

}
