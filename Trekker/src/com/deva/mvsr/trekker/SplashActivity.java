package com.deva.mvsr.trekker;

import com.deva.mvsr.trekker.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);Thread t=new Thread(){
        	
        	@Override
        	public void run() {
        		// TODO Auto-generated method stub
        		try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		Intent launchNextActivity;
				launchNextActivity = new Intent(SplashActivity.this,MainActivity.class);
				/*launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);                  
				launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);*/
				startActivity(launchNextActivity);
        	}
        };
        t.start();
    }



}
