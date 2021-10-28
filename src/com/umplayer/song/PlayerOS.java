package com.umplayer.song;

import java.util.Scanner;

public class PlayerOS {
    private final String[] tab = {"歌单管理", "播放列表管理", "结束程序"};
    private final String[] tab_tip1 = {"歌单查询", "歌单添加", "歌单删除", "歌单展示", "返回上一级"};
    private final String[] tab_tip2 = {"歌曲查询", "歌曲添加", "歌曲删除", "歌曲展示","返回上一级"};

    /**
     * 页面菜单
     */
    public void myMenu(String[] tabs) {
        for (int i = 0; i < 20; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < tabs.length; i++) {
            System.out.format("\n%3d —— %-5s", i + 1, tabs[i]);

        }
        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.print("*");
        }
        System.out.println();

    }

    public PlayerOS() {
        OurPlayer ourPlayer = new OurPlayer();
        Scanner sc = new Scanner(System.in);
        int input;
        String str_input;
        while (true) {
            myMenu(this.tab);//主菜单
            input = sc.nextInt();
            if (input == this.tab.length) {
                break;
            }
            switch (input) {
                case 1:
                    //歌单管理
                    while (true) {
                        myMenu(tab_tip1);
                        input = sc.nextInt();
                        if (input == this.tab_tip1.length) {
                            break;
                        }
                        switch (input) {
                            case 1:
                                System.out.println("请输入需要查询的歌单名：");
                                str_input = sc.next();
                                ourPlayer.searchMyList(str_input);
                                break;
                            case 2:
                                System.out.println("请输入需要添加的歌单名：");
                                str_input = sc.next();
                                ourPlayer.addMyList(new MyPlayer(str_input));
                                break;
                            case 3:
                                System.out.println("请输入需要删除的歌单名：");
                                str_input = sc.next();
                                ourPlayer.removeMyList(str_input);
                                break;
                            case 4:
                                ourPlayer.showMyList();
                                break;
                            default:
                                System.out.println("请输入对应数字！");
                                break;
                        }
                    }
                    break;
                case 2:
                    //播放列表管理
                    System.out.println("请输入要管理的歌单名：");
                    str_input = sc.next();
                    if (!ourPlayer.getOurPlayerMap().containsKey(str_input)) {
                        System.out.println("无有效歌单！");
                        break;
                    } else {
                        System.out.println("开始管理 " + str_input + " 歌单！");
                    }
                    String str_song_input;
                    while (true) {
                        for (int i=0;i<20;i++){
                            System.out.print("*");
                        }
                        System.out.format("\t%-10s",str_input);
                        myMenu(tab_tip2);
                        input = sc.nextInt();
                        if (input == this.tab_tip2.length) {
                            break;
                        }
                        switch (input) {
                            case 1:
                                System.out.println("请输入要查询的歌曲（歌曲名称）");
                                str_song_input = sc.next();
                                ourPlayer.getOurPlayerMap().get(str_input).searchSong(str_song_input);
                                break;
                            case 2:
                                System.out.println("请输入待添加歌曲的歌曲编码");
                                String id = sc.next();
                                System.out.println("请输入待添加歌曲的歌曲名称");
                                String name = sc.next();
                                System.out.println("请输入待添加歌曲的歌曲歌手");
                                String author = sc.next();
                                ourPlayer.getOurPlayerMap().get(str_input).addToMyList(new MySong(id,name,author));
                                break;
                            case 3:
                                System.out.println("请输入要删除的歌曲（歌曲编码）");
                                str_song_input = sc.next();
                                ourPlayer.getOurPlayerMap().get(str_input).deleteMySong(str_song_input);
                                break;
                            case 4:
                                ourPlayer.getOurPlayerMap().get(str_input).showMyList();
                                break;
                            default:
                                System.out.println("请输入对应数字！");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("请输入对应数字！");
            }

        }


    }

}
