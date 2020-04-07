package org.snowcorp.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.snowcorp.app.Interface.OnClickListerner;
import org.snowcorp.app.R;
import org.snowcorp.app.activity.ImageTrans_roundedcorner;
import org.snowcorp.app.model.BookingMovieResult;
import org.snowcorp.app.model.MovieResult;

import java.util.ArrayList;
import java.util.List;


public class MovieBookingAdapter extends RecyclerView.Adapter<MovieBookingAdapter.myViewHolder> {
    List<BookingMovieResult> movieList = new ArrayList<>();
    Context context;


    private final LayoutInflater inflater;

    public MovieBookingAdapter(Context context, List<BookingMovieResult> movieList) {
        inflater = LayoutInflater.from(context);
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.movie__booking_item, parent, false);
        myViewHolder holder = new myViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {

        BookingMovieResult item = (BookingMovieResult) movieList.get(position);

        String genre = "";
        holder.movieTitle.setText(item.getTitle());
        holder.releaseYear.setText(item.getDateTime());


    }


    @Override
    public int getItemCount() {

        return movieList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView movieTitle, genre, releaseYear, rating;


        public myViewHolder(View itemView) {

            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            releaseYear = (TextView) itemView.findViewById(R.id.releaseYear);
        }
    }
}
