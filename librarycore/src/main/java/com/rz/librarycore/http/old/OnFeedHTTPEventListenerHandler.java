package com.rz.librarycore.http.old;

/**
 * Created by Rz Rasel on 2017-11-25.
 */

public interface OnFeedHTTPEventListenerHandler {
    /*public void onPreExecute();

    public Object doInBackground(Object... argURLParams);

    public void onPostExecute(Object argResult);

    public void onProgressUpdate(Integer... argProgressValue);

    public void onCancelled();*/
    public void onPreExecute();

    public Object doInBackground(String... argURLParams);

    public void onPostExecute(Object argResult);

    public void onProgressUpdate(Integer... argProgressValue);

    public void onCancelled();
}
