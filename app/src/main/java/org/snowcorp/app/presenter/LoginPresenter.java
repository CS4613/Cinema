package org.snowcorp.app.presenter;

import android.content.Context;
import android.util.Log;

import org.snowcorp.app.Interface.SessionInterface;
import org.snowcorp.app.interactor.LoginInteractor;
import org.snowcorp.app.model.Register;
import org.snowcorp.app.utils.GlobalUtils;
import org.snowcorp.app.view.Constant;
import org.snowcorp.app.view.LoginListener;

import io.realm.Realm;
import io.realm.RealmResults;


public class LoginPresenter {
    LoginListener listener;
    Context context;
    LoginInteractor interactor;

    public LoginPresenter(LoginListener listener, Context context) {
        this.listener = listener;
        this.context = context;
        interactor = new LoginInteractor();

    }


    public void checkLogin(final String email, final String password) {

        Realm realm = Realm.getDefaultInstance(); //creating  database oject
        RealmResults<Register> results = realm.where(Register.class).findAll();
        for (int i = 0; i < results.size(); i++) {
            Log.d("databaseData", results.get(i).getEmail() + results.get(i).getPassword());

            if (email.equals(results.get(i).getEmail()) && password.equals(results.get(i).getPassword())) {
                Constant.Name = results.get(i).getName();
                Constant.Email = results.get(i).getEmail();
                getSessionID(realm.copyFromRealm(results.get(i)));

            } else {
                listener.onFailed("Email or password incorrect");

            }
        }

    }

    public void getSessionID(final Register results) {
        interactor.getSession(new SessionInterface() {
            @Override
            public void onSuccess(String message) {
                Log.d("SessionToken", message);
                GlobalUtils.savePref("SessionID", message, context);
                listener.onSuccess("User login successfully", results.getName(), results.getEmail());
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

}
