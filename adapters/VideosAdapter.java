package fr.esilv.s8.tdnote.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.esilv.s8.tdnote.R;
import fr.esilv.s8.tdnote.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.tdnote.models.Items;
import fr.esilv.s8.tdnote.models.Videos;
import fr.esilv.s8.tdnote.viewholders.VideosViewHolder;

/**
 * Created by Dorian on 17/03/2017.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosViewHolder> {

    private final Items items;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideosAdapter(Items items) {
        this.items = items;
    }

    @Override
    public VideosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video, parent, false);
        return new VideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideosViewHolder holder, int position) {
        holder.setOnVideoSelectedListener(onVideoSelectedListener);
        holder.bind(items.getItems().get(position));
    }

    //@Override
    public int getItemCount() {
       return items != null ? items.getItems().size() : 0;
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
