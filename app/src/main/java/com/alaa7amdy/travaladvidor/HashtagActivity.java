package com.alaa7amdy.travaladvidor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alaa7amdy.travaladvidor.Adapter.PostAdapter;
import com.alaa7amdy.travaladvidor.Adapter.UserAdapter;
import com.alaa7amdy.travaladvidor.Model.Post;
import com.alaa7amdy.travaladvidor.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HashtagActivity extends AppCompatActivity {

    String hashtag;


    RecyclerView recyclerView;
    PostAdapter hashtagAdapter;
    List<Post> hashtagList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hashtag);

        Intent intent = getIntent();
        hashtag = intent.getStringExtra("hashtag");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(hashtag);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        hashtagList = new ArrayList<>();
        hashtagAdapter = new PostAdapter(this, hashtagList);
        recyclerView.setAdapter(hashtagAdapter);

        getHashtag();


    }

    private void getHashtag() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                hashtagList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Post post = snapshot.getValue(Post.class);
                    if (post.getLinks() != null && post.getLinks().equals(hashtag) ){

                        hashtagList.add(post);
                    }

                }

                hashtagAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
