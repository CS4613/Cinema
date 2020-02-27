package org.snowcorp.app.view;

import org.snowcorp.app.model.BookingMovieResult;
import org.snowcorp.app.model.Movie;
import org.snowcorp.app.model.MovieResult;

import java.util.List;


public interface MovieVIew {
    void onLoading();

    void onDataSuccess(List<MovieResult> movieList);

    void onSuccess(List<BookingMovieResult> movieList);

    void onFailed();
}

