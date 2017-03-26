package fr.esilv.s8.tdnote.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import fr.esilv.s8.tdnote.Constants;
import fr.esilv.s8.tdnote.R;
import fr.esilv.s8.tdnote.adapters.DetailsAdapter;
import fr.esilv.s8.tdnote.models.ItemVideo;
import fr.esilv.s8.tdnote.models.Items;
import fr.esilv.s8.tdnote.models.ItemsVideo;

/**
 * Created by Dorian on 21/03/2017.
 */

public class DetailsActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private static final String VIDEOS_URL = "https://www.googleapis.com/youtube/v3/videos?part=snippet&id=";
    private RecyclerView recyclerView;
    private String channelid;
    private static final String ITEM = "ITEM";
    private TextView description;
    private YouTubePlayerView youTubeView;
    private static final int RECOVERY_REQUEST = 1;

    public static void start(Context context, String channelid) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(ITEM, channelid);
        context.startActivity(intent);
        //System.out.println("ok");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        System.out.println("ok");
        channelid = getIntent().getStringExtra(ITEM);
        description = (TextView) findViewById(R.id.description);
        System.out.println(channelid);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Constants.API_KEY, this);
        getDetails();

    }

    private void getDetails() {
        StringRequest videosRequest = new StringRequest(VIDEOS_URL + channelid + "&key=" + Constants.API_KEY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Contracts as Java object
                //Videos videos = new Gson().fromJson(response, Videos.class);
                //List<Video> videos = (List<Video>) new Gson().fromJson(response, Video.class);
                ItemsVideo itemsVideo = new Gson().fromJson(response, ItemsVideo.class);
                System.out.println("ok");
                description.setText(itemsVideo.getItemsVideo().get(0).getSnippet().getDescription());
                //setAdapter(items);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Contracts", "Error");
            }
        });
        Volley.newRequestQueue(this).add(videosRequest);
    }

    private void setAdapter(Items items) {
        DetailsAdapter adapter = new DetailsAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo(channelid);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Constants.API_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubeView;
    }
}
