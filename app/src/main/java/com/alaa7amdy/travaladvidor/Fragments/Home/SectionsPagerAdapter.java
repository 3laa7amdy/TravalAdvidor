package com.alaa7amdy.travaladvidor.Fragments.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
/*
* this class for store fragment for tab
* */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList=new ArrayList<>();
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int postion) {
        return fragmentList.get(postion);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    public void  addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }
}
