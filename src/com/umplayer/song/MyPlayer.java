package com.umplayer.song;

import java.util.ArrayList;
import java.util.List;

public class MyPlayer {
    /**
     * 播放器类
     * list_name 列表名
     * mySongList 存储歌曲列表
     */
    private String list_name;
    private List<MySong> mySongList;

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public List<MySong> getMySongList() {
        if (this.mySongList == null) {
            this.setMySongList(new ArrayList<>());
        }
        return mySongList;
    }

    public void setMySongList(List<MySong> mySongList) {
        this.mySongList = mySongList;
    }

    public MyPlayer(String list_name) {
        this.setList_name(list_name);
    }

    /**
     * 往列表添加歌曲
     */
    public void addToMyList(MySong mysong) {
        boolean isSameSong = false;
        for (MySong song : this.getMySongList()) {
            if (mysong.equals(song)) {
                isSameSong = true;
                break;
            }
        }
        if (isSameSong) {
            System.out.println("重复添加！注意ID唯一性或同歌曲同歌手。");
        } else {
            this.getMySongList().add(mysong);
            System.out.println("添加成功！" + mysong + " 现已加入 " + this.getList_name());
        }

    }

    /**
     * 通过歌名查询
     */
    public void searchSong(String song_name) {
        List<MySong> searchList = new ArrayList<>();
        boolean flag = true;
        for (MySong song : this.getMySongList()) {
            if (song.getName().equals(song_name)) {
                searchList.add(song);
                flag = false;
            }
        }
        if (flag) {
            System.out.println("抱歉！此列表不包含此歌曲，请添加。");

        } else {
            System.out.println("搜索到以下同名歌曲：");
            for (MySong song : searchList) {
                System.out.println(song);
            }
        }
    }
    /**
     * 删除歌曲
     * 通过歌曲编码唯一ID删除
     */
    public void deleteMySong(String id){
        for (MySong song:this.getMySongList()){
            if(song.getId().equals(id)){
                this.getMySongList().remove(song);
                System.out.println(song+" 已被移出！");
                return;
            }
        }
        System.out.println("无效歌曲编码！");
    }

    /**
     * 列表展示
     */
    public void showMyList() {
        System.out.println("\t" + this.getList_name() + "\n{");
        int count = 0;
        for (MySong song : this.getMySongList()) {
            System.out.println(song);
            count++;
        }
        System.out.println("} 共计 " + count + " 首歌");
    }

}
