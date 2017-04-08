package pt.iscte.daam.moviedatabase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pt.iscte.daam.moviedatabase.adapters.MoviesAdapter;
import pt.iscte.daam.moviedatabase.model.Movie;

public class MovieDetailsActivity extends AppCompatActivity {

    protected TextView moviename, movieyear, movieplot, moviedirector, moviewriter, movieactors;
    protected ImageView movieposter;
    protected String imdbid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        moviename = (TextView) findViewById(R.id.tvMovieName);
        movieyear = (TextView) findViewById(R.id.tvMovieYear);
        movieplot = (TextView) findViewById(R.id.tvMovieDescription);
        movieposter = (ImageView) findViewById(R.id.ivMoviePoster);
        moviedirector = (TextView) findViewById(R.id.tvMovieDirector);
        moviewriter = (TextView) findViewById(R.id.tvMovieWriter);
        movieactors = (TextView) findViewById(R.id.tvMovieActors);

        Intent intent = getIntent();
        moviename.setText(intent.getStringExtra("MOVIENAME"));
        movieyear.setText(intent.getStringExtra("MOVIEYEAR"));
        imdbid = intent.getStringExtra("MOVIEIMDBID");


        Glide
                .with(MovieDetailsActivity.this)
                .load(intent.getStringExtra("MOVIEPOSTER"))
                .asBitmap()
                .into(new BitmapImageViewTarget(movieposter) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        super.onResourceReady(resource, glideAnimation);

                    }
                });

        // get further details from the service

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.omdbapi.com/?i=" + imdbid,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("MovieDatabase", response);


                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            if(jsonObject.getString("Response").compareTo("True") == 0) {
                                movieplot.setText(jsonObject.getString("Plot"));
                                movieactors.setText(jsonObject.getString("Actors"));
                                moviedirector.setText(jsonObject.getString("Director"));
                                moviewriter.setText(jsonObject.getString("Writer"));

                            } else {
                                Toast.makeText(MovieDetailsActivity.this, "Some error occured while getting movies information!", Toast.LENGTH_SHORT).show();
                            }


                        } catch (Exception e) {
                            Log.i("MoviesDatabase", "Error processing the JSON answer -> " + e.getMessage());
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("MovieDatabase", error.toString());
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
