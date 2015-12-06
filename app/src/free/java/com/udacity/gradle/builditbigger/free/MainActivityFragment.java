package com.udacity.gradle.builditbigger.free;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.sai.androidjokeslibrary.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.Callback {


    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        getActivity().setTitle(R.string.free_app_title);

        Button button = (Button) root.findViewById(R.id.joke_btn_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke(view);
            }
        });

        return root;
    }

    @Override
    public void deliverJoke(String joke) {
        //Toast.makeText(getActivity(), joke, Toast.LENGTH_LONG).show();
        sendIntent(joke, com.sai.androidjokeslibrary.MainActivity.class);
    }


    public void tellJoke(View view) {
        new EndpointsAsyncTask(this).execute(getActivity());
    }

    private void sendIntent(String joke, Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtra(com.sai.androidjokeslibrary.MainActivity.JOKE_TXT_INTENT_ID, joke);
        startActivity(intent);
    }


}
