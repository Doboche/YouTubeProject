package fr.esilv.s8.tdnote.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import fr.esilv.s8.tdnote.R;
import fr.esilv.s8.tdnote.models.Item;

/**
 * Created by Dorian on 21/03/2017.
 */

public class DetailsViewHolder extends RecyclerView.ViewHolder {
    private TextView description;

    public DetailsViewHolder(View itemView) {
        super(itemView);
        description = (TextView) itemView.findViewById(R.id.description);
    }

    public void bind(final Item item) {
        description.setText(item.getSnippet().getDescription());
    }
}
