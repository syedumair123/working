package com.example.mymosque.Fragments;

/*public class FragmentNearestMasajid {
}*/


import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymosque.R;
import com.example.mymosque.RV_FindMasajid;

import java.util.ArrayList;

public class FragmentNearestMasajid  extends Fragment {

    View v;

    private ArrayList<String> MasajidName = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);











    }//end of onCreate method

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_nearest_masajid, container, false);

        //<For Toolbar>
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Nearest Masajid");
        //</For Toolbar




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






        RecyclerView recyclerView =(RecyclerView) v.findViewById(R.id.RV_NearestMasajidList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RV_FindMasajid adapter = new RV_FindMasajid(getActivity(),MasajidName);
        recyclerView.setAdapter(adapter);



    }














}
