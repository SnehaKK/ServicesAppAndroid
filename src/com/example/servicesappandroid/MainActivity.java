package com.example.servicesappandroid;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	public final static String PDF_ACTIVITY = "com.example.servicesappandroid.PDF_ACTIVITY";
	public final static String IMAGE_ACTIVITY = "com.example.servicesappandroid.IMAGE_ACTIVITY";
	public final static String TEXT_ACTIVITY = "com.example.servicesappandroid.TEXT_ACTIVITY";
	
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void closeApp(View view)
	{
		finish(); System.exit(0);
	}
	
	public void pdfActivity(View view)
	{
	intent	= new Intent(this, PDFDownloadActivity.class);
	intent.putExtra(PDF_ACTIVITY, "Initiating PDF Download Activity");
	startActivity(intent);
	}

	public void imageActivity(View view)
	{
		intent	= new Intent(this, ImagedownloadActivity.class);
		intent.putExtra(IMAGE_ACTIVITY,  "Initiating Image Download Activity");
		startActivity(intent);
	}
	
	public void textActivity(View view)
	{
		intent	= new Intent(this, TextdownloadActivity.class);
		intent.putExtra(TEXT_ACTIVITY,  "Initiating Text Download Activity");
		startActivity(intent);
	}
}
