package com.studio231.android.simpletip.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.studio231.android.simpletip.R;
import com.studio231.android.simpletip.constant.C;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainFragment extends Fragment {

    @InjectView(R.id.button_cost)
    Button costButton;
    @InjectView(R.id.button_tip)
    Button tipButton;
    @InjectView(R.id.button_split)
    Button splitButton;

    OnOptionButtonSelectedListener optionButtonCallback;

    public interface OnOptionButtonSelectedListener {
        public void onOptionButtonSelected(int type);
    }

    public MainFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            optionButtonCallback = (OnOptionButtonSelectedListener) activity;
        } catch (ClassCastException e) {
            Log.d("Error", e.getLocalizedMessage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, rootView);

        bindListeners();

        return rootView;
    }

    private void bindListeners() {
        costButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionButtonCallback.onOptionButtonSelected(C.BUTTON_TYPE_COST);
            }
        });

        tipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionButtonCallback.onOptionButtonSelected(C.BUTTON_TYPE_TIP);
            }
        });

        splitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionButtonCallback.onOptionButtonSelected(C.BUTTON_TYPE_SPLIT);
            }
        });
    }
}
