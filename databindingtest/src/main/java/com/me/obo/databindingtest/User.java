package com.me.obo.databindingtest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by obo on 2017/4/9.
 * Email:obo.lin@dingtone.me
 */
public class User extends BaseObservable {
    private String name;
    private String password;
    private String edit;

    public User(String name, String password, String edit) {
        this.name = name;
        this.password = password;
        this.edit = edit;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
        notifyPropertyChanged(BR.edit);
    }
}
