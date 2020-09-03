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

public class MsgSendingFinalActivity extends Activity {
	Spinner sp1,sp2;
	Button bt1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_msg_sending_final);
		sp1=(Spinner) findViewById(R.id.spinner1);
		sp2=(Spinner) findViewById(R.id.spinner2);
		String[] a={"a+","o","ab-","b+","a-"};
		ArrayAdapter<String> apt=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,a);
		sp1.setAdapter(apt);
		bt1=(Button) findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Intent it=new Intent(MsgSendingFinalActivity.this,MsgNamesActivity.class);
				startActivity(it);
			}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_msg_sending_final, menu);
		return true;
	}

}
