package com.example.eventplanning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter
{

    ArrayList<Details> images;
    LayoutInflater inflater;
    Context context;

    public MyAdapter(Context context, ArrayList<Details> images)
    {
        this.images = images;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View v = inflater.inflate(R.layout.slide,container,false);
        ImageView myImage = (ImageView) v.findViewById(R.id.image);

         Details obj= images.get(position);

        Picasso.with(context).load(obj.getUrl()).into(myImage);

        //  myImage.setImageResource(images.get(position));
        container.addView(v,0);
        return v;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view.equals(object);
    }
}
