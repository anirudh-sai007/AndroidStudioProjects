package com.deva.mvsr.trekker;

import java.util.ArrayList;

import com.deva.mvsr.trekker.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button login;
	EditText id,pass;
	Spinner select;
	ArrayList<String> al=new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 if (android.os.Build.VERSION.SDK_INT > 9) {
			    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			    StrictMode.setThreadPolicy(policy);
			}
		select=(Spinner)findViewById(R.id.spinner1);
		al.add("Admin");
		al.add("Driver");
		al.add("Student");
		id=(EditText)findViewById(R.id.editText1);
		pass=(EditText)findViewById(R.id.editText2);
		ArrayAdapter<String> adp=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,al);
		select.setAdapter(adp);
		select.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				final SharedPreferences pref = getApplicationContext().getSharedPreferences("PrefUser", 0); // 0 - for private mode
				String aa1=pref.getString("phone", "");
				String bb2=pref.getString("pwd", "");
				
				final SharedPreferences prefdrive = getApplicationContext().getSharedPreferences("PrefDriver", 0); // 0 - for private mode
				String daa=prefdrive.getString("phone", "");
				String dbb=prefdrive.getString("pwd", "");
				String sselect=select.getSelectedItem().toString();
				if (sselect.equals("Student")) {
					if(aa1.equals("") && bb2.equals("")){
						Toast.makeText(getApplicationContext(), "no data", Toast.LENGTH_SHORT).show();
					}else{
						Intent it=new Intent(MainActivity.this,Student_Mainpage.class);
						it.putExtra("key1", aa1);
						startActivity(it);
						}
				}else if (sselect.equals("Driver")) {
					if(daa.equals("") && dbb.equals("")){
						Toast.makeText(getApplicationContext(), "no data", Toast.LENGTH_SHORT).show();
					}else{
						Intent it=new Intent(MainActivity.this,Driver_Mainpage.class);
						it.putExtra("key1", aa1);
						startActivity(it);
						}
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		final SharedPreferences pref = getApplicationContext().getSharedPreferences("PrefUser", 0); // 0 - for private mode
		/*String aa1=pref.getString("phone", "");
		String bb2=pref.getString("pwd", "");*/
		
		final SharedPreferences prefdrive = getApplicationContext().getSharedPreferences("PrefDriver", 0); // 0 - for private mode
		/*String daa=prefdrive.getString("phone", "");
		String dbb=prefdrive.getString("pwd", "");
		*/
		
		/*if (select.equals("Student")) {
			if(aa1.equals("") && bb2.equals("")){
				Toast.makeText(getApplicationContext(), "no data", Toast.LENGTH_SHORT).show();
			}else{
				Intent it=new Intent(MainActivity.this,Student_Mainpage.class);
				it.putExtra("key1", aa1);
				startActivity(it);
				}
		}else {
			Toast.makeText(getApplicationContext(), "select user", Toast.LENGTH_SHORT).show();
		}*/
		
		login=(Button)findViewById(R.id.button1);
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String sid=id.getText().toString().trim();
				System.out.println("@@@@@@@@@@@@@@     "+sid);
				String spass=pass.getText().toString().trim();
				String sselect=select.getSelectedItem().toString().trim();
				
				if (sid.equals("") || spass.equals("")) {
					Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_SHORT).show();
				} else {
					if (sselect.equals("Admin")) {
							if (sid.equals("admin") && spass.equals("admin")) {
								Intent it1=new Intent(MainActivity.this,Admin_Mainpage.class);
								startActivity(it1);
							} else {
								Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
								
							}
						
					}else if (sselect.equals("Driver")) {
						if (!sid.equals("") && !spass.equals("")) {
							DriverRegister_Class rlist = new DriverRegister_Class();

							int ver = rlist.loginVerify(sid, spass);
							if (ver == 0) {
								Toast.makeText(getBaseContext(),
										"In Valid Credentials", 30).show();
							} else {
								Editor editor1 = prefdrive.edit();
								editor1.putString("phone", sid); // Storing string
								editor1.putString("pwd", spass); // Storing integer					  
								editor1.commit();
								Intent it = new Intent(MainActivity.this,Driver_Mainpage.class);
								it.putExtra("ss", sid);
								System.out.println("@@@@@@@@@@@@@@     "+sid);
								startActivity(it);
								finish();
							}
							
						} else {

						}
						
					}else if (sselect.equals("Student")) {
						 if (!sid.equals("") && !spass.equals("")) {
								StudentRegister_Class rlist = new StudentRegister_Class();

								int ver = rlist.loginVerify(sid, spass);

								if (ver == 0) {
									Toast.makeText(getBaseContext(),
											"In Valid Credentials", 30).show();
								} else {
									Editor editor = pref.edit();
									editor.putString("phone", sid); // Storing string
									editor.putString("pwd", spass); // Storing integer					  
									editor.commit();
									Intent it1=new Intent(MainActivity.this,Student_Mainpage.class);
									it1.putExtra("ss", sid);
									startActivity(it1);
									finish();
								}
							} else {
								Toast.makeText(getApplicationContext(),
										"please enter all fields", 90).show();
							}
						
					}
				}
			}
		});
	}

	

}
