package com.parsa.myapp.RXSamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.parsa.myapp.R;
import com.parsa.myapp.utils.BaseActivity;
import com.parsa.myapp.utils.PublicMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class RXActivity extends BaseActivity {

    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        txt = findViewById(R.id.txt);

       /* List<String> names = ObservablesSamples.getNamesFromDB("");
        Observable.fromIterable(names)
                .debounce(2000, TimeUnit.MILLISECONDS)
                .distinct()
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return "my name is "+s;
                    }
                }).subscribe(this::onSuccess,this::onError,this::onFinish);*/


        //be jaye in ravesh behtar ast az RX (raveshe zir) estefade konim
       /*txt.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               PublicMethods.showToast(mContext,charSequence.toString());
           }

           @Override
           public void afterTextChanged(Editable editable) {

           }
       });*/

        RxTextView.textChanges(txt)
                .debounce(1000,TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CharSequence>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CharSequence charSequence) {
                PublicMethods.showToast(mContext, charSequence.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }

    private void onFinish() {
    }

    private void onError(Throwable throwable) {
    }

    private void onSuccess(String s) {
    }
}
