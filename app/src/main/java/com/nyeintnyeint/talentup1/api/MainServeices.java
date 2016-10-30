package com.nyeintnyeint.talentup1.api;

import com.nyeintnyeint.talentup1.model.Phones;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kaungkhantlynn on 10/30/16.
 */
public interface MainServeices {

    @GET("latestPhones")
    Call<Phones> getPhoneData(@Query("page") int page_id);

}
