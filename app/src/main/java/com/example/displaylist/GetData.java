package com.example.displaylist;

import android.os.AsyncTask;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GetData extends AsyncTask<Void, Void, Void> {
    Posts posts = null;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://jsonstub.com/feed");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("JsonStub-User-Key", "a6504fb9-780f-483e-9021-19135c3cfc97");
            connection.setRequestProperty("JsonStub-Project-Key", "58df32c7-1d41-4932-8f00-d2d4a61ae791");

            InputStream inputStream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            Gson gson = new Gson();
            posts = gson.fromJson(reader, Posts.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

        @Override
    protected void onPostExecute(Void aVoid) {

           CustomListAdapter c =  new CustomListAdapter(MainActivity.context, R.layout.list_item, (ArrayList<Post>) posts.getPosts());
           MainActivity.listView.setAdapter(c);

    }
}
