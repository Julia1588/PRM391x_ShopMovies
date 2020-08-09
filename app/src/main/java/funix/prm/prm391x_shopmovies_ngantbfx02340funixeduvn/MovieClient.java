package funix.prm.prm391x_shopmovies_ngantbfx02340funixeduvn;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MovieClient {
    private final String API_KEY = "...getkey...";
    private final String url = "https://api.androidhive.info/json/movies_2017.json";
    private AsyncHttpClient client;

    public MovieClient() {
        this.client = new AsyncHttpClient();
    }

    public void getBoxOfficeMovies(JsonHttpResponseHandler handler) {
        RequestParams params = new RequestParams("apikey", API_KEY);
        client.get(url, params, handler);
    }
}
