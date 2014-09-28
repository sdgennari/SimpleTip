package com.studio231.android.simpletip.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studio231.android.simpletip.R;

public class NumpadFragment extends Fragment {

    public NumpadFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_numpad, container, false);
        return rootView;
    }
}
