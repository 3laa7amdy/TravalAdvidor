package com.alaa7amdy.travaladvidor.Fragments.Search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.alaa7amdy.travaladvidor.Adapter.UserAdapter;
import com.alaa7amdy.travaladvidor.Fragments.Home.HomeFragment;
import com.alaa7amdy.travaladvidor.Fragments.Home.Message.MessagesFragment;
import com.alaa7amdy.travaladvidor.Model.Post;
import com.alaa7amdy.travaladvidor.Model.User;
import com.alaa7amdy.travaladvidor.R;
import com.alaa7amdy.travaladvidor.SectionsPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

import static com.alaa7amdy.travaladvidor.MainActivity.bottom_navigation;

public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList;

    TabLayout tabLayout;


    View view;

    EditText search_bar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);

        tabLayout = view.findViewById(R.id.tab_layout);

        setupViewPager();

        return view;
    }

    private void setupViewPager(){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new UserSearchFragment(), "Users"); //index 0
        adapter.addFragment(new PostSearchFragment(), "Posts"); //index 1
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//                switch (viewPager.getCurrentItem()){
//                    case 0:
//                        bottom_navigation.setVisibility(View.VISIBLE);
//                        break;
//                    case 1:
//                        bottom_navigation.setVisibility(View.GONE);
//                        break;
//                }
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//
//            }
//        });
//
//
//    }


    }

}
