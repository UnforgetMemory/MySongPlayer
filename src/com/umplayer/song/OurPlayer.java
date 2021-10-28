package com.umplayer.song;

import java.util.HashMap;
import java.util.Map;

public class OurPlayer {
    /**
     * 播放列表合集
     * ourPlayerMap 存储列表
     */
    private Map<String, MyPlayer> ourPlayerMap;

    public Map<String, MyPlayer> getOurPlayerMap() {
        if (this.ourPlayerMap == null) {
            this.setOurPlayerMap(new HashMap<>());
        }
        return ourPlayerMap;
    }

    public void setOurPlayerMap(Map<String, MyPlayer> ourPlayerMap) {
        this.ourPlayerMap = ourPlayerMap;
    }

    public OurPlayer() {

    }

    /**
     * 向播放列表集合中添加新列表
     */
    public void addMyList(MyPlayer myPlayer) {
        if (!this.getOurPlayerMap().containsKey(myPlayer.getList_name())) {
            this.getOurPlayerMap().put(myPlayer.getList_name(), myPlayer);
            System.out.println("歌单 " + myPlayer.getList_name() + " 添加成功");
        } else {
            System.out.println("已存在 " + myPlayer.getList_name() + " 请勿重复添加");
        }

    }

    /**
     * 删除播放列表集合中的列表，按列表名删除
     */
    public void removeMyList(String list_name) {
        try {
            if(this.getOurPlayerMap().isEmpty()||!this.getOurPlayerMap().containsKey(list_name)){
                System.out.println("无有效歌单或无此歌单！");
            }
            else {
                this.getOurPlayerMap().remove(list_name);
                System.out.println("歌单 " + list_name + " 已删除");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 搜索列表
     * 按列表名称搜索
     */
    public void searchMyList(String my_list_name) {
        try {
            if (this.getOurPlayerMap().isEmpty()) {
                System.out.println("无有效歌单！");
            } else {
                for (Map.Entry<String, MyPlayer> entry : this.getOurPlayerMap().entrySet()) {
                    if (entry.getKey().equals(my_list_name)) {
                        System.out.println("已找到 " + my_list_name);
                        return;
                    }
                }
                System.out.println("我们与 " + my_list_name + " 失去了联系");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    /**
     * 展示集合里所有列表歌曲
     */
    public void showMyList() {
        if (this.getOurPlayerMap().isEmpty()) {
            System.out.println("无有效歌单！");
        } else {
            for (Map.Entry<String, MyPlayer> entry : this.getOurPlayerMap().entrySet()) {
                entry.getValue().showMyList();
            }
        }
    }

}
