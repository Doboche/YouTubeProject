package fr.esilv.s8.tdnote.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dorian on 20/03/2017.
 */

public class Id {
    @SerializedName("kind")
    private String kind;
    @SerializedName("videoId")
    private String videoId;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
