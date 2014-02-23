package com.example.servicesappandroid;

import java.util.ArrayList;

import com.example.servicesappandroid.ImagedownloadActivity.DownloadServiceConnection;

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

public class TextdownloadActivity extends Activity {

	ArrayList<String> listUrls;
	IDownloadService downloadService;
	DownloadServiceConnection conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textdownload);

		conn = new DownloadServiceConnection();
		Intent intent = new Intent("io.sneha.downloadFile");
		// intent.putStringArrayListExtra("urls", listUrls);
		bindService(intent, conn, Context.BIND_AUTO_CREATE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.textdownload, menu);
		return true;
	}

	public void startDownload(View view) {
		System.out.println("Starting to Download Text Files!");
		listUrls = new ArrayList<String>();
		listUrls.add("http://cs.sjsu.edu/~austin/cs166-fall13/lab4/passwords.txt");
		listUrls.add("http://www.engr.sjsu.edu/lwesley/teaching/ENGR297B/ExamAnswers/redo_quiz1_answer.txt");
		listUrls.add("http://www.sjsu.edu/robots.txt");
		listUrls.add("http://cs.sjsu.edu/~austin/cs166-fall13/lab11.txt");
		listUrls.add("http://cs.sjsu.edu/~mak/archive/CS146-Summer2013/lectures/CountSortOutput.txt");
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
}
