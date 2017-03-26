package fr.esilv.s8.tdnote.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dorian on 20/03/2017.
 */

public class Thumbnails {
    @SerializedName("default")
    private Default defaultt;
    @SerializedName("medium")
    private Default medium;
    @SerializedName("high")
    private Default high;

    public Default getDefaultt() {
        return defaultt;
    }

    public void setDefaultt(Default defaultt) {
        this.defaultt = defaultt;
    }

    public Default getMedium() {
        return medium;
    }

    public void setMedium(Default medium) {
        this.medium = medium;
    }

    public Default getHigh() {
        return high;
    }

    public void setHigh(Default high) {
        this.high = high;
    }
}
