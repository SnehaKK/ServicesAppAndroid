package com.example.servicesappandroid;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class SJSUDownloadService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		return new IDownloadService.Stub(){

			@Override
			public void pdf_download(List locations) throws RemoteException {
				downloadPDF(locations);
			}

			@Override
			public void text_download(List locations) throws RemoteException {
				downloadTextFiles(locations);				
			}

			@Override
			public void image_download(List locations) throws RemoteException {
				downloadImages(locations);				
			}
			
		};
	}
	
	

	
	
	
	private int downloadPDF(List locations){
		ArrayList<String> Urls = (ArrayList<String>) locations;
		

		//Now download the files present in the locations array list. 
		//For example lets download this file in our SDCard
		//String loc = "http://www.sjsu.edu/gradstudies/docs/thesis_guidelines.pdf";
		
		
		
		
		//DownloadAsyncTask downloadTask = new DownloadAsyncTask();
		
	
		
		for(int i = 0; i < Urls.size(); i++) {
		
			String temp [] = Urls.get(i).split("/");
			Log.i("SJSUDownloadSevice", "Downloading File " +  temp[temp.length-1]);
			
			
		
			    new DownloadAsyncTask().execute(Urls.get(i), temp[temp.length-1]);
			
		
		
		}
		//downloadFile(loc,"thesis_guidelines.pdf");

		
		
		System.out.println("All PDF Files downloaded");
		return 1;
	}

	private int downloadImages(List locations){
ArrayList<String> Urls = (ArrayList<String>) locations;
		

		//Now download the files present in the locations array list. 
		//For example lets download this file in our SDCard
		//String loc = "http://www.sjsu.edu/gradstudies/docs/thesis_guidelines.pdf";
		
		
		
		
		//DownloadAsyncTask downloadTask = new DownloadAsyncTask();
		
	
		
		for(int i = 0; i < Urls.size(); i++) {
		
			String temp [] = Urls.get(i).split("/");
			Log.i("SJSUDownloadSevice", "Downloading File " +  temp[temp.length-1]);
			
			
		
			    new DownloadAsyncTask().execute(Urls.get(i), temp[temp.length-1]);
			
		
		
		}
		//downloadFile(loc,"thesis_guidelines.pdf");

		
	
		
		System.out.println("All image files downloaded");
		return 1;
	}
	
	private int downloadTextFiles(List locations){
ArrayList<String> Urls = (ArrayList<String>) locations;
		

		//Now download the files present in the locations array list. 
		//For example lets download this file in our SDCard
		//String loc = "http://www.sjsu.edu/gradstudies/docs/thesis_guidelines.pdf";
		
		
		
		
		//DownloadAsyncTask downloadTask = new DownloadAsyncTask();
		
	
		
		for(int i = 0; i < Urls.size(); i++) {
		
			String temp [] = Urls.get(i).split("/");
			Log.i("SJSUDownloadSevice", "Downloading File " +  temp[temp.length-1]);
			
			
		
			    new DownloadAsyncTask().execute(Urls.get(i), temp[temp.length-1]);
			
		
		
		}
		//downloadFile(loc,"thesis_guidelines.pdf");

		
		
		System.out.println("All Text Files downloaded");
		return 1;
	}
	
	
	private class DownloadAsyncTask extends AsyncTask<String, Void, byte[]> {

		@Override
		protected byte[] doInBackground(String... arg) {
			
			downloadFile(arg[0],arg[1]);
			return null;
		}
		
		private boolean downloadFile(String loc, String fileName) {
			   try {
				    
				         String root = android.os.Environment.getExternalStorageDirectory().getAbsolutePath(); //Get Devices External Storage
				      // String root = getApplicationContext().getFilesDir().getAbsolutePath();

				    //File root = android.os.Environment.getDataDirectory();
				    //Get the file from the server. 
					HttpURLConnection con = (HttpURLConnection) ( new URL(loc)).openConnection();
					con.setRequestMethod("GET");
					con.connect();
					
					//First verify if the file exists. 
					int respCode = con.getResponseCode();
					if(respCode != 200) {
						Log.e("SJSUDownloadService", "File Not Present : " + loc);
						return false;
					}
					//Now create the new file in the SDCard. 
					File dir = new File (root + "/sjsuDownloads");
				    dir.mkdirs();
				    File file = new File(dir,fileName);
				    //file.createNewFile();
				    FileOutputStream fio = new FileOutputStream(file);
				    


			        InputStream is = con.getInputStream();
			        byte[] b = new byte[1024];
			        while ( is.read(b) != -1) {
			        	fio.write(b);
			        }
			        	        con.disconnect();
			        	        is.close();
			        	        fio.close();
			        	        
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			   return true;
			
		}
		
		
	}

	
	
	
}
