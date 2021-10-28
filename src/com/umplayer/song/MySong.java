package com.umplayer.song;

public class MySong {
    /**
     * 歌曲类
     * By U&M
     * id 歌曲ID
     * name 歌曲名称
     * author 歌曲作者
     */
    private String id;
    private String name;
    private String author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MySong(String id, String name, String author) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
    }

    /**
     * 歌曲判断
     * 注意ID唯一
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MySong song = (MySong) o;

        if (getId().equals(song.getId())) return true;
        if (!getName().equals(song.getName())) return false;
        return getAuthor().equals(song.getAuthor());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAuthor().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return
                "【 歌曲编码：" + id + '\t' +
                        "歌曲名称：" + name + '\t' +
                        "歌曲主唱：" + author + " 】";
    }

}
