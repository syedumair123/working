package com.example.mymosque;

/*public class RV_FindMasajid {
}*/


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymosque.Fragments.FragementProfile;
import com.example.mymosque.Fragments.FragmentFeedback;
import com.example.mymosque.Fragments.FragmentNearestMasajid;

import java.util.ArrayList;

public class RV_FindMasajid extends RecyclerView.Adapter<RV_FindMasajid.ViewHolder> implements View.OnClickListener {

    private ArrayList<String> MasajidNames = new ArrayList<>();

    private Context mContext;


    private static final String TAG = "RecyclerViewAdapter_F_ADS";



    public RV_FindMasajid(Context Context, ArrayList<String> Names) {
        this.mContext = Context;
        this.MasajidNames = Names;

    }
    @NonNull
    @Override
    public RV_FindMasajid.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_masajid_item, parent, false);
        return new RV_FindMasajid.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder (@NonNull RV_FindMasajid.ViewHolder holder, final int position){

        holder.MasajidName.setText(MasajidNames.get(position));


        /*holder.Image.setOnClickListener(this);
        holder.MasajidName.setOnClickListener(this);*/
        holder.itemView.setOnClickListener(this);








    }


    @Override
    public int getItemCount () {
        return MasajidNames.size();
    }

    @Override
    public void onClick(View v) {

        AppCompatActivity activity = (AppCompatActivity) v.getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.Screen_Area,new FragementProfile()).commit();


    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView MasajidName;
        ImageView Image;

        public ViewHolder(View itemView) {
            super(itemView);


            MasajidName  = itemView.findViewById(R.id.txt_Masajid);
            Image = itemView.findViewById(R.id.img_);


        }
    }


}



