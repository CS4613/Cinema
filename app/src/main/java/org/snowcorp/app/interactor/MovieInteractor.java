package org.snowcorp.app.interactor;

import android.text.TextUtils;
import android.util.Log;

import org.snowcorp.app.Interface.MovieDetailListener;
import org.snowcorp.app.Interface.MovieListener;
import org.snowcorp.app.Interface.RatingListener;
import org.snowcorp.app.model.BookingMovieResult;
import org.snowcorp.app.model.Movie;
import org.snowcorp.app.model.MovieDetails;
import org.snowcorp.app.model.MovieResult;
import org.snowcorp.app.model.Rating;
import org.snowcorp.app.model.Review;
import org.snowcorp.app.model.ReviewResult;
import org.snowcorp.app.retrofit.ApiService;
import org.snowcorp.app.retrofit.RetrofitHelper;
import org.snowcorp.app.retrofit.RetrofitHelperMovie;
import org.snowcorp.app.view.ReviewListener;

import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieInteractor {

    List<Movie> movieList;

    public void getMovieList(final MovieListener mListener, int page) {

        ApiService service = RetrofitHelper.getClient().create(ApiService.class);
        Call<Movie> call = service.getMovieData("ef8f48b43832a9e95b87408bf739ed51"
//                , page, "2018"
        );
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.code() == 200) {
                    Log.d("ResponseData", String.valueOf(response.body()));
                    Movie movie = response.body();
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    realm.insertOrUpdate(movie);
                    realm.commitTransaction();
                    mListener.onDataRecieved(movie.getResults());
                } else {
                    mListener.onDataFailed("Failed to connect with Server");
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                mListener.onDataFailed(t.getMessage());
            }
        });
    }

    public void getMovie(final MovieDetailListener mListener, int id) {

        ApiService service = RetrofitHelperMovie.getClient().create(ApiService.class);
        Call<MovieDetails> call = service.getMovie(id, "ef8f48b43832a9e95b87408bf739ed51");
        call.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                if (response.code() == 200) {
                    Log.d("ResponseData", String.valueOf(response.body()));
                    MovieDetails movie = response.body();
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    realm.insertOrUpdate(movie);
                    realm.commitTransaction();
                    mListener.onDataRecieved(movie);
                } else {
                    mListener.onDataFailed("Failed to connect with Server");
                }
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {
                mListener.onDataFailed(t.getMessage());
            }
        });
    }

    public void getMovieDb(final MovieDetailListener mListener, int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        MovieDetails results = realm.copyFromRealm(realm.where(MovieDetails.class).equalTo("id", id).findFirst());
        realm.commitTransaction();
        if (results != null)
            mListener.onDataRecieved(results);
        else
            mListener.onDataFailed("no_data");
    }

    public void postRating(final RatingListener mListener, String sessionID, int movieId, String json) {

        ApiService service = RetrofitHelperMovie.getClient().create(ApiService.class);
        Call<Rating> call = service.postRating(movieId, sessionID,
                RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json), "ef8f48b43832a9e95b87408bf739ed51");
        call.enqueue(new Callback<Rating>() {
            @Override
            public void onResponse(Call<Rating> call, Response<Rating> response) {
                if (response.isSuccessful()) {
                    Log.d("ResponseData", String.valueOf(response.body()));
                    Rating rating = response.body();
                    mListener.onSuccess(rating.getStatusMessage());
                } else {
                    mListener.onFailure("Failed to connect with Server");
                }
            }

            @Override
            public void onFailure(Call<Rating> call, Throwable t) {
                mListener.onFailure(t.getMessage());
            }
        });
    }

    public void saveReview(ReviewListener listener, String review, String author, int id) {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        Review reviewData = new Review();
        Number currentIdNum = realm.where(Review.class).max("id");
        int nextId;
        if (currentIdNum == null) {
            nextId = 1;
        } else {

            nextId = currentIdNum.intValue() + 1;
        }
        ReviewResult reviewResult = new ReviewResult();

        Number currentReviewListID = realm.where(ReviewResult.class).max("reviewID");
        long nextReviewId = 0;
        if (currentReviewListID == null) {
            nextReviewId = 1;
        } else {

            nextReviewId = (currentReviewListID.longValue() + 1);
        }
        String reviewID = String.valueOf(nextReviewId);
        reviewResult.setReviewID(reviewID);
        reviewResult.setAuthor(author);
        reviewResult.setContent(review);
        reviewResult.setUrl("");
        RealmList<ReviewResult> reviewResults = new RealmList<>();
        reviewResults.add(reviewResult);

        reviewData.setId(nextId);
        reviewData.setMovieID(id);
        reviewData.setReviewResults(reviewResults);
        realm.insertOrUpdate(reviewData);
        realm.commitTransaction();
        listener.onSuccess("ReviewResult send successfully");
    }

    public void getMovieDb(final MovieListener mListener) {
        Realm realm = Realm.getDefaultInstance();
        Movie results = realm.copyFromRealm(realm.where(Movie.class).findFirst());
        mListener.onDataRecieved(results.getResults());
    }


    public void getBookedMovieDb(final MovieListener mListener) {
        Realm realm = Realm.getDefaultInstance();
        List<BookingMovieResult> list = new ArrayList<>();
        list = realm.copyFromRealm(realm.where(BookingMovieResult.class).findAll());
        mListener.onReceived(list);
    }

    public void getReview(final ReviewListener listener, final int id) {
        ApiService service = RetrofitHelperMovie.getClient().create(ApiService.class);
        Call<Review> call = service.getReview(id, "en-US", 1, "ef8f48b43832a9e95b87408bf739ed51");
        call.enqueue(new Callback<Review>() {
            @Override
            public void onResponse(Call<Review> call, Response<Review> response) {
                if (response.code() == 200) {
                    Log.d("ResponseData", String.valueOf(response.body()));
                    Review movie = response.body();
                    movie.setMovieID(id);
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    realm.insertOrUpdate(movie);
                    realm.commitTransaction();
                    listener.onSuccess(movie.getReviewResults());
                } else {
                    listener.onFailed("Failed to connect with Server");
                }
            }

            @Override
            public void onFailure(Call<Review> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getReviewDb(final ReviewListener listener, final int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Review results = realm.copyFromRealm(realm.where(Review.class).equalTo("movieID", id).findFirst());
        realm.commitTransaction();
        if (results != null)
            listener.onSuccess(results.getReviewResults());
        else
            listener.onFailed("no_data");
    }

    public void getSearchItem(String searchText, final MovieListener mListener) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        if (!TextUtils.isEmpty(searchText)) {
            List<MovieResult> list = new ArrayList<>();
            RealmResults<MovieResult> results = realm.where(MovieResult.class).contains("title", searchText, Case.INSENSITIVE).findAll();
            list = realm.copyFromRealm(results);
            realm.commitTransaction();
            if (list.size() > 0)
                mListener.onDataRecieved(list);
            else
                mListener.onDataFailed("no_data");
        } else {
            List<MovieResult> list = new ArrayList<>();
            RealmResults<MovieResult> results = realm.where(MovieResult.class).findAll();
            list = realm.copyFromRealm(results);
            realm.commitTransaction();
            if (list.size() > 0)
                mListener.onDataRecieved(list);
            else
                mListener.onDataFailed("no_data");
        }
    }
}

