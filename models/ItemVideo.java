package fr.esilv.s8.tdnote.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dorian on 22/03/2017.
 */

public class ItemVideo {
    @SerializedName("kind")
    private String kind;
    @SerializedName("etag")
    private String etag;
    @SerializedName("id")
    private String id;
    @SerializedName("snippet")
    private Snippet snippet;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public Snippet getSnippet() {
        return snippet;
    }
}
