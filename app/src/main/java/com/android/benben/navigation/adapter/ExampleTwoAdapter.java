package com.android.benben.navigation.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.android.benben.library.adapter.BaseAdapter;
import com.android.benben.library.widget.AbsTab;
import com.android.benben.navigation.ExampleTwoTab;

/**
 * Time      2017/5/2 15:58 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class ExampleTwoAdapter extends BaseAdapter {

    private int[][] mIconArray;

    public ExampleTwoAdapter(Context context, Fragment[]fragments, FragmentManager fragmentManager, int[][] iconArray) {
        super(context, fragments, fragmentManager);

        mIconArray = iconArray;
    }

    @Override
    public AbsTab getTab(int index) {
        ExampleTwoTab tab = new ExampleTwoTab(mContext, index);
        int[] iconArray = mIconArray[index];
        tab.setIcons(iconArray[0], iconArray[1]);
        return tab;
    }
}
