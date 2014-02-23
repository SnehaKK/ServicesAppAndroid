/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/pwhome/Development/snehaProjects/ServicesAppAndroid/src/com/example/servicesappandroid/IDownloadService.aidl
 */
package com.example.servicesappandroid;
public interface IDownloadService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.servicesappandroid.IDownloadService
{
private static final java.lang.String DESCRIPTOR = "com.example.servicesappandroid.IDownloadService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.servicesappandroid.IDownloadService interface,
 * generating a proxy if needed.
 */
public static com.example.servicesappandroid.IDownloadService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.servicesappandroid.IDownloadService))) {
return ((com.example.servicesappandroid.IDownloadService)iin);
}
return new com.example.servicesappandroid.IDownloadService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_pdf_download:
{
data.enforceInterface(DESCRIPTOR);
java.util.List _arg0;
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_arg0 = data.readArrayList(cl);
this.pdf_download(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_text_download:
{
data.enforceInterface(DESCRIPTOR);
java.util.List _arg0;
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_arg0 = data.readArrayList(cl);
this.text_download(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_image_download:
{
data.enforceInterface(DESCRIPTOR);
java.util.List _arg0;
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_arg0 = data.readArrayList(cl);
this.image_download(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.servicesappandroid.IDownloadService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void pdf_download(java.util.List locations) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeList(locations);
mRemote.transact(Stub.TRANSACTION_pdf_download, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void text_download(java.util.List locations) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeList(locations);
mRemote.transact(Stub.TRANSACTION_text_download, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void image_download(java.util.List locations) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeList(locations);
mRemote.transact(Stub.TRANSACTION_image_download, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_pdf_download = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_text_download = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_image_download = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public void pdf_download(java.util.List locations) throws android.os.RemoteException;
public void text_download(java.util.List locations) throws android.os.RemoteException;
public void image_download(java.util.List locations) throws android.os.RemoteException;
}
