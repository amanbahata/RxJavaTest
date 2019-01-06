package com.aman1.rxjavatest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatsModel {

    @SerializedName("file")
    @Expose
    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
