package com.ifi.kuirin.fragmentandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KuiRin on 8/31/2017 AD.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    List<Fragment> list = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();
        list.add(FragmentMenu.newInstance(0));
        list.add(FragmentMenu.newInstance(1));
        list.add(FragmentMenu.newInstance(2));
        list.add(FragmentMenu.newInstance(3));
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
