package com.parsa.myapp.IMDB_MVP;

import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;

/**
 * Created by hmd on 06/14/2018.
 */

public interface ModelRepository {
    interface Rest {
        void attachModel(Model model);
        void getData(String word);
    }

    interface Database {
        void attachModel(Model model);
        void getData(String word);
        void saveDataToDB(IMDBPojo pojo);
    }
}
