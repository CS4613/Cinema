package org.snowcorp.app.Interface;

import org.snowcorp.app.model.BookingMovieResult;
import org.snowcorp.app.model.Movie;
import org.snowcorp.app.model.MovieResult;

import java.util.List;


public interface MovieListener {
    void onDataRecieved(List<MovieResult> movieList);

    void onReceived(List<BookingMovieResult> movieList);

    void onDataFailed(String message);
}
