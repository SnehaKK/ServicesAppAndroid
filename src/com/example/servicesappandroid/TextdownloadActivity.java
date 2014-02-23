package com.example.servicesappandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class TextdownloadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textdownload);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.textdownload, menu);
		return true;
	}
	public void startDownload(View view) {
		System.out.println("Starting to Download Text Files!");
	}
}
