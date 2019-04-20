package com.alaa7amdy.travaladvidor.Fragments.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaa7amdy.travaladvidor.Fragments.Home.Message.MessagesFragment;
import com.alaa7amdy.travaladvidor.R;

import static com.alaa7amdy.travaladvidor.MainActivity.bottom_navigation;


public class HomeActivityFragment extends Fragment {


    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_activity_home, container, false);
        setupViewPager();
        return view;

    }
    private void setupViewPager(){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());
        //adapter.addFragment(new CameraFragment()); //index 0
        adapter.addFragment(new HomeFragment()); //index 0
        adapter.addFragment(new MessagesFragment()); //index 1
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.container);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (viewPager.getCurrentItem()){
                    case 0:
                        bottom_navigation.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        bottom_navigation.setVisibility(View.GONE);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {


            }
        });
        viewPager.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (viewPager.getCurrentItem()){
                    case 0:
                        bottom_navigation.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        bottom_navigation.setVisibility(View.GONE);
                        break;
                }
                return true;
            }
        });



    }



}
