package fr.esilv.s8.tdnote.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dorian on 20/03/2017.
 */

public class Items {
    @SerializedName("items")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
