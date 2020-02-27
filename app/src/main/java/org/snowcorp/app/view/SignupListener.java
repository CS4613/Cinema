package org.snowcorp.app.view;


public interface SignupListener {
    void onLoading();
    void onSuccess(String message, String name, String email);
    void onFailed(String message);
}
