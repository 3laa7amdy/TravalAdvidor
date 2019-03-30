package com.alaa7amdy.travaladvidor.Fragments.Home.Message;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alaa7amdy.travaladvidor.Adapter.UserChatAdapter;
import com.alaa7amdy.travaladvidor.Model.Chat;
import com.alaa7amdy.travaladvidor.Model.User;
import com.alaa7amdy.travaladvidor.Model.UserChat;
import com.alaa7amdy.travaladvidor.R;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Context.MODE_PRIVATE;


public class MessagesFragment extends Fragment {

    CircleImageView profile_image;
    TextView username;
    FirebaseUser firebaseUser;

    ViewPager viewPager;

    TabLayout tabLayout;

    private int[] tabIcons = {
            R.drawable.ic_tac_chat,
            R.drawable.ic_liked,
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messages, container, false);


        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");

        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);


        profile_image = view.findViewById(R.id.imagepro);
        username = view.findViewById(R.id.username);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        userInfo();

        getData();

        return view;

    }


    private void userInfo() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (getContext() == null) {
                    return;
                }

                User user = dataSnapshot.getValue(User.class);


                Picasso.get().load(user.getImageurl()).into(profile_image);

                //Glide.with(context).load("https://images.pexels.com/photos/2040406/pexels-photo-2040406.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940").into(profile_image);

                username.setText(user.getUsername());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



     private void getData(){
         DatabaseReference reference =FirebaseDatabase.getInstance().getReference("Chats");
         reference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange (@NonNull DataSnapshot dataSnapshot){
                 ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
                 int unread = 0;
                 for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                     Chat chat = snapshot.getValue(Chat.class);
                     if (chat.getReceiver().equals(firebaseUser.getUid()) && !chat.isIsseen()) {
                         unread++;
                     }
                 }

                 if (unread == 0) {
                     viewPagerAdapter.addFragment(new ChatsFragment(), "Chats");
                 } else {
                     viewPagerAdapter.addFragment(new ChatsFragment(), "(" + unread + ") Chats");
                 }

                 viewPagerAdapter.addFragment(new FrindesFragment(), "Friends");

                 viewPager.setAdapter(viewPagerAdapter);
                 tabLayout.setupWithViewPager(viewPager);
                 tabLayout.getTabAt(0).setIcon(tabIcons[0]);
                 tabLayout.getTabAt(1).setIcon(tabIcons[1]);
                 //tabLayout.getTabAt(2).setIcon(tabIcons[2]);


             }

             @Override
             public void onCancelled (@NonNull DatabaseError databaseError){

             }
         });
     }


}








class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;

    ViewPagerAdapter(FragmentManager fm){
        super(fm);
        this.fragments = new ArrayList<>();
        this.titles = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment, String title){
        fragments.add(fragment);
        titles.add(title);
    }

    // Ctrl + O

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}

