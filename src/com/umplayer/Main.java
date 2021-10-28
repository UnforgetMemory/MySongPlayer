package com.umplayer;

import com.umplayer.song.MyPlayer;
import com.umplayer.song.MySong;
import com.umplayer.song.OurPlayer;
import com.umplayer.song.PlayerOS;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /*MySong song = new MySong("SD001", "忘情水", "刘德华");
        MySong song1 = new MySong("SD002", "十七岁", "刘德华");
        MySong song3 = new MySong("SD004", "小幸运", "田馥甄");
        MySong song2 = new MySong("SD003", "练习", "刘德华");

        MyPlayer palyer = new MyPlayer("常听歌单");
        MyPlayer palyer2=new MyPlayer("粤语金曲");
        *//*System.out.println(song);
        System.out.println(song1);
        System.out.println(song.equals(song1));*//*
        palyer.addToMyList(song);
        palyer.addToMyList(song1);
        palyer.addToMyList(song2);
        palyer.addToMyList(song3);
        palyer2.addToMyList(palyer.getMySongList().get(0));
        palyer2.addToMyList(palyer.getMySongList().get(1));
        palyer2.addToMyList(palyer.getMySongList().get(2));
        palyer2.addToMyList(palyer.getMySongList().get(3));

        *//*palyer.showMyList();
        palyer.searchSong("忘情水");
        palyer.searchSong("十七岁");*//*
        OurPlayer opr = new OurPlayer();
        opr.addMyList(palyer);
        opr.addMyList(palyer2);
        opr.showMyList();
        opr.searchMyList("常听歌单");
        opr.removeMyList(palyer);
        opr.searchMyList("常听歌单");
        opr.showMyList();
        OurPlayer opr1 = new OurPlayer();
        opr1.showMyList();*/
        PlayerOS p1=new PlayerOS();

    }
}
