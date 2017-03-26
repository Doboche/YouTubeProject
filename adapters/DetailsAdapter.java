package fr.esilv.s8.tdnote.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.esilv.s8.tdnote.R;
import fr.esilv.s8.tdnote.models.Items;
import fr.esilv.s8.tdnote.viewholders.DetailsViewHolder;

/**
 * Created by Dorian on 21/03/2017.
 */

public class DetailsAdapter extends RecyclerView.Adapter<DetailsViewHolder> {
    private final Items items;


    public DetailsAdapter(Items items) {
        this.items = items;
    }

    @Override
    public DetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_detail, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailsViewHolder holder, int position) {
        holder.bind(items.getItems().get(position));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.getItems().size() : 0;
    }

}
