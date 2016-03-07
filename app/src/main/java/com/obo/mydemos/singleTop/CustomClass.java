package com.obo.mydemos.singleTop;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by obo on 15/10/23.
 */
public class CustomClass implements Parcelable {

    public String result = "this is my object";
    public CustomClass(String result){this.result = result;};

    protected CustomClass(Parcel in) {
        result = in.readString();
    }

    public static final Creator<CustomClass> CREATOR = new Creator<CustomClass>() {
        @Override
        public CustomClass createFromParcel(Parcel in) {
            return new CustomClass(in);
        }

        @Override
        public CustomClass[] newArray(int size) {
            return new CustomClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(result);
    }
}
