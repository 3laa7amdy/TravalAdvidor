package com.alaa7amdy.travaladvidor.Adapter.Images;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.alaa7amdy.travaladvidor.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {
    Context context;
    private LayoutInflater layoutInflater;
    private List<Uri> mUris;
    private List<String> mPaths;

    public SliderPagerAdapter(Context context, ArrayList<Uri> image_arraylist) {
        this.context = context;
        this.mUris = image_arraylist;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slider_home_layout, container, false);

        ImageView im_slider = view.findViewById(R.id.im_slider);
        Glide.with(context).load(mUris.get(position)).into(im_slider);

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return mUris.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    public void setData(List<Uri> uris, List<String> paths) {
        mUris = uris;
        mPaths = paths;
        notifyDataSetChanged();
    }

}