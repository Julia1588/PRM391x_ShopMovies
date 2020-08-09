package funix.prm.prm391x_shopmovies_ngantbfx02340funixeduvn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class Movie {
    private String title;
    private String imageUrl;
    private String price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String posterUrl) {
        this.imageUrl = posterUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }


    public static Movie fromJson(JSONObject jsonObject) {
        Movie b = new Movie();
        try {
            b.title = jsonObject.getString("title");
            b.imageUrl = jsonObject.getString("image");
            b.price = jsonObject.getString("price");

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return b;
    }

    public static ArrayList<Movie> fromJson(JSONArray jsonArray) {
        ArrayList<Movie> movies = new ArrayList<Movie>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject moviesJson = null;
            try {
                moviesJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Movie movie = Movie.fromJson(moviesJson);
            if (movie != null) {
                movies.add(movie);
            }
        }
        return movies;
    }
}
