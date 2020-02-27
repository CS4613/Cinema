package org.snowcorp.app.retrofit;


import org.snowcorp.app.model.Movie;
import org.snowcorp.app.model.MovieDetails;
import org.snowcorp.app.model.Rating;
import org.snowcorp.app.model.Review;
import org.snowcorp.app.model.ReviewResult;
import org.snowcorp.app.model.Session;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/upcoming")
    Call<Movie> getMovieData(
            @Query("api_key") String apiKey);

    //            @Query("page") int page,
//            @Query("primary_release_year") String releaseDate);
    @GET("authentication/guest_session/new")
    Call<Session> getGuestSession(
            @Query("api_key") String apiKey);

    @GET("{movieId}")
    Call<MovieDetails> getMovie(
            @Path("movieId") int movieId,
            @Query("api_key") String apiKey);

    @GET("{movieId}/reviews")
    Call<Review> getReview(
            @Path("movieId") int movieId,
            @Query("language") String language,
            @Query("page") int page,
            @Query("api_key") String apiKey);


    @POST("{movieId}/rating")
    Call<Rating> postRating(
            @Path("movieId") int movieId,
            @Query("guest_session_id") String sessionID,
            @Body RequestBody requestBody,
            @Query("api_key") String apiKey);
}
