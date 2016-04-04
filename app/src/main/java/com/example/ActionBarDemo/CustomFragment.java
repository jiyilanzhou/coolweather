package com.example.ActionBarDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/8/6.
 */
public class CustomFragment extends Fragment {
    public static final String ARG_CUSTOM_NUMBER = "custom_number";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
        Bundle bundle = getArguments();
        textView.setText(bundle.getInt(ARG_CUSTOM_NUMBER)+"");
        textView.setTextSize(30);
        return textView;
    }
}
