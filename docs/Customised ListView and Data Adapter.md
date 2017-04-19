# Customised ListView and Data Adapter
Tradicional ListViews hold and item per line, typically a String. In this example we want to have a ListView that on each line is composed by the poster of the movie, the name of the movie and the year it was released.

![][image-1]

## Create layout for the item on the Listview
We have to create a new layout file that will contain the layout of each item that will appear on the ListView lines. Let’s call it, for instance, `item_movie.xml`.

This what it look like:

![][image-2]

The XML source-code for this layout [is here][1].

## Create specific adapter for the ListView
Since we don’t have “_out of the box_” an specific adapter that is capable of taking a `Movie` object and map it directly to the layout, we need to create one.

### Create a specific Movie adapter
Create a new class `MoviesAdapter` and extend the `ArrayAdapter` class of `Movie` -\> `ArrayAdapter<Movie>`.

```java
public class MoviesAdapter extends ArrayAdapter<Movie> {
    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, 0, movies);
    }
}
``` 

Next override the `getView` method that will be used to fill the values that each of the items of the ListView will have to contain.

```java
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
```


[1]:	https://github.com/pontocom/MovieDatabase/blob/master/app/src/main/res/layout/item_movie.xml

[image-1]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/images/Voila_Capture%202017-04-19_07-40-38_PM.png "Item of the ListView"
[image-2]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/images/Voila_Capture%202017-04-19_07-45-39_PM.png "Layout format"