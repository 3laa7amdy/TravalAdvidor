package com.alaa7amdy.travaladvidor;

import android.support.annotation.Nullable;
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
    private  final ArrayList<String> titles = new ArrayList<>();
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

    public void  addFragment(Fragment fragment ,String title){
        fragmentList.add(fragment);
        titles.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


}
