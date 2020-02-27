package org.snowcorp.app.presenter;

import android.content.Context;
import android.util.Log;

import org.snowcorp.app.Interface.SessionInterface;
import org.snowcorp.app.interactor.LoginInteractor;
import org.snowcorp.app.model.Register;
import org.snowcorp.app.utils.GlobalUtils;
import org.snowcorp.app.view.SignupListener;

import io.realm.Realm;
import io.realm.RealmResults;


public class SignupPresenter {
    Context context;
    SignupListener listener;
    LoginInteractor interactor;

    public SignupPresenter(SignupListener listener, Context context) {
        this.context = context;
        this.listener = listener;
        interactor = new LoginInteractor();

    }

    public void dataSave(final String name, final String email, final String password) {
        listener.onLoading();
        try {
            Realm realm = Realm.getDefaultInstance();

            realm.beginTransaction();
            Register register = new Register();
            Number currentIdNum = realm.where(Register.class).max("ID");
            int nextId;
            if (currentIdNum == null) {
                nextId = 1;
            } else {

                nextId = currentIdNum.intValue() + 1;
            }
            register.setID(nextId);
            register.setName(name);
            register.setEmail(email);
            register.setPassword(password);
//            Constant.Name=name;
//            Constant.Email=email;
            realm.insertOrUpdate(register);
            realm.commitTransaction();
            getSessionID(register);


//            RealmResults<Register> results = realm.where(Register.class).findAll();
//            for (int i = 0; i < results.size(); i++) {
//                Log.d("databaseData", results.get(i).getEmail() + " " + results.get(i).getPassword() + " " + results.get(i).getID());
//                if (email.equals(results.get(i).getEmail()) && password.equals(results.get(i).getPassword())) {
//                    listener.onSuccess("User login successfully", results.get(i).getEmail(), results.get(i).getEmail());
//                }
//            }


        } catch (Exception ex) {
            Log.d("Failed", ex.toString());
            listener.onFailed("User doesn't register");
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
