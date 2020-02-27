package org.snowcorp.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;

public class CountDownTime extends CountDownTimer {
    private Activity _act;
    private Class _cls;

    public CountDownTime(long millisInFuture, long countDownInterval, Activity act, Class cls) {
        super(millisInFuture, countDownInterval);
        _act = act;
        _cls = cls;
    }

    @Override
    public void onFinish() {
        _act.startActivity(new Intent(_act, _cls));
        _act.finish();
    }

    @Override
    public void onTick(long millisUntilFinished) {
    }
}