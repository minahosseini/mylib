package com.parsa.myapp.sampleMVP;

public class SampleMVPPresenter implements SampleMVPContract.Presenter {
    SampleMVPModel model;
    SampleMVPContract.View view;

    public SampleMVPPresenter() {
       model=new SampleMVPModel();
       model.attachPresenter(this);
    }


    @Override
    public void attachView(SampleMVPContract.View view) {
        this.view=view;
    }

    @Override
    public void recievedNameFamily(String name, String family) {
        model.getAgeByNameFamily(name,family);
    }

    @Override
    public void onAgeRecieved(int age) {
        view.onAgeRecieved(age);
    }
}
