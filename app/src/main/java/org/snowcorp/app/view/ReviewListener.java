package org.snowcorp.app.view;


import org.snowcorp.app.model.ReviewResult;

import java.util.List;

public interface ReviewListener {
    void onSuccess(String message);

    void onFailed(String message);

    void onSuccess(List<ReviewResult> reviewList);
}
