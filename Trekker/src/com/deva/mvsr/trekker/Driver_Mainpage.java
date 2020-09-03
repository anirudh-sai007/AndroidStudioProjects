package com.deva.mvsr.trekker;

import java.util.Timer;
import java.util.TimerTask;

import com.deva.mvsr.trekker.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Driver_Mainpage extends Activity {
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.activity_student__mainpage, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			 final SharedPreferences pref1 = getApplicationContext().getSharedPreferences("PrefDriver", 0);
				
				Intent it3=new Intent(Driver_Mainpage.this,MainActivity.class);
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

	GPSTracker gps;
	String pass;
	public static final String PREFS_NAME = "MyApp_Settings";
	TimerTask mTimerTask;
	final Handler handler = new Handler();
	Timer t = new Timer();
	TextView hTextView;
	TableRow hTableRow;
	Button hButton, hButtonStop;
	String value1, value;
	Location nwLocation;
	private int nCounter = 0;
	Bundle b;
	String b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_driver__mainpage);
		gps = new GPSTracker(this);
		
		b = getIntent().getExtras();
		b1 = b.getString("ss");
		System.out.println("@@@@@@@@@@@@@@     "+b1);
		hButton = (Button) findViewById(R.id.button1);
		hButton.setOnClickListener(mButtonStartListener);
		hButtonStop = (Button) findViewById(R.id.button2);
		hButtonStop.setOnClickListener(mButtonStopListener);

	} // end onCreate

	View.OnClickListener mButtonStartListener = new OnClickListener() {
		public void onClick(View v) {
			doTimerTask();
		}
	};

	View.OnClickListener mButtonStopListener = new OnClickListener() {
		public void onClick(View v) {
			stopTask();

		}
	};

	public void doTimerTask() {

		mTimerTask = new TimerTask() {
			public void run() {
				handler.post(new Runnable() {
					public void run() {
						nCounter++;
						// update TextView
						nwLocation = gps.getLocation(LocationManager.NETWORK_PROVIDER);
						String stringLatitude = String.valueOf(nwLocation.getLatitude());

						String stringLongitude = String.valueOf(nwLocation.getLongitude());

						Driver_LatLong_Class rlist = new Driver_LatLong_Class();
						rlist.createDomain();
						rlist.AddToTable(b1, stringLatitude, stringLongitude);

						Toast.makeText(getApplicationContext(),
								"Upload Successfully", 90).show();

						Log.d("TIMER", "TimerTask run");
					}
				});
			}
		};

		// public void schedule (TimerTask task, long delay, long period)
		t.schedule(mTimerTask, 500, 3000); //

	}

	public void stopTask() {

		if (mTimerTask != null) {

			Log.d("TIMER", "timer canceled");
			mTimerTask.cancel();
			Toast.makeText(getApplicationContext(),
					"Stopped", 90).show();
		}

	}

}
