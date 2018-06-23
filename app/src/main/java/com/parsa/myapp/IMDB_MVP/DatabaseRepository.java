package com.parsa.myapp.IMDB_MVP;

import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;
import java.util.List;

/**
 * Created by hmd on 06/14/2018.
 */

public class DatabaseRepository implements ModelRepository.Database {
    private Model model;

    @Override
    public void attachModel(Model model) {
        this.model = model;
    }

    @Override
    public void getData(String word) {
        List<IMDBPojoDatabase> movies = IMDBPojoDatabase.find(IMDBPojoDatabase.class, "title like ?", word);
        IMDBPojo pojo=new IMDBPojo();
        pojo.setTitle(movies.get(0).getTitle());
        pojo.setDirector(movies.get(0).getDirector());
        pojo.setPoster(movies.get(0).getPoster());
        pojo.setYear(movies.get(0).getYear());
        if (movies != null)
            model.onReceivedData(pojo,RepoType.Database);
        else
            model.onFailed(word,RepoType.Database);
    }

    @Override
    public void saveDataToDB(IMDBPojo pojo) {
        IMDBPojoDatabase db = new IMDBPojoDatabase();
        db.setDirector(pojo.getDirector());
        db.setPoster(pojo.getPoster());
        db.setTitle(pojo.getTitle());
        db.setYear(pojo.getYear());
        db.save();
    }
}
