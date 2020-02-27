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
import org.snowcorp.app.model.MovieResult;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.myViewHolder> {
    List<MovieResult> movieList = new ArrayList<>();
    Context context;
    OnClickListerner listerner;


    private final LayoutInflater inflater;

    public MovieAdapter(Context context, List<MovieResult> movieList, final OnClickListerner listerner) {
        inflater = LayoutInflater.from(context);
        this.movieList = movieList;
        this.context = context;
        this.listerner = listerner;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.movie_item, parent, false);
        myViewHolder holder = new myViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {

        MovieResult item = (MovieResult) movieList.get(position);

        String genre = "";
        holder.movieTitle.setText(item.getTitle());

        Picasso.with(context).load("https://image.tmdb.org/t/p/w500/" + item.getPosterPath()).transform(new ImageTrans_roundedcorner()).into(holder.imageView);
        holder.genre.setText(genre);
        holder.releaseYear.setText(String.valueOf(item.getReleaseDate()));
        holder.rating.setText("Rating: " + String.valueOf(item.getVoteAverage()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listerner.onClick(position);
            }
        });
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
            imageView = (ImageView) itemView.findViewById(R.id.thumbnail);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            genre = (TextView) itemView.findViewById(R.id.genre);
            releaseYear = (TextView) itemView.findViewById(R.id.releaseYear);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
