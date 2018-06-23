package com.parsa.myapp.sampleMVP;

public class SampleMVPModel  implements SampleMVPContract.Model{
    SampleMVPContract.Presenter presenter;

    @Override
    public void attachPresenter(SampleMVPContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void getAgeByNameFamily(String name, String family) {
        if (name.equalsIgnoreCase("ali")&& family.equalsIgnoreCase("hosseini"))
            presenter.onAgeRecieved(10);
        else
            presenter.onAgeRecieved(30);

    }
}
