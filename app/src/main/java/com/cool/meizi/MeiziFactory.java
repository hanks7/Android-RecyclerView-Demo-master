package com.cool.meizi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MeiziFactory {

    private static String[] imageUrls = {
        "https://upload-images.jianshu.io/upload_images/11181600-db48df38b76ed467.jpg",
        "https://upload-images.jianshu.io/upload_images/11181600-f9cc67a96b58d49e.jpg",
        "https://upload-images.jianshu.io/upload_images/11181600-4860ecb6acb8fce5.jpg",
        "https://upload-images.jianshu.io/upload_images/11181600-a5db9d1018924867.jpg",
        "https://upload-images.jianshu.io/upload_images/11181600-d2131192b602b425.jpg",
        "https://upload-images.jianshu.io/upload_images/11181600-e3002c837b5335f9.jpg",
        "https://upload-images.jianshu.io/upload_images/11181600-2ddfaaa766a399e5.jpg",
        "https://upload-images.jianshu.io/upload_images/11181600-d58b814b598ea3d3.jpg",
        "https://upload-images.jianshu.io/upload_images/11181600-8e2e151505cf6899.jpg",
        "https://upload-images.jianshu.io/upload_images/11181600-a535283f3402accb.jpg"
    };

    private static String[] titles = {
        "I'm the most beautiful girl in the world! Do you agree?",
        "I'm Olivia. Long time no see, do you miss me?",
        "Sophia here! I need more boyfriends! More money!",
        "Did you watch my new movie? You can't miss it.",
        "Hi there! I miss you so much, call me PLEASE!",
        "Here's Hannah from Japan. Do you wanna be my guy?",
        "Hi! My name is Emma, I have a lot of boyfriends!",
        "Hey man! I just wanna tell you, I love you! :)",
        "Please be my boyfriend! I need you sooooo much!",
        "I'm Sofia, I'm just a very shy girl. Do you like me?"
    };

    private static String[] names = {
        "Emma", "Olivia", "Sophia", "Isabella", "Elizabeth",
        "Charlotte", "Hannah", "Emily", "Harper", "Sofia"
    };

    public static List<Meizi> createMeizis(int num) {
        Random rand = new Random();
        List<Meizi> meizis = new ArrayList<>();
        int arySize = imageUrls.length;
        for (int i = 0; i < num; i++) {
            int a = i % arySize;
            String url = imageUrls[a];
            String title = titles[a];
            String name = names[a];
            int favorites = rand.nextInt(10000);
            int comments = rand.nextInt(10000);
            meizis.add(new Meizi(url, title, name, favorites, comments));
        }
        return meizis;
    }
}
