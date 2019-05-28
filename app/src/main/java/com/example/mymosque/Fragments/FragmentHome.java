package com.example.mymosque.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymosque.MainActivity;
import com.example.mymosque.R;
import com.example.mymosque.RV_FindMasajid;

import java.util.ArrayList;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.support.v4.content.ContextCompat.getSystemService;

public class FragmentHome extends Fragment {


    View v;
    ImageView Humbburger;
    EditText search_masjid;
    DrawerLayout mDrawerLayout;
    private ArrayList<String> MasajidName = new ArrayList<>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       //((AppCompatActivity) getActivity()).getSupportActionBar().hide();
//        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
//
//
//        mTitle.setText("Prayer TImes");
//*/

    }//end of onCreate method

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragmenthome, container, false);


        //<For Toolbar>
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        //</For Toolbar>

       /* Button mosqueBtn = (Button) v.findViewById(R.id.MosqueBTN);
        mosqueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.Screen_Area,new FragmentMyMasjid()).commit();
            }
        });*/
        RecyclerViewMasajid();
        search_masjid = (EditText) v.findViewById(R.id.edit_txt_masjid);
        Humbburger = (ImageView) v.findViewById(R.id.humburgerIcon);
        mDrawerLayout = (DrawerLayout)getActivity().findViewById(R.id.drawer_layout);
        Humbburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        search_masjid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }});





        return v;
    }//End onCreateView Method




    public void RecyclerViewMasajid() {
        MasajidName.add("Masjid-e-Nagina");
        MasajidName.add("Masjid-e-Aqsa");
        MasajidName.add("Masjid-e-Iqra");
        MasajidName.add("Masjid-e-Tooba");
        MasajidName.add("Masjid-e-Ayesha");
        MasajidName.add("Masjid-e-Nabvi");


        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.RV_masajidList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RV_FindMasajid adapter = new RV_FindMasajid(getActivity(), MasajidName);
        recyclerView.setAdapter(adapter);

    }





}
