package com.nyeintnyeint.talentup1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nyeintnyeint.talentup1.api.MainServeices;
import com.nyeintnyeint.talentup1.api.Mainapi;
import com.nyeintnyeint.talentup1.model.Phone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneDetails extends AppCompatActivity {

    int phone_id;
    ImageView imgPhDetails;
    TextView txtPhBrand,txtPhColor,txtDisplaySize,txtCameraMain,txtCameraBack,txtCpu,txtRam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //code start
        Bundle args=getIntent().getExtras();
        phone_id=args.getInt("key");

        imgPhDetails=(ImageView)findViewById(R.id.img_ph_details);
        txtPhBrand=(TextView)findViewById(R.id.txtPh_titleDetails);
        txtPhColor=(TextView)findViewById(R.id.txt_ph_color);
        txtDisplaySize=(TextView)findViewById(R.id.txt_display_size);
        txtCameraMain=(TextView)findViewById(R.id.txt_camera_main);
        txtCameraBack=(TextView)findViewById(R.id.txt_camera_back);
        txtCpu=(TextView)findViewById(R.id.txt_cpu);
        txtRam=(TextView)findViewById(R.id.txt_ram);


        DownloadDetails(phone_id);
    }

    private void DownloadDetails(int id){
        Call<Phone> call= Mainapi.createService(MainServeices.class).getPhoneDetails(id);
        call.enqueue(new Callback<Phone>() {
            @Override
            public void onResponse(Call<Phone> call, Response<Phone> response) {
                Glide.with(getApplicationContext()).load(response.body().getImage1())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(imgPhDetails);

                txtPhBrand.setText(response.body().getPhone_brand());
                txtPhColor.setText(response.body().getPhone_color());
                txtDisplaySize.setText(response.body().getDisplay_size());
                txtCameraMain.setText(response.body().getCamera_main());
                txtCameraBack.setText(response.body().getCamera_back());
                txtCpu.setText(response.body().getCpu());
                txtRam.setText(response.body().getRam());
            }

            @Override
            public void onFailure(Call<Phone> call, Throwable t) {

            }
        });
    }

}
