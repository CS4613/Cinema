package org.snowcorp.app.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.snowcorp.app.Interface.MovieDetailListener;
import org.snowcorp.app.Interface.RatingListener;
import org.snowcorp.app.Interface.SessionInterface;
import org.snowcorp.app.interactor.LoginInteractor;
import org.snowcorp.app.interactor.MovieInteractor;
import org.snowcorp.app.model.MovieDetails;
import org.snowcorp.app.model.ReviewResult;
import org.snowcorp.app.utils.GlobalUtils;
import org.snowcorp.app.view.MovieDetialView;
import org.snowcorp.app.view.ReviewListener;

import java.util.List;


public class MovieDetailPresenter implements MovieDetailListener {
    MovieDetialView view;
    Context context;
    MovieInteractor interactor;
    LoginInteractor loginInteractor;

    public MovieDetailPresenter(MovieDetialView view, Context context) {
        this.view = view;
        this.context = context;
        this.interactor = new MovieInteractor();
        loginInteractor = new LoginInteractor();
    }

    public void saveReview(String Review, String author, int id) {
        view.onLoading();
        interactor.saveReview(new ReviewListener() {
            @Override
            public void onSuccess(String message) {
                view.onSuccess(message);
            }

            @Override
            public void onFailed(String message) {
                view.onFailed(message);
            }

            @Override
            public void onSuccess(List<ReviewResult> reviewList) {

            }
        }, Review, author, id);

    }

    public void getReview(final int id) {
        view.onLoading();
        if (GlobalUtils.isNetworkAvailable(context)) {
            interactor.getReview(new ReviewListener() {
                @Override
                public void onSuccess(String message) {

                }

                @Override
                public void onFailed(String message) {

                }

                @Override
                public void onSuccess(List<ReviewResult> reviewList) {
                    view.setAdapter(reviewList);
                }
            }, id);
        } else {
            interactor.getReviewDb(new ReviewListener() {
                @Override
                public void onSuccess(String message) {

                }

                @Override
                public void onFailed(String message) {

                }

                @Override
                public void onSuccess(List<ReviewResult> reviewList) {
                    view.setAdapter(reviewList);
                }
            }, id);
        }
    }

    public void submitRating(float rating, final int movieID) {
        if (GlobalUtils.isNetworkAvailable(context)) {
            view.onLoading();
            final String json = getJsonString(rating);
            Log.d("JSonFormat", json);
            loginInteractor.getSession(new SessionInterface() {
                @Override
                public void onSuccess(String message) {
                    interactor.postRating(new RatingListener() {
                        @Override
                        public void onSuccess(String message) {
                            view.onSuccess(message);
                        }

                        @Override
                        public void onFailure(String message) {

                        }
                    }, message, movieID, json);
                }

                @Override
                public void onFailed(String message) {

                }
            });
        } else {
            Toast.makeText(context, "No internet available", Toast.LENGTH_SHORT).show();
        }
    }

    public void getMovieID(int id) {
        view.onLoading();
        if (GlobalUtils.isNetworkAvailable(context))
            interactor.getMovie(this, id);
        else
            Toast.makeText(context, "No internet available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataRecieved(MovieDetails movie) {
        view.setMovie(movie);

    }

    @Override
    public void onDataFailed(String message) {
        view.onFailed(message);
    }

    public String getJsonString(float rate) {
        JSONObject mainObj = new JSONObject();
        try {
            mainObj.put("value", GlobalUtils.getJsonData(rate));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mainObj.toString();
    }

}
