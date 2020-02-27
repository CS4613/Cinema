package org.snowcorp.app.view;

import org.snowcorp.app.model.MovieDetails;
import org.snowcorp.app.model.ReviewResult;

import java.util.List;

public interface MovieDetialView {

    void onLoading();

    void onSuccess(String message);

    void setAdapter(List<ReviewResult> reviewList);

    void setMovie(MovieDetails movie);

    void onFailed(String message);

}
