package com.android.benben.library.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Time      2017/5/2 15:40 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class TabViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragmentArray;

    public TabViewPagerAdapter(FragmentManager mFragmentManager, Fragment[] fragmentArray) {
        super(mFragmentManager);
        this.fragmentArray = fragmentArray;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentArray[position];
    }

    @Override
    public int getCount() {
        return fragmentArray.length;
    }
}
