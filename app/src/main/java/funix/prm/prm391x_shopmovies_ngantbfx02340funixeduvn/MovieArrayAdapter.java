package funix.prm.prm391x_shopmovies_ngantbfx02340funixeduvn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


class MovieArrayAdapter extends ArrayAdapter<Movie> {
    private Context context;
    private ArrayList<Movie> arrayList;
    public MovieArrayAdapter(Context context, int resource, ArrayList<Movie> aMovies) {
        super(context, resource, aMovies);
        this.context = context;
        this.arrayList = aMovies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(context);
        v = inflater.inflate(R.layout.list_view_movie, parent, false);
        Movie movie = getItem(position);
        TextView title = (TextView) convertView.findViewById(R.id.titleMovie);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageMovie);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        title.setText(movie.getTitle());
        price.setText(movie.getPrice());
        Picasso.with(getContext()).load(movie.getImageUrl()).into(image);
        return convertView;
    }
}
