package com.example.mymosque;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymosque.Fragments.FragmentAddMosque;
import com.example.mymosque.Fragments.FragmentDua;
import com.example.mymosque.Fragments.FragmentFavorite;
import com.example.mymosque.Fragments.FragmentFeedback;
import com.example.mymosque.Fragments.FragmentHome;
import com.example.mymosque.Fragments.FragmentMasajidList;
import com.example.mymosque.Fragments.FragmentMyMosque;
import com.example.mymosque.Fragments.FragmentNearestJummah;
import com.example.mymosque.Fragments.FragmentNearestMasajid;
import com.example.mymosque.Fragments.FragmentNotification;
import com.example.mymosque.Fragments.FragmentQiblaDirection;
import com.example.mymosque.Fragments.FragmentSettings;

import static android.app.PendingIntent.getActivity;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    ImageView Humbburger;
    DrawerLayout mDrawerLayout;
    ImageView backbutton;
    TextView shareapp;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        mTitle.setText("Home");
        getSupportActionBar().setDisplayShowTitleEnabled(false);*/

        shareapp = (TextView) findViewById(R.id.text12);

        shareapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }



        });



        //Button Calls Navigation view
        backbutton = (ImageView) findViewById(R.id.backButton);
        Humbburger = (ImageView) findViewById(R.id.humburgerIcon);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        Humbburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.RIGHT);
            }
        });


        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showHome();

            }



        });



        TextView home_ = (TextView) findViewById(R.id.text1);
        home_.setOnClickListener(this);
        TextView Feedback_ = (TextView) findViewById(R.id.text11);
        Feedback_.setOnClickListener(this);
        TextView Dua_ = (TextView) findViewById(R.id.text9);
        Dua_.setOnClickListener(this);
        TextView fragmentmassajilist_ = (TextView) findViewById(R.id.text3);
        fragmentmassajilist_.setOnClickListener(this);
        TextView fragmentnearestmassajid_ = (TextView) findViewById(R.id.text4);
        fragmentnearestmassajid_.setOnClickListener(this);
        TextView fragmentnearestjummah_ = (TextView) findViewById(R.id.text5);
        fragmentnearestjummah_.setOnClickListener(this);
        TextView fragmentsettings_ = (TextView) findViewById(R.id.text10);
        fragmentsettings_.setOnClickListener(this);
        TextView fragmentnotification_ = (TextView) findViewById(R.id.text7);
        fragmentnotification_.setOnClickListener(this);
        TextView fragmentaddmosque_ = (TextView) findViewById(R.id.text8);
        fragmentaddmosque_.setOnClickListener(this);
        TextView fragqibla = (TextView) findViewById(R.id.text6);
        fragqibla.setOnClickListener(this);
        TextView fragmentfavorite = (TextView) findViewById(R.id.text2);
        fragmentfavorite.setOnClickListener(this);
        //


        FragmentHome myf = new FragmentHome();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.Screen_Area, myf);
        transaction.commit();



       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();*/

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,  R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                if (item != null && item.getItemId() == android.R.id.home) {
                    if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                        drawerLayout.closeDrawer(Gravity.RIGHT);
                    } else {
                        drawerLayout.openDrawer(Gravity.RIGHT);
                    }
                }
                return false;
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();







        /*toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);








    }






















    private boolean doubleBackToExitPressedOnce = false;


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }/* else{

            showHome();
        }*/

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;

        }
        else{

            showHome();
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);



    }



 /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
    /*@Override
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
    }*/

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
    Fragment fragment = null;
    private  void showHome(){

        fragment = new FragmentHome();
        if(fragment!=null){

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Screen_Area, fragment ,fragment.getTag()).commit();
        }
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        Class fragmentClass = null;

        if(v.getId() == R.id.text1)
        {
            //do something here if button1 is clicked

            fragmentClass = FragmentMyMosque.class;
        }

        else if (v.getId() == R.id.text4)
        {
            fragmentClass = FragmentNearestMasajid.class;
            //do something here if button3 is clicked
           // fragmentClass = FragmentLevel.class;
        }else if (v.getId() == R.id.text5){
            //do something here if button3 is clicked
           // fragmentClass = FragmentNotification.class;
            fragmentClass = FragmentNearestJummah.class;
        }
        else if (v.getId() == R.id.text6)
        {
            //do something here if button3 is clicked
           // fragmentClass = FragmentAboutUS.class;
            fragmentClass = FragmentQiblaDirection.class;
        }
        else if (v.getId() == R.id.text11)
        {
            //do something here if button3 is clicked
           fragmentClass = FragmentFeedback.class;
        }
        else if (v.getId() == R.id.text9)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentDua.class;
        }
        else if (v.getId() == R.id.text3)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentMasajidList.class;
        }
        else if (v.getId() == R.id.text10)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentSettings.class;
        }

        else if (v.getId() == R.id.text7)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentNotification.class;
        }

        else if (v.getId() == R.id.text8)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentAddMosque.class;
        }
        else if (v.getId() == R.id.text2)
        {
            //do something here if button3 is clicked
            fragmentClass = FragmentFavorite.class;
        }


        if(fragment!=null){

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Screen_Area, fragment ,fragment.getTag()).commit();
        }



        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Screen_Area, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);






    }



}
