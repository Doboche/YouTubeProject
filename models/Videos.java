package fr.esilv.s8.tdnote.models;

import android.provider.MediaStore;

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Videos {

    @SerializedName("videos")
    private List<Video> videos;


    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}