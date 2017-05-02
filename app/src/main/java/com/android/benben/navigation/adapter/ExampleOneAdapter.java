package com.android.benben.navigation.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.android.benben.library.adapter.BaseAdapter;
import com.android.benben.library.widget.AbsTab;
import com.android.benben.navigation.ExampleOneTab;

/**
 * Time      2017/5/2 15:58 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class ExampleOneAdapter extends BaseAdapter {

    private String[] mStrArray;

    public ExampleOneAdapter(Context context, Fragment[] fragments, FragmentManager fragmentManager, String[] strArray) {
        super(context, fragments, fragmentManager);

        mStrArray = strArray;
    }

    @Override
    public AbsTab getTab(int index) {
        ExampleOneTab tab = new ExampleOneTab(mContext, index);
        tab.setText(mStrArray[index]);
        return tab;
    }
}
