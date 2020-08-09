package funix.prm.prm391x_shopmovies_ngantbfx02340funixeduvn;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView lvMovies;
    private MovieArrayAdapter adapterMovies;
    private MovieClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMovies = (ListView) findViewById(R.id.list);
        ArrayList<Movie> aMovies = new ArrayList<Movie>();
        adapterMovies = new MovieArrayAdapter(this, R.layout.list_view_movie, aMovies);
        getMovies();
        lvMovies.setAdapter(adapterMovies);

        Button btnMovie = (Button)findViewById(R.id.moviesBtn);
        btnMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "It works", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnProfile = (Button)findViewById(R.id.profileBtn);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Profile works", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMovies() {
        client = new MovieClient();
        client.getBoxOfficeMovies(new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, PreferenceActivity.Header[] headers, JSONObject responseBody) {
                JSONArray items = null;
                try {
                    // Get the movies json array
                    items = responseBody.getJSONArray("movies");
                    // Parse json array into array of model objects
                    ArrayList<Movie> movies = Movie.fromJson(items);
                    // Load model objects into the adapter
                    for (Movie movie : movies) {
                        adapterMovies.add(movie); // add movie through the adapter
                    }
                    adapterMovies.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}