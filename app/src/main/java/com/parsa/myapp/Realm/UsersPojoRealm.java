package com.parsa.myapp.Realm;

import io.realm.RealmObject;

/**
 * Created by hmd on 06/23/2018.
 */

public class UsersPojoRealm extends RealmObject {
    String name,family,mobile;
    int age;

    public UsersPojoRealm(String name, String family, String mobile, int age) {
        this.name = name;
        this.family = family;
        this.mobile = mobile;
        this.age = age;
    }

    public UsersPojoRealm() {
    }

    private UsersPojoRealm(Builder builder) {
        setName(builder.name);
        setFamily(builder.family);
        setMobile(builder.mobile);
        setAge(builder.age);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static final class Builder {
        private String name;
        private String family;
        private String mobile;
        private int age;

        private Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder family(String val) {
            family = val;
            return this;
        }

        public Builder mobile(String val) {
            mobile = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public UsersPojoRealm build() {
            return new UsersPojoRealm(this);
        }
    }
}
