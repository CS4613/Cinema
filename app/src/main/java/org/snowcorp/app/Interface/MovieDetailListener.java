package org.snowcorp.app.Interface;

import org.snowcorp.app.model.MovieDetails;


public interface MovieDetailListener {
    void onDataRecieved(MovieDetails movie);

    void onDataFailed(String message);
}
