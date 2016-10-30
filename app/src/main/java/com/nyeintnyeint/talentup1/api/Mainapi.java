package com.nyeintnyeint.talentup1.api;

import com.nyeintnyeint.talentup1.utility.Const;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kaungkhantlynn on 10/30/16.
 */
public class Mainapi {
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(Const.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(new OkHttpClient());

    public Mainapi() {
    }

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

}
