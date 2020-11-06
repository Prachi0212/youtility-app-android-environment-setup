package com.youtility.network;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mohit Rajput on 27/3/19.
 * Customized response callback for APIs called from Retrofit
 */
public abstract class ResponseCallback<T> implements Callback<T> {

    public final static int CODE_UNAUTHORIZED = 401;
    public final static int CODE_FORBIDDEN = 403;
    public final static int CODE_BAD_REQUEST = 400;

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        int code = response.code();
        if (code >= 200 && code < 300) {
            success(call, response);
        } else if (code == CODE_UNAUTHORIZED || code == CODE_FORBIDDEN) {
            unauthenticated(call, response);
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable throwable) {
        failure(call, throwable);
    }

    /**
     * Called for [200, 300) responses.
     */
    public abstract void success(Call<? extends Object> call, Response<T> response);

    /**
     * Called when user's session gets expired. It is based on status code {@link #CODE_UNAUTHORIZED}
     */
    public abstract void unauthenticated(Call<? extends Object> call, Response<?> response);

    /**
     * Called in case of failure
     */
    public abstract void failure(Call<? extends Object> call, Throwable throwable);
}
