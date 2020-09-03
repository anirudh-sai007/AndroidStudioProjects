package com.deva.mvsr.trekker;

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
import android.widget.Button;
import android.widget.TextView;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.Item;
import com.amazonaws.services.simpledb.model.SelectRequest;
import com.amazonaws.services.simpledb.model.SelectResult;
import com.deva.mvsr.trekker.R;

public class ShowActivity extends Activity {
	AmazonSimpleDBClient sdbClient;
	
	SelectResult selectResult = null;
	String sNextToken = null;
	String query = null;
	String aas,aas1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		Bundle b = getIntent().getExtras();
		String aa = b.getString("aa");
		TextView tv1 = (TextView) findViewById(R.id.textView1);
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		
		BasicAWSCredentials bs = new BasicAWSCredentials(
				Constants.ACCESS_KEY_ID, Constants.SECRET_KEY);
		AmazonSimpleDBClient as = new AmazonSimpleDBClient(bs);
		/*AWSCredentials credentials = new BasicAWSCredentials(Constants.ACCESS_KEY_ID,
				Constants.SECRET_KEY);
		sdbClient = new AmazonSimpleDBClient(credentials);
		Driver_LatLong_Class rlist = new Driver_LatLong_Class();
		rlist.createDomain();
		List<Others> list = rlist.getAllValues22(aa);
		int len = list.size();
		System.out.println("Sivaaaaaaaaaaaaaaaaa" + list);
		String data1 = list.toString();
		String[] a1 = data1.split(",");
		String des1 = a1[9];
		String[] desc = des1.split(":");
		final String aas = desc[1];

		String des2 = a1[14];
		String[] desc1 = des2.split(":");

		final String aas1 = desc1[1];

		System.out.println("!!!@@@" + aas1 + ":" + aas);*/
		
		
		do {

			query = "select * from TrackBus where DriverId='" + aa + "'";
			SelectRequest selectRequest = new SelectRequest(query);
			selectRequest.setNextToken(sNextToken);
			selectResult = as.select(selectRequest);
			sNextToken = selectResult.getNextToken();
			List<Item> list = selectResult.getItems();

			for (Item item : list) {
				item.getName(); // itemName
				List<Attribute> listAttribute = item.getAttributes();
				for (Attribute attribute : listAttribute) {
					if (attribute.getName().equals("BusLatitude")) {
						 aas=(attribute.getValue());
						tv1.setText("Bus Current Lattitude  :" + aas);
					}
					if (attribute.getName().equals("BusLong")) {
						  aas1=(attribute.getValue());
						 tv2.setText("Bus Current Longitude  :" + aas1);
						
					}

					
				}
			}
		} while (sNextToken != null);
	
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(ShowActivity.this,MapActivity.class);
				it.putExtra("aas",aas);
				it.putExtra("aas1", aas1);
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
				
				Intent it3=new Intent(ShowActivity.this,MainActivity.class);
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
