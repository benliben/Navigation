package com.android.benben.library.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.android.benben.library.widget.AbsTab;
import com.android.benben.library.widget.DefaultTab;

/**
 * Time      2017/5/2 15:40 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class DefaultAdapter extends BaseAdapter {

    private String[] mTextArray;
    private int mTextColor = Color.BLACK, mSelectedTextColor;
    private int[] mIconImageArray;
    private int[] mSelectedIconImageArray;

    public DefaultAdapter(Context context, Fragment[] fragmentArray, FragmentManager fragmentManager, String[] textArray, int selectTextColor,
                          int[] iconImageArray, int[] selectedIconImageArray) {
        super(context, fragmentArray, fragmentManager);

        mTextArray = textArray;
        mSelectedTextColor = selectTextColor;
        mIconImageArray = iconImageArray;
        mSelectedIconImageArray = selectedIconImageArray;
    }


    @Override
    public AbsTab getTab(int index) {
        DefaultTab defaultTab = new DefaultTab(mContext, index);
        defaultTab.setText(mTextArray[index]);
        defaultTab.setTextColor(mTextColor, mSelectedTextColor);
        defaultTab.setIconImage(mIconImageArray[index], mSelectedIconImageArray[index]);
        return defaultTab;
    }
}
