package com.deva.mvsr.trekker;

import com.deva.mvsr.trekker.R;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MapActivity extends Activity implements LocationListener {
	AppLocationService appLocationService;
	double latitude2;
	double longitude2;
	String provider = LocationManager.NETWORK_PROVIDER;
	LocationManager locationManager;
	Location location;
	double lat;
	double lng;
	WebView wb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		Bundle b = getIntent().getExtras();
		wb = (WebView) findViewById(R.id.webView1);

		String aas = b.getString("aas");
		String aas1 = b.getString("aas1");
		double a = Double.parseDouble(aas);
		double b1 = Double.parseDouble(aas1);
		appLocationService = new AppLocationService(MapActivity.this);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// Creating an empty criteria object
		Criteria criteria = new Criteria();

		Location nwLocation = appLocationService
				.getLocation(LocationManager.NETWORK_PROVIDER);

		if (nwLocation != null) {
			latitude2 = nwLocation.getLatitude();
			longitude2 = nwLocation.getLongitude();
			Toast.makeText(
					getApplicationContext(),
					"Mobile Location (NW): \nLatitude: " + latitude2
							+ "\nLongitude: " + longitude2, Toast.LENGTH_LONG)
					.show();
		} else {
			// showSettingsAlert("NETWORK");
		}
		if (provider != null && !provider.equals("")) {
			// Get the location from the given provider
			location = locationManager.getLastKnownLocation(provider);
			locationManager.requestLocationUpdates(provider, 20000, 1, this);

			if (location != null)
				onLocationChanged(location);
			else
				Toast.makeText(getBaseContext(), "Location can't be retrieved",
						Toast.LENGTH_SHORT).show();

		} else {
			Toast.makeText(getBaseContext(), "No Provider Found",
					Toast.LENGTH_SHORT).show();
		}
		String str_origin = latitude2 + "," + longitude2;
		String str_dest = a + "," + b1;
		wb.getSettings().setJavaScriptEnabled(true); // enable javascript

		final Activity activity = this;

		wb.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(activity, description, Toast.LENGTH_SHORT)
						.show();
			}
		});

		wb.loadUrl("http://maps.google.com/maps?saddr=" + str_origin
				+ "&daddr=" + str_dest + "");
		// Getting the name of the provider that meets the criteria

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_map, menu);
		return true;
	}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		lat = location.getLatitude();
		lng = location.getLongitude();
		Toast.makeText(getApplicationContext(), "" + lat + lng, 90).show();
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

}
