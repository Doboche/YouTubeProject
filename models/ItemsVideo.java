package fr.esilv.s8.tdnote.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dorian on 22/03/2017.
 */

public class ItemsVideo {
    @SerializedName("items")
    private List<ItemVideo> itemsVideo;

    public List<ItemVideo> getItemsVideo() {
        return itemsVideo;
    }

    public void setItemsVideo(List<ItemVideo> itemsVideo) {
        this.itemsVideo = itemsVideo;
    }
}
