package com.example.MenuDemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/8/6.
 */
public class DummyFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";
    //该方法的返回值就是该Fragment显示的View组件

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
        //设置创建该Fragment时传入的从参数的Bundle
        Bundle bundle = getArguments();
        textView.setText(bundle.getInt(ARG_SECTION_NUMBER)+"");
        textView.setTextSize(30);
        return textView;
    }
}
