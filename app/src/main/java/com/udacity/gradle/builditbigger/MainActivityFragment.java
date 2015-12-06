package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.javajokeslib.JavaJokes;
import com.sai.androidjokeslibrary.EndpointsAsyncTask;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.Callback {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        getActivity().setTitle(R.string.paid_app_title);

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
        sendIntent(JavaJokes.getJoke(), com.sai.androidjokeslibrary.MainActivity.class);
    }


    public void tellJoke(View view) {
        new EndpointsAsyncTask(this).execute(getActivity());

//        sendIntent(JavaJokes.getJoke(), com.sai.androidjokeslibrary.MainActivity.class);
//        Toast.makeText(this, JavaJokes.getJoke(), Toast.LENGTH_SHORT).show();
    }

    private void sendIntent(String joke, Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtra(com.sai.androidjokeslibrary.MainActivity.JOKE_TXT_INTENT_ID, joke);
        startActivity(intent);
    }


}
