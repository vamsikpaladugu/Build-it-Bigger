package com.vamsi.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.vamsi.myapplication.backend.myApi.MyApi;
import com.vamsi.myapplication.backend.myApi.model.MyBean;

import java.io.IOException;

/**
 * Created by Vamsi Smart on 05-10-2016.
 */



 public class GCEPointsAsynTask extends AsyncTask<Void, Void, String> {

    private MyApi myApiService = null;
    Context context;

    //for testing
    private JsonGetTaskListener mListener = null;
    private Exception mError = null;

    public GCEPointsAsynTask(Context context) {

        this.context = context;
    }

    //for testing perpus
    public GCEPointsAsynTask(JsonGetTaskListener listener) {
        this.mListener = listener;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://maximal-coast-145518.appspot.com/_ah/api/");

            myApiService = builder.build();
        }


        MyBean bean = new MyBean();

        try {
            return myApiService.sayJoke(bean).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        if (this.mListener != null) {
            this.mListener.onComplete(result, mError);
        }else {
            ((MainActivity) context).start(result);
        }

    }


    //for testing purpose
    public interface JsonGetTaskListener {
        void onComplete(String jsonString, Exception e);
    }

}
