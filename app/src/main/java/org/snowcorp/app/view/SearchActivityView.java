package org.snowcorp.app.view;

import org.snowcorp.app.model.MovieResult;

import java.util.List;

public interface SearchActivityView {
    void onLoading();
    void setAdapter(List<MovieResult> movieList);
    void onFailed();
}
