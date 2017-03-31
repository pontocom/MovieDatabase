package pt.iscte.daam.moviedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import pt.iscte.daam.moviedatabase.adapters.MyRecyclerViewAdapter;
import pt.iscte.daam.moviedatabase.model.Movie;

public class TestActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i("APP--->", " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<Movie> getDataSet() {
        ArrayList results = new ArrayList<Movie>();
        for (int index = 0; index < 20; index++) {
            Movie obj = new Movie("Some Primary Text " + index,
                    "Secondary " + index,
                    "Third" + index,
                    "Fourth" + index);
            results.add(index, obj);
        }
        return results;
    }
}
