package com.nyeintnyeint.talentup1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.nyeintnyeint.talentup1.adapter.PhoneAdapter;
import com.nyeintnyeint.talentup1.api.MainServeices;
import com.nyeintnyeint.talentup1.api.Mainapi;
import com.nyeintnyeint.talentup1.model.Phone;
import com.nyeintnyeint.talentup1.model.Phones;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SuperRecyclerView mRecycler;
    PhoneAdapter mAdapter;
    List<Phone> phoneList=new ArrayList<>();

    int pagination=1;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //my code start
        mRecycler=(SuperRecyclerView)findViewById(R.id.phone_recycler);
        LinearLayoutManager lm=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        mRecycler.setLayoutManager(lm);
        mRecycler.getRecyclerView().setHasFixedSize(true);

        mAdapter=new PhoneAdapter(getApplicationContext(),phoneList);
        mRecycler.setAdapter(mAdapter);

        dataDownload();

        mRecycler.setOnMoreListener(new OnMoreListener() {
            @Override
            public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {
                pagination+=1;
                Call<Phones> call=Mainapi.createService(MainServeices.class).getPhoneData(pagination);
                call.enqueue(new Callback<Phones>() {
                    @Override
                    public void onResponse(Call<Phones> call, Response<Phones> response) {
                        total=response.body().getTotal();
                        if (pagination<=total){
                            phoneList.addAll(response.body().getPhoneList());
                            mAdapter.notifyDataSetChanged();
                        }else {
                            mRecycler.hideMoreProgress();
                            Toast.makeText(getApplicationContext(),"no more to load",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Phones> call, Throwable t) {

                    }
                });

            }
        });

    }

    private void dataDownload(){
        Call<Phones> call= Mainapi.createService(MainServeices.class).getPhoneData(1);
        call.enqueue(new Callback<Phones>() {
            @Override
            public void onResponse(Call<Phones> call, Response<Phones> response) {
//                Log.d("NYEINT DATA",response.body().getPhoneList().get(1).getPhone_brand());
                phoneList.addAll(response.body().getPhoneList());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Phones> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
