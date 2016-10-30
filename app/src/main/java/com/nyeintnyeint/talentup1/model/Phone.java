package com.nyeintnyeint.talentup1.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kaungkhantlynn on 10/30/16.
 */
public class Phone {
    @SerializedName("id")
    private int phone_id;

    @SerializedName("phone_brand")
    private String phone_brand;

    @SerializedName("phone_color")
    private String phone_color;


    @SerializedName("display_size")
    private String display_size;

    @SerializedName("display_resolution")
    private String  display_resolution;

    @SerializedName("display_tech")
    private String display_tech;

    @SerializedName("multi_tech")
    private String multi_tech;

    @SerializedName("camera_main")
    private String camera_main;

    @SerializedName("camera_option")
    private String camera_option;

    @SerializedName("camera_back")
    private String camera_back;

    @SerializedName("os_type")
    private String os_type;

    @SerializedName("company")
    private String company;

    @SerializedName("cpu")
    private String cpu;

    @SerializedName("os_version")
    private String os_version;

    @SerializedName("gpu")
    private String gpu;

    @SerializedName("storage_internal")
    private String storage_internal;

    @SerializedName("storage_cardslot")
    private String storage_cardslot;

    @SerializedName("network_type")
    private String network_type;

    @SerializedName("bluetooth_version")
    private String bluetooth_version;

    @SerializedName("headphone")
    private String headphone;

    @SerializedName("sound_type")
    private String sound_type;

    @SerializedName("sound_speaker")
    private String sound_speaker;

    @SerializedName("battery_type")
    private String battery_type;

    @SerializedName("battery_life")
    private String battery_life;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("sensors")
    private String sensors;

    @SerializedName("sim_types")
    private String sim_types;

    @SerializedName("estimate_price")
    private String estimate_price;


    @SerializedName("review")
    private String review;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private  String updated_at;

    @SerializedName("image1")
    private String image1;

    @SerializedName("image2")
    private String image2;

    @SerializedName("image3")
    private String image3;

    public int getPhone_id() {
        return phone_id;
    }

    public String getPhone_brand() {
        return phone_brand;
    }

    public String getPhone_color() {
        return phone_color;
    }

    public String getDisplay_size() {
        return display_size;
    }

    public String getDisplay_resolution() {
        return display_resolution;
    }

    public String getDisplay_tech() {
        return display_tech;
    }

    public String getMulti_tech() {
        return multi_tech;
    }

    public String getCamera_main() {
        return camera_main;
    }

    public String getCamera_option() {
        return camera_option;
    }

    public String getCamera_back() {
        return camera_back;
    }

    public String getOs_type() {
        return os_type;
    }

    public String getCompany() {
        return company;
    }

    public String getCpu() {
        return cpu;
    }

    public String getOs_version() {
        return os_version;
    }

    public String getGpu() {
        return gpu;
    }

    public String getStorage_internal() {
        return storage_internal;
    }

    public String getStorage_cardslot() {
        return storage_cardslot;
    }

    public String getNetwork_type() {
        return network_type;
    }

    public String getBluetooth_version() {
        return bluetooth_version;
    }

    public String getHeadphone() {
        return headphone;
    }

    public String getSound_type() {
        return sound_type;
    }

    public String getSound_speaker() {
        return sound_speaker;
    }

    public String getBattery_type() {
        return battery_type;
    }

    public String getBattery_life() {
        return battery_life;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getSensors() {
        return sensors;
    }

    public String getSim_types() {
        return sim_types;
    }

    public String getEstimate_price() {
        return estimate_price;
    }

    public String getReview() {
        return review;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }
}
