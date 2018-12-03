package com.parsa.myapp.Realm;

import android.widget.TextView;

import com.parsa.myapp.R;
import com.parsa.myapp.customViews.CustomEditText;
import com.parsa.myapp.utils.BaseActivity;
import com.parsa.myapp.utils.PublicMethods;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.activity_realm_user)
public class RealmUserActivity extends BaseActivity {
    @ViewById
    CustomEditText name;
    @ViewById
    CustomEditText family;
    @ViewById
    CustomEditText age;
    @ViewById
    CustomEditText mobile;
    @ViewById
    TextView result;

    @Click
    void save() {
        UsersPojoRealm user = UsersPojoRealm.newBuilder()
                .age(Integer.parseInt(age.text()))
                .name(name.text())
                .family(family.text())
                .mobile(mobile.text())
                .build();

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(user);
        realm.commitTransaction();

        PublicMethods.showToast(mContext, "New user has been saved.");
        clean();
    }

    @Click
    void read() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<UsersPojoRealm> users = realm
                .where(UsersPojoRealm.class)
                .contains("name", "mir")
                .findAll();

        for (UsersPojoRealm user : users) {
            result.append(user.getName() + " " + user.getFamily() + "\n");
        }
    }

    private void clean() {
        age.setText("");
        name.setText("");
        family.setText("");
        mobile.setText("");
    }
}
