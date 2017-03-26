package fr.esilv.s8.tdnote.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import fr.esilv.s8.tdnote.Constants;
import fr.esilv.s8.tdnote.R;
import fr.esilv.s8.tdnote.adapters.VideosAdapter;
import fr.esilv.s8.tdnote.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.tdnote.models.Item;
import fr.esilv.s8.tdnote.models.Items;

public class VideosActivity extends AppCompatActivity implements OnVideoSelectedListener{

    private static final String VIDEOS_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&maxResults=15&q=";
    private RecyclerView recyclerView;
    private EditText editText;
    private Button button;
    private String text;
    private String test;
    SharedPreferences.Editor editor;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        prefs = getPreferences(0);
        editor = prefs.edit();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        editText = (EditText) findViewById(R.id.message);
        button = (Button) findViewById(R.id.button_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = editText.getText().toString();
                text = text.replaceAll(" ", "+");
                editor.putString("save", text);
                editor.commit();
                test = prefs.getString("save",text);
                System.out.println("coucou" + test);
                getVideos();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //System.out.println("ok");
        //Log.i("info","ok");
        //getVideos();
    }

    private void getVideos() {
        System.out.println(text);
        StringRequest videosRequest = new StringRequest(VIDEOS_URL + text + "&key=" + Constants.API_KEY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Contracts as Java object
                //Videos videos = new Gson().fromJson(response, Videos.class);
                //List<Video> videos = (List<Video>) new Gson().fromJson(response, Video.class);
                Items items = new Gson().fromJson(response, Items.class);
                setAdapter(items);
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
        VideosAdapter adapter = new VideosAdapter(items);
        adapter.setOnVideoSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onVideoSelected(Item item) {
        //System.out.println(item.getId().getVideoId());
        DetailsActivity.start(this, item.getId().getVideoId());
    }

}
