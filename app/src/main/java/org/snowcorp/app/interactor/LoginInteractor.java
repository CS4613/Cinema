package org.snowcorp.app.interactor;

import android.util.Log;

import org.snowcorp.app.model.Session;
import org.snowcorp.app.retrofit.ApiService;
import org.snowcorp.app.retrofit.RetrofitHelper;
import org.snowcorp.app.Interface.SessionInterface;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor {


    public void getSession(final SessionInterface mListener) {

        ApiService service = RetrofitHelper.getClient().create(ApiService.class);
        Call<Session> call = service.getGuestSession("ef8f48b43832a9e95b87408bf739ed51");
        call.enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {
                if (response.code() == 200) {
                    Log.d("ResponseData", String.valueOf(response.body()));
                    Session movie = response.body();
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    realm.insertOrUpdate(movie);
                    realm.commitTransaction();
                    mListener.onSuccess(movie.getGuestSessionId());
                } else {
                    mListener.onFailed("Failed to connect with Server");
                }
            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {
                mListener.onFailed(t.getMessage());
            }
        });
    }
}
