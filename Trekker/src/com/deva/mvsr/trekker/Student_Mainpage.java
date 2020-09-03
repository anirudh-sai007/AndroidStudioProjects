package com.deva.mvsr.trekker;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.deva.mvsr.trekker.R;

public class Student_Mainpage extends Activity {

	AmazonSimpleDBClient sdbClient;
	ArrayList<String> al = new ArrayList<String>();
	String imagename = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student__mainpage);
		final Spinner sp = (Spinner) findViewById(R.id.spinner1);
		AWSCredentials credentials = new BasicAWSCredentials(Constants.ACCESS_KEY_ID,
				Constants.SECRET_KEY);
		sdbClient = new AmazonSimpleDBClient(credentials);
		Driver_LatLong_Class rlist = new Driver_LatLong_Class();
		rlist.createDomain();
		List<Others> list = rlist.getAllValues();
		int len = list.size();
		System.out.println("size @@@@@@@@@@@@@" + len + list);
		for (int i = 0; i < len; i++) {

			Others oo = list.get(i);
			imagename = oo.getName();

			al.add(imagename);

			System.out.println("image names       " + oo.getName()
					+ "===========");
		}

		sp.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, al));
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String aa=sp.getSelectedItem().toString();
				Intent it=new Intent(Student_Mainpage.this,ShowActivity.class);
				it.putExtra("aa",aa);
				startActivity(it);
			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_student__mainpage, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			 final SharedPreferences pref1 = getApplicationContext().getSharedPreferences("PrefUser", 0);
				
				Intent it3=new Intent(Student_Mainpage.this,MainActivity.class);
				Editor editor = pref1.edit();
				editor.putString("phone", ""); // Storing string
				editor.putString("pwd", ""); // Storing integer					  
				editor.commit();
				startActivity(it3);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	

}
