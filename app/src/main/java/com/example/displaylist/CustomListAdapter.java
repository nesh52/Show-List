package com.example.displaylist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Post> {
    ArrayList<Post> posts;
    Context context;
    int resource;

    public CustomListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Post> posts) {
        super(context, resource, posts);
        this.posts = posts;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.list_item, null, true);
        }

        Post post = getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        Picasso.with(MainActivity.context).load(post.getPhotoUrl()).into(imageView);

        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(post.getName() + "\n" + post.getMessage());

        return convertView;
    }
}
