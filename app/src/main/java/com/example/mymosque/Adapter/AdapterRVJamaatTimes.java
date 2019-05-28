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

public class AdapterRVJamaatTimes extends RecyclerView.Adapter<AdapterRVJamaatTimes.ViewHolder> {


    private ArrayList<String> JamaatTimes = new ArrayList<>();

    private Context mContext;


    private static final String TAG = "RecyclerViewAdapter_F_ADS";



    public AdapterRVJamaatTimes(Context Context, ArrayList<String> Names) {
        this.mContext = Context;
        this.JamaatTimes = Names;

    }
    @NonNull
    @Override
    public AdapterRVJamaatTimes.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jamaat_times_item, parent, false);
        return new AdapterRVJamaatTimes.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder (@NonNull AdapterRVJamaatTimes.ViewHolder holder, final int position){

        holder.Time.setText(JamaatTimes.get(position));









    }

    @Override
    public int getItemCount () {
        return JamaatTimes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Time;


        public ViewHolder(View itemView) {
            super(itemView);


            Time  = itemView.findViewById(R.id.txt_isha_time_beginning);



        }
    }


}
