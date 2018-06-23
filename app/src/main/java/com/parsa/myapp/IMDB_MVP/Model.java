package com.parsa.myapp.IMDB_MVP;

import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;


//todo
//fixme

public class Model implements IMDBMVPContract.Model {
    private IMDBMVPContract.Presenter presenter;
    RestRepository restRepository = new RestRepository();
    DatabaseRepository databaseRepository = new DatabaseRepository();

    @Override
    public void attachPresenter(IMDBMVPContract.Presenter presenter) {
        this.presenter = presenter;
        restRepository.attachModel(this);
        databaseRepository.attachModel(this);
    }

    @Override
    public void search(String word) {
        databaseRepository.getData(word);
    }

    @Override
    public void onReceivedData(IMDBPojo imdb, RepoType type) {
        if (type == RepoType.Rest) {
            databaseRepository.saveDataToDB(imdb);
            presenter.onSuccessSearch(imdb);
        } else if (type == RepoType.Database) {
            presenter.onSuccessSearch(imdb);
        }
    }

    @Override
    public void onFailed(String word,RepoType type) {
        if (type == RepoType.Rest) {
            presenter.onFail("error in webservice call");
        } else if (type == RepoType.Database) {
            restRepository.getData(word);
        }
    }

}
