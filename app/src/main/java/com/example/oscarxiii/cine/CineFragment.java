package com.example.oscarxiii.cine;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class CineFragment extends Fragment {

    public CineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_cine, container, false);
        View rootView = inflater.inflate(R.layout.fragment_cine, container,false);
        //inflater.inflate(R.layout.fragment_cine, container, false);

        View lvPelis = rootView.findViewById(R.id.listaPelis);
        return rootView;
    }
}
