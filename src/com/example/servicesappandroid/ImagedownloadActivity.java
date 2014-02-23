package com.example.servicesappandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class ImagedownloadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagedownload);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.imagedownload, menu);
		return true;
	}
	public void startDownload(View view) {
		System.out.println("Starting to Download Image Files!");
	}
}
