package org.snowcorp.app.presenter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import org.snowcorp.app.Interface.MovieListener;
import org.snowcorp.app.interactor.MovieInteractor;
import org.snowcorp.app.model.BookingMovieResult;
import org.snowcorp.app.model.MovieResult;
import org.snowcorp.app.utils.GlobalUtils;
import org.snowcorp.app.view.MovieVIew;

import java.util.List;


public class MoviePresenter implements MovieListener {
    MovieVIew view;
    Context context;
    MovieInteractor interactor;

    public MoviePresenter(MovieVIew view, Context context) {
        this.view = view;
        this.context = context;
        this.interactor = new MovieInteractor();
    }

    public void getMovieDb() {
        view.onLoading();
        interactor.getMovieDb(this);
    }

    public void interactorCall(int page) {
        if (GlobalUtils.isNetworkAvailable(context)) {
            view.onLoading();
            interactor.getMovieList(this, page);
        } else {
            view.onLoading();
            interactor.getMovieDb(this);
        }
    }


    public void getBookedMovie() {
        interactor.getBookedMovieDb(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDataRecieved(List<MovieResult> movieList) {
        view.onDataSuccess(movieList);
    }

    @Override
    public void onReceived(List<BookingMovieResult> movieList) {
        view.onSuccess(movieList);
    }

    @Override
    public void onDataFailed(String message) {
        view.onFailed();
    }
}
