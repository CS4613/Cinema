package org.snowcorp.app.Interface;

public interface RatingListener {
    void onSuccess(String message);

    void onFailure(String message);
}
