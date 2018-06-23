package com.parsa.myapp.IMDB_MVP;

import com.orm.SugarRecord;

/**
 * Created by hmd on 06/14/2018.
 */

public class IMDBPojoDatabase extends SugarRecord<IMDBPojoDatabase> {
    String title,director,poster,year;

    public IMDBPojoDatabase() {
    }

    public IMDBPojoDatabase(String title, String director, String poster, String year) {
        this.title = title;
        this.director = director;
        this.poster = poster;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
