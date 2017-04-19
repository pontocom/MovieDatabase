# Create the Activity to hold the complex ListView
Add a new Empty Activity to the project. The name of the Activity can be anything, but for coherence sake, let’s name it `MainActivity`.

## Layout of this new activity
The layout of this new activity will be the following:

![][image-1]

Then it is necessary to connect the views on the layout to variables on the class.

```java
public class MainActivity extends AppCompatActivity {
    protected EditText searchMovie;
    protected ListView resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchMovie = (EditText) findViewById(R.id.searchMovie);
        resultList = (ListView) findViewById(R.id.movieList);

    }
`

## Implement the Search function
Implement the search functionality that will enable the user to search for a movie on the web API.

### Create a function to be called by the Search Button
Create a function inside the `MainActivity` to handle the user search button click.

```java
public void clickSearchButton(View v) {
}
```

It is also important on the layout file to add the attribute corresponding to the `onClick` event:

```xml
android:onClick="clickSearchButton"/>
```

### Create the query for the search
Create the query to search the movie on the remote service, based on the selection made by the user. This is done inside the `clickSearchButton` function.

```java
	public void clickSearchButton(View v) {
        String query;
        query = searchMovie.getText().toString();
        searchMovie.setText("");

        String queryEncoded ="";

        try {
            queryEncoded = URLEncoder.encode(query, "utf-8");
        } catch (Exception e) {
            Log.i("MovieDatabase", "Wrong encoding " + e.getMessage());
        }
}
```

### Make the request to the service
Using Volley, make a request to the service. 

```java
		StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.omdbapi.com/?s=" + queryEncoded,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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
```

### Handle the answer from the service
Receive the answer from the service and list the results.

```java
public void onResponse(String response) {
                        Log.i("MovieDatabase", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            if(jsonObject.getString("Response").compareTo("True") == 0) {
                                JSONArray listMovies = jsonObject.getJSONArray("Search");
 
                            } else {
                                Toast.makeText(MainActivity.this, "Some error occured while getting movies information!", Toast.LENGTH_SHORT).show();
                            }


                        } catch (Exception e) {
                            Log.i("GuideMeApp", "Error processing the JSON answer -> " + e.getMessage());
                            e.printStackTrace();
                        }

                    }
```

We need to create a classe variable that will contain the results obtained from the search in the format of the Model `Movie` we have created.

```java
protected ArrayList<Movie> arrayOfMovies;
```

After this we process the JSON results and place all the information inside the list of objects we have previously created.

```java
arrayOfMovies = new ArrayList<Movie>();

                                for(int i = 0; i < listMovies.length(); i++) {
                                    JSONObject jmovie = listMovies.getJSONObject(i);
                                    Log.i("MovieDatabase", jmovie.getString("Title"));
                                    arrayOfMovies.add(i, new Movie(jmovie.getString("Title"), jmovie.getString("Year"), jmovie.getString("imdbID"), jmovie.getString("Poster")));
                                }
```

Finally we need to place this list of results to the ListView, but for that we need to create a specific adapter. The `ArrayAdapter` we’ve used on the simple version of the search cannot be used, because it can handle only an element per list item, on the ListView. We need to create our own specific adapter.

This is what we are going to do on the next step - create a customised ListView and develop an customised data adapter.

[image-1]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/images/Voila_Capture%202017-04-19_05-43-46_PM.png "Layout of the activity"