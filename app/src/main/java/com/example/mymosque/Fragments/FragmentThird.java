package com.example.mymosque.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mymosque.Adapter.AdapterRVJamaatTimes;
import com.example.mymosque.R;

import java.util.ArrayList;

public class FragmentThird extends Fragment {

    private ArrayList<String> JamaatTimes = new ArrayList<>();
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_third, container, false);
        v.findViewById(R.id.thirdfrag);
        reclerviewInIt();
        return v;
    }





    public void reclerviewInIt(){

        RecyclerView recyclerview = v.findViewById(R.id.RV_jamaat_times);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(linearLayoutManager);
        AdapterRVJamaatTimes adapterRVJamaatTimes = new AdapterRVJamaatTimes(getActivity(),JamaatTimes);
        recyclerview.setAdapter(adapterRVJamaatTimes);
        JamaatTimes.add("05:45");
        JamaatTimes.add("05:45");
        JamaatTimes.add("05:45");
        JamaatTimes.add("05:45");
        JamaatTimes.add("05:45");
        JamaatTimes.add("05:45");
        JamaatTimes.add("05:45");
        JamaatTimes.add("05:45");


    }



}
