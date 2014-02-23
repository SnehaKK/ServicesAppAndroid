package com.example.servicesappandroid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;
import android.view.View;

public class PDFDownloadActivity extends Activity {
	ArrayList<String> listUrls;
	IDownloadService downloadService;
	DownloadServiceConnection conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pdfdownload);
		
		
		
		conn = new DownloadServiceConnection();
		Intent intent = new Intent("io.sneha.downloadFile");
		//intent.putStringArrayListExtra("urls", listUrls);
		bindService(intent, conn, Context.BIND_AUTO_CREATE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pdfdownload, menu);
		return true;
	}

	public void startDownload(View view) {
		System.out.println("Starting to Download PDF Files!");
		listUrls = new ArrayList<String>();
		
		listUrls.add("http://www.sjsu.edu/gradstudies/docs/thesis_guidelines.pdf");
		listUrls.add("http://www.engr.sjsu.edu/sishim/CMPE295A_S06_Green1.pdf");
		listUrls.add("http://www.sjsu.edu/facultyaffairs/docs/CoENG_CompEngineering_CloudComputing_JOID%2022682_rev_7-22-2013.pdf");
		listUrls.add("http://www.engr.sjsu.edu/nikos/courses/AE160/pdf/AeroBook.pdf");
		listUrls.add("http://blogs.sjsu.edu/mathadvising/files/2013/02/Career-Center-EXPO-13-Final-Job-Fair-Publication-1vd6gzz.pdf");
		try {
			downloadService.pdf_download(listUrls);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//Here we need to call a service and let it download all the pdf files in the background. 
		// Notes on services :
		// A sevices state is controlled by intents. 
		// When an activity needs your service it will invoke it through an intent. 
		// An already running service can redeive the start message repeatidly and at unexpected times. 
		//Bound service - AIDL
		// Un-bound service - where the lifecycle of the service is not bound to the activity that starts them. 
		
		
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
