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

import com.example.mymosque.Adapter.AdapterRVJummahTimes;
import com.example.mymosque.R;

import java.util.ArrayList;

public class FragmentFourth extends Fragment {

    private ArrayList<String> JummahTimes = new ArrayList<>();
    View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_fourth, container, false);
        v.findViewById(R.id.fourthfrag);

        reclerviewInIt();
        return v;
    }





    public void reclerviewInIt(){

        RecyclerView recyclerview = v.findViewById(R.id.RV_jummah_times);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(linearLayoutManager);
        AdapterRVJummahTimes adapterRVJummahTimes = new AdapterRVJummahTimes(getActivity(),JummahTimes);
        recyclerview.setAdapter(adapterRVJummahTimes);
        JummahTimes.add("05:45");
        JummahTimes.add("05:45");
        JummahTimes.add("05:45");
        JummahTimes.add("05:45");
        JummahTimes.add("05:45");
        JummahTimes.add("05:45");
        JummahTimes.add("05:45");
        JummahTimes.add("05:45");


    }






}
