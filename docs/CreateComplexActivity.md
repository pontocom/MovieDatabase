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
  
  
```
`

```java
```



[image-1]:	https://github.com/pontocom/MovieDatabase/blob/master/docs/images/Voila_Capture%202017-04-19_05-43-46_PM.png "Layout of the activity"