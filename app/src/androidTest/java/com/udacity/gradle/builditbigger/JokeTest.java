package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;


import com.sai.androidjokeslibrary.EndpointsAsyncTask;

import java.util.concurrent.ExecutionException;

/**
 * Created by smajeti on 12/2/15.
 */
public class JokeTest extends AndroidTestCase {

    private String joke = null;

    public void testGetJoke() {
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(null);
        asyncTask.execute(mContext);
        try {
            joke = asyncTask.get();
        } catch (InterruptedException e) {
            joke = null;
            e.printStackTrace();
        } catch (ExecutionException e) {
            joke = null;
            e.printStackTrace();
        }
        assertNotNull(joke);
    }


}
