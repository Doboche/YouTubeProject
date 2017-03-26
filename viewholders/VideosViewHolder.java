package fr.esilv.s8.tdnote.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.esilv.s8.tdnote.R;
import fr.esilv.s8.tdnote.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.tdnote.models.Item;
import fr.esilv.s8.tdnote.models.Video;
import fr.esilv.s8.tdnote.models.Videos;

/**
 * Created by Dorian on 17/03/2017.
 */

public class VideosViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView author;
    //private TextView description;
    private TextView date;
    private ImageView thumbnail;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideosViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        author = (TextView) itemView.findViewById(R.id.author);
        //description = (TextView) itemView.findViewById(R.id.description);
        date = (TextView) itemView.findViewById(R.id.date);
        thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
    }

    public void bind(final Item item) {
        title.setText(item.getSnippet().getTitle());
        author.setText(item.getSnippet().getChannelTitle());
        //description.setText(item.getSnippet().getDescription());
        date.setText(item.getSnippet().getPublishedAt());
        Picasso.with(itemView.getContext()).load(item.getSnippet().getThumbnails().getDefaultt().getUrl()).into(thumbnail);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onVideoSelectedListener == null) {
                    return;
                }
                onVideoSelectedListener.onVideoSelected(item);
            }
        });
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }

}
