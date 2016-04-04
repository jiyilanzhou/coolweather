package com.example.FragmentTest;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2015/8/10.
 */
public class BookListFragment extends ListFragment {
    private Callbacks mCallbacks;

    //该Fragment将通过接口与它在的Activity交互
    public interface Callbacks {
        public void onItemSelected(Integer id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(), android.R.layout.simple_list_item_activated_1
                , android.R.id.text1, BookContent.items));

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //如果Activity没有实现CallBacks接口，抛出异常
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("bookListFragment所在的Activity必须实现CallBacks接口！");
        }
        //把该Activity当成CallBacks对象
        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    //当用户单击某列表项时激发该回调方法

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallbacks.onItemSelected(BookContent.items.get(position).id);
    }

    public void setActivateOnItemClick(boolean activateOnItemClick) {
        getListView().setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE :
                ListView.CHOICE_MODE_NONE);
    }
}
