package com.example.displaylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Posts {

    List<Post> posts;

    public Posts() {
        this.posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        Set<Integer> uID = new HashSet<>();
        List<Post> uPosts = new ArrayList<>();

        for(Post p : this.posts) {
            if(uID.add(p.getId())) {
                uPosts.add(p);
            }
        }
        return uPosts;
    }
}
