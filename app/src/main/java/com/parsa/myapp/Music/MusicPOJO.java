package com.parsa.myapp.Music;

import com.orm.SugarRecord;

/**
 * Created by hmd on 06/16/2018.
 */

public class MusicPOJO extends SugarRecord<MusicPOJO> {
    public String title, album, singer, cover, url;
    public int percent;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public MusicPOJO() {
        //super be constructor sugar record eshare mikone
        super();
    }

    public MusicPOJO(String title, String album, String singer, String cover, String url) {
        //super be constructor sugar record eshare mikone
        super();
        this.title = title;
        this.album = album;
        this.singer = singer;
        this.cover = cover;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private MusicPOJO(Builder builder) {
        setTitle(builder.title);
        setAlbum(builder.album);
        setSinger(builder.singer);
        setCover(builder.cover);
        setUrl(builder.url);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String title;
        private String album;
        private String singer;
        private String cover;
        private String url;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder album(String val) {
            album = val;
            return this;
        }

        public Builder singer(String val) {
            singer = val;
            return this;
        }

        public Builder cover(String val) {
            cover = val;
            return this;
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public MusicPOJO build() {
            return new MusicPOJO(this);
        }
    }

    @Override
    public String toString() {
        return "MusicPOJO{" +
                "title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", singer='" + singer + '\'' +
                ", cover='" + cover + '\'' +
                ", url='" + url + '\'' +
                ", id=" + id +
                '}';
    }
}
