package pt.iscte.daam.moviedatabase.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.ArrayList;

import pt.iscte.daam.moviedatabase.R;
import pt.iscte.daam.moviedatabase.model.Movie;

/**
 * Created by cserrao on 29/03/2017.
 */

public class MoviesAdapter extends ArrayAdapter<Movie> {
    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, 0, movies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get the movie data for this position
        Movie movie = getItem(position);
        // check if an existing view is being re-used, otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        }
        // Lookup view for data population
        TextView tvMovieName = (TextView) convertView.findViewById(R.id.tvMovieName);
        TextView tvMovieYear = (TextView) convertView.findViewById(R.id.tvMovieYear);
        ImageView ivMoviePoster = (ImageView) convertView.findViewById(R.id.ivMoviePoster);
        // populate the data into the template view using the data object
        tvMovieName.setText(movie.movieName);
        tvMovieYear.setText(movie.movieYear);
        Glide
                .with(getContext())
                .load(movie.moviePoster)
                .asBitmap()
                .into(new BitmapImageViewTarget(ivMoviePoster) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        super.onResourceReady(resource, glideAnimation);
                    }
                });
        //return the completed view to render the screen
        return convertView;
    }
}
