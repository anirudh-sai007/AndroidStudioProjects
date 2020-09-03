package com.example.redcacheconnect;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	String s1,s2;
	SQLiteDatabase sdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=(Button) findViewById(R.id.button1);
        Button bt2=(Button) findViewById(R.id.button2);
        final EditText et1=(EditText) findViewById(R.id.editText1);
        final EditText et2=(EditText) findViewById(R.id.editText2);
        sdb=openOrCreateDatabase("BloodBankFinal",MODE_PRIVATE,null);
        bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=et1.getText().toString().trim();
				s2=et2.getText().toString().trim();
				
				if(s1.equals("admin") && s2.equals("admin")) {
					Intent it4=new Intent(MainActivity.this,AdminActivity.class);
					startActivity(it4);
					} 
				
				else if(!s1.equals("") && !s2.equals("")) {
					Cursor c=sdb.rawQuery("select * from xyz where USERNAME='"+s1+"' and PASSWORD='"+s2+"' ", null);
					c.moveToFirst();
				if(c!=null)
					{
					do {
					
						int a=c.getColumnIndex("USERNAME");
						int b=c.getColumnIndex("PASSWORD");
						String s=c.getString(a);
						String ss=c.getString(b);
						if (s1.equals(s) && s2.equals(ss)) {
							Intent it=new Intent(MainActivity.this,UserActivity.class);
							startActivity(it);
						} else {
                            Toast.makeText(getApplicationContext(), "INVALID",Toast.LENGTH_LONG).show();
						}
					} while (c.moveToNext());
				} 
				}
				
			}
		});
 bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(MainActivity.this,RegisterActivity.class);
				startActivity(it);
			}
		});
   
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
