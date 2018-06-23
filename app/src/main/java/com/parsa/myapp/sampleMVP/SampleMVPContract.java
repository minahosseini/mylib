package com.parsa.myapp.sampleMVP;

public interface SampleMVPContract {

    interface View {
        void onAgeRecieved(int age);
    }

    interface Presenter {
        void attachView(View view);
        void recievedNameFamily(String name,String family);
        void onAgeRecieved(int age);
    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void getAgeByNameFamily(String name,String family);
    }
}
