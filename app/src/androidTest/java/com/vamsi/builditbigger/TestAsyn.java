package com.vamsi.builditbigger;

import android.support.test.annotation.UiThreadTest;
import android.util.Log;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vamsi Smart on 08-10-2016.
 */

public class TestAsyn extends TestCase implements GCEPointsAsynTask.JsonGetTaskListener {

    GCEPointsAsynTask downloader;
    CountDownLatch signal;
    String result = null;


    protected void setUp() throws Exception {
        super.setUp();

        signal = new CountDownLatch(1);
        downloader = new GCEPointsAsynTask(this);
    }

    @UiThreadTest
    public void testDownload() throws InterruptedException
    {
        downloader.execute();
        signal.await(30, TimeUnit.SECONDS);

        assertNotNull("result is null", result );
    }

    @Override
    public void onComplete(String jsonString, Exception e) {
        Log.v("jsonString",jsonString);

        result = jsonString;

        signal.countDown();

    }
}
