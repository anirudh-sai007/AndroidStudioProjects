package com.deva.mvsr.trekker;

import com.deva.mvsr.trekker.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Admin_Mainpage extends Activity {
	Button driver,student;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin__mainpage);
		driver=(Button)findViewById(R.id.button1);
		driver.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it1=new Intent(Admin_Mainpage.this,Registration_Driver.class);
				startActivity(it1);
			}
		});
		student=(Button)findViewById(R.id.button2);
		student.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it2=new Intent(Admin_Mainpage.this,Registration_Student.class);
				startActivity(it2);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_admin__mainpage, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			// final SharedPreferences pref1 = getApplicationContext().getSharedPreferences("PrefUser", 0);
				
				Intent it3=new Intent(Admin_Mainpage.this,MainActivity.class);
				/*Editor editor = pref1.edit();
				editor.putString("phone", ""); // Storing string
				editor.putString("pwd", ""); // Storing integer					  
				editor.commit();*/
				startActivity(it3);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	

}
