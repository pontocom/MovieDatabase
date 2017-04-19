package pt.iscte.daam.moviedatabase.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class MyRecyclerViewAdapter extends RecyclerView
    .Adapter<MyRecyclerViewAdapter.DataObjectHolder>
{
    private ArrayList<Movie> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView moviename;
        TextView movieyear;
        ImageView movieposter;

        public DataObjectHolder(View itemView) {
            super(itemView);
            moviename = (TextView) itemView.findViewById(R.id.movie_name);
            movieyear = (TextView) itemView.findViewById(R.id.movie_year);
            movieposter = (ImageView) itemView.findViewById(R.id.movie_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(ArrayList<Movie> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_row, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.moviename.setText(mDataset.get(position).movieName);
        holder.movieyear.setText(mDataset.get(position).movieYear);
        Glide
                .with(holder.itemView.getContext())
                .load(mDataset.get(position).moviePoster)
                .asBitmap()
                .into(new BitmapImageViewTarget(holder.movieposter) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        super.onResourceReady(resource, glideAnimation);
                    }
                });
    }

    public void addItem(Movie dataObject, int index) {
        mDataset.add(index, dataObject);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}
