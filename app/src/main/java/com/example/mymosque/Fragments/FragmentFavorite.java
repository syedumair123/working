package com.example.mymosque.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mymosque.AdapterRVFavorite;
import com.example.mymosque.R;
import com.example.mymosque.RV_FindMasajid;

import java.util.ArrayList;

public class FragmentFavorite extends Fragment {

    View v;

    private ArrayList<String> MasajidName = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

    }//end of onCreate method

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_favorite, container, false);



        //<For Toolbar>
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        ImageView backbutton = (ImageView) toolbar.findViewById(R.id.backButton);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Favorite");
        //</For Toolbar>



        RecyclerViewMasajid();




        return v;
    }//End onCreateView Method


    public void RecyclerViewMasajid(){
        MasajidName.add("Masjid-e-Nagina");
        MasajidName.add("Masjid-e-Aqsa");
        MasajidName.add("Masjid-e-Iqra");
        MasajidName.add("Masjid-e-Tooba");
        MasajidName.add("Masjid-e-Ayesha");
        MasajidName.add("Masjid-e-Nabvi");






        RecyclerView recyclerView =(RecyclerView) v.findViewById(R.id.RV_FavoriteList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        AdapterRVFavorite adapter = new AdapterRVFavorite(getActivity(),MasajidName);
        recyclerView.setAdapter(adapter);




    }








}
