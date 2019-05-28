package com.example.mymosque.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mymosque.R;

import java.util.ArrayList;

public class AdapterRVJummahTimes extends RecyclerView.Adapter<AdapterRVJummahTimes.ViewHolder> {


    private ArrayList<String> JummahTimes = new ArrayList<>();

    private Context mContext;


    private static final String TAG = "RecyclerViewAdapter_F_ADS";



    public AdapterRVJummahTimes(Context Context, ArrayList<String> Names) {
        this.mContext = Context;
        this.JummahTimes = Names;

    }
    @NonNull
    @Override
    public AdapterRVJummahTimes.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jummah_times_item, parent, false);
        return new AdapterRVJummahTimes.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder (@NonNull AdapterRVJummahTimes.ViewHolder holder, final int position){

        holder.Time.setText(JummahTimes.get(position));









    }

    @Override
    public int getItemCount () {
        return JummahTimes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Time;


        public ViewHolder(View itemView) {
            super(itemView);


            Time  = itemView.findViewById(R.id.txt_1st_jummah);



        }
    }


}

