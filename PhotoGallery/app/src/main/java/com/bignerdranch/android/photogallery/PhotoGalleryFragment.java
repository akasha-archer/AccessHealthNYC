package com.bignerdranch.android.photogallery;

/**
 * Created by akashaarcher on 1/29/18.
 */

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

public class PhotoGalleryFragment extends Fragment {

    private RecyclerView photoRecyclerView;
    public static final String TAG = "PhotoGalleryFragment";

    public static PhotoGalleryFragment newInstance() {
        return new PhotoGalleryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchItemsTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        photoRecyclerView = (RecyclerView) v.findViewById(R.id.photo_recycler_view);
        photoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        return v;
    }



    private class FetchItemsTask extends AsyncTask<Void, Void, Void> {

        public static final String TEST_URL = "https://www.bignerdranch.com";


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String result = new FlickrFetchr().getUrlString(TEST_URL);
                Log.i(TAG, "Fetched contents of:  " + result);
            } catch (IOException ioe) {
                Log.e(TAG, "Failed to fetch URL: ", ioe);
            }
            return null;
        }
    }

}
