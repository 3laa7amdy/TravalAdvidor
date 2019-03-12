package com.alaa7amdy.travaladvidor;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alaa7amdy.travaladvidor.Adapter.Images.GifSizeFilter;
import com.alaa7amdy.travaladvidor.Adapter.Images.Glide4Engine;
import com.alaa7amdy.travaladvidor.Adapter.Images.SliderPagerAdapter;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.CaptureStrategy;
import com.zhihu.matisse.listener.OnCheckedListener;
import com.zhihu.matisse.listener.OnSelectedListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CHOOSE = 23;

    SliderPagerAdapter sliderPagerAdapter;
    ArrayList<Uri> slider_image_list ;
    private ViewPager images_slider;
    private LinearLayout pages_dots;
    private TextView[] dots;


    StorageReference storageRef;

    ImageView close;
    TextView post;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        close = findViewById(R.id.close);
        post = findViewById(R.id.post);
        description = findViewById(R.id.description);

        pages_dots = findViewById(R.id.image_page_dots);
        images_slider = (ViewPager)findViewById(R.id.image_page_slider);
        slider_image_list =  new ArrayList<Uri>();
        sliderPagerAdapter = new SliderPagerAdapter(this, slider_image_list);
        images_slider.setAdapter(sliderPagerAdapter);

        images_slider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        storageRef = FirebaseStorage.getInstance().getReference("posts");

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PostActivity.this, MainActivity.class));
                finish();
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //uploadImage_10();
                up();


            }
        });


        Matisse.from(PostActivity.this)
                .choose(MimeType.ofAll(), false)
                .countable(true)
                .capture(true)
                .captureStrategy(
                        new CaptureStrategy(true, "com.zhihu.matisse.sample.fileprovider","test"))
                .maxSelectable(10)
                .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                .gridExpectedSize(
                        getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                .thumbnailScale(0.85f)
//                                            .imageEngine(new GlideEngine())  // for glide-V3
                .imageEngine(new Glide4Engine())    // for glide-V4
                .setOnSelectedListener(new OnSelectedListener() {
                    @Override
                    public void onSelected(
                            @NonNull List<Uri> uriList, @NonNull List<String> pathList) {
                        // DO SOMETHING IMMEDIATELY HERE
                        Log.e("onSelected", "onSelected: pathList=" + pathList);

                    }
                })
                .originalEnable(true)
                .maxOriginalSize(10)
                .autoHideToolbarOnSingleTap(true)
                .setOnCheckedListener(new OnCheckedListener() {
                    @Override
                    public void onCheck(boolean isChecked) {
                        // DO SOMETHING IMMEDIATELY HERE
                        Log.e("isChecked", "onCheck: isChecked=" + isChecked);
                    }
                })
                .forResult(REQUEST_CODE_CHOOSE);
    }

    private void up (){

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Posting");
        pd.show();

        StorageReference filepath = FirebaseStorage.getInstance().getReference().child("posts");

        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");

        final String postid = reference.push().getKey();
        HashMap<String, Object> hashMap = new HashMap<>();
        for (int i = 0 ; i < slider_image_list.size(); i++) {
            hashMap.put("postimage"+i+"","");

        }

        hashMap.put("postid", postid);
        hashMap.put("imagesNr","" + slider_image_list.size());
        hashMap.put("publisher", FirebaseAuth.getInstance().getCurrentUser().getUid());
        hashMap.put("description", description.getText().toString());

        reference.child(postid).setValue(hashMap);

        for (int i = 0 ; i < slider_image_list.size(); i++){

            final int finalI = i;
            filepath.child(slider_image_list.get(i).getLastPathSegment()).putFile(slider_image_list.get(i)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadURL = taskSnapshot.getDownloadUrl();
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("postimage"+ finalI +"",downloadURL.toString() );
                    reference.child(postid).updateChildren(map);
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(PostActivity.this, "Failed "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

        }
        pd.dismiss();

        startActivity(new Intent(PostActivity.this, MainActivity.class));
        finish();
    }

    public void addBottomDots(int currentPage) {
        //slider_image_list =
        dots = new TextView[slider_image_list.size()];

        pages_dots.removeAllViews();
        pages_dots.setPadding(0, 0, 0, 20);
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#9f9f9f")); // un selected
            pages_dots.addView(dots[i]);
        }

        if (dots.length >0)
            dots[currentPage].setTextColor(Color.parseColor("#2f383a")); // selected
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {

            sliderPagerAdapter.setData(Matisse.obtainResult(data), Matisse.obtainPathResult(data)) ;



            slider_image_list = (ArrayList<Uri>) Matisse.obtainResult(data);
            //mSelected
            Log.d("Matisse", "mSelected: " + slider_image_list);
            sliderPagerAdapter.notifyDataSetChanged();

            addBottomDots(0);

        }else {
            Toast.makeText(this, "Something gone wrong!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(PostActivity.this, MainActivity.class));
            finish();
        }
    }
}
