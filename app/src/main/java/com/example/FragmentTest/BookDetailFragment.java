package com.example.FragmentTest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hoperun.myapplication.R;

/**
 * Created by Administrator on 2015/8/10.
 */
public class BookDetailFragment extends Fragment {
    public static final String ITEM_ID = "item_id";
    //保存该Fragment显示的Book对象
    BookContent.Book book;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ITEM_ID)) {
            //getArguments().getInt(ITEM_ID)显示id
            book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_book_detail, container, false);
        if (book != null) {

            ((TextView) root.findViewById(R.id.book_title)).setText(book.title);
            ((TextView) root.findViewById(R.id.book_desc)).setText(book.desc);
        }
        return root;
    }
}
