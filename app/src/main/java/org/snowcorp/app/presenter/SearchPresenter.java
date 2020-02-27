package org.snowcorp.app.presenter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import org.snowcorp.app.Interface.MovieListener;
import org.snowcorp.app.interactor.MovieInteractor;
import org.snowcorp.app.model.BookingMovieResult;
import org.snowcorp.app.model.MovieResult;
import org.snowcorp.app.utils.GlobalUtils;
import org.snowcorp.app.view.SearchActivityView;

import java.util.List;


public class SearchPresenter implements MovieListener {
    SearchActivityView view;
    Context context;
    MovieInteractor interactor;

    public SearchPresenter(SearchActivityView view, Context context) {
        this.view = view;
        this.context = context;
        this.interactor = new MovieInteractor();
    }


    public void searchItem(String searchText) {
        view.onLoading();
        interactor.getSearchItem(searchText, this);
    }

    public void getMovieDb() {
        view.onLoading();
        interactor.getMovieDb(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDataRecieved(List<MovieResult> movieList) {
        view.setAdapter(movieList);
    }

    @Override
    public void onReceived(List<BookingMovieResult> movieList) {

    }

    @Override
    public void onDataFailed(String message) {
        view.onFailed();
    }
}
