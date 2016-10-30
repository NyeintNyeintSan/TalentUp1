package com.nyeintnyeint.talentup1.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kaungkhantlynn on 10/30/16.
 */
public class Phones {
    @SerializedName("total")
    private int total;

    @SerializedName("data")
    private List<Phone> phoneList;

    public int getTotal() {
        return total;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }
}

