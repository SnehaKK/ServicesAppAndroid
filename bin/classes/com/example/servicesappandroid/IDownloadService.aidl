package com.example.servicesappandroid;

interface IDownloadService {

void pdf_download(in List locations);
void text_download(in List locations);
void image_download(in List locations);

}
