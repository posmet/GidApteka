package com.pharma.posmet.gidapteka;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    private Context context = null;

    public MyAdapter(Context context, FragmentManager mgr) {
        super(mgr);
        this.context = context;
    }

    @Override
    public int getCount() {
        return (4);
    }

    @Override
    public Fragment getItem(int position) {
        return (PageFragment.newInstance(position));
    }

    @Override
    public String getPageTitle(int position) {
        //String str = position==1 ? getResources().getString(R.string.page1):(position==2?getResources().getString(R.string.page2):(position==3?getResources().getString(R.string.page3):getResources().getString(R.string.page4)));
        return (PageFragment.getTitle(context, position));
    }
}