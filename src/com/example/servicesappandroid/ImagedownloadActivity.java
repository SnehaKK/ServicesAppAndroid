package com.example.servicesappandroid;

import java.util.ArrayList;

import com.example.servicesappandroid.PDFDownloadActivity.DownloadServiceConnection;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class ImagedownloadActivity extends Activity {

	ArrayList<String> listUrls;
	IDownloadService downloadService;
	DownloadServiceConnection conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagedownload);
		
		
		
		conn = new DownloadServiceConnection();
		Intent intent = new Intent("io.sneha.downloadFile");
		//intent.putStringArrayListExtra("urls", listUrls);
		bindService(intent, conn, Context.BIND_AUTO_CREATE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.imagedownload, menu);
		return true;
	}

	public void startDownload(View view) {
		System.out.println("Starting to Download Image Files!");
		listUrls = new ArrayList<String>();
		
	
		listUrls.add("http://www.sjsu.edu/future_students/pics/tower-hall-closeup.jpg");

				listUrls.add("http://www.sjsu.edu/employment/pics/career-center-01.jpg");

						listUrls.add("http://www.sjsu.edu/calendars/pics/calander.jpg");
				
				
		try {
			downloadService.image_download(listUrls);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}
	
	class DownloadServiceConnection implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			downloadService = IDownloadService.Stub.asInterface(service);
			
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			downloadService = null;
			
		}
		
	}
	
	protected void onDestroy() {
		super.onDestroy();
		unbindService(conn);
		downloadService = null;
	}
}
