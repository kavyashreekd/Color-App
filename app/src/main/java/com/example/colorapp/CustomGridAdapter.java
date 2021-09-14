package com.example.colorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Random;

public class CustomGridAdapter extends BaseAdapter {
    Context context;
    int logos[];
    LayoutInflater inflter;

    public CustomGridAdapter(Context applicationContext, int[] logos) {
        this.context = applicationContext;
        this.logos = logos;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return logos.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_gridview, null);
        View grid;
        TextView tv_color = (TextView) view.findViewById(R.id.tv_color);
       // tv_color.setBackgroundColor(R.drawable.text_border);
        tv_color.setBackgroundColor((R.drawable.text_border));

        return view;
    }
}
