package com.example.mymosque.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymosque.Adapter.MyPagerAdapter;
import com.example.mymosque.R;
import com.github.vivchar.viewpagerindicator.ViewPagerIndicator;

public class FragmentPrayerTimes extends Fragment {

    View v;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);










    }//end of onCreate method

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_prayer_times, container, false);

        //<For Toolbar>
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Prayer Times");
        //</For Toolbar>



        final ViewPager pager = (ViewPager) v.findViewById(R.id.viewPager);
        ImageView leftNav = (ImageView) v.findViewById(R.id.left_nav);
        ImageView rightNav = (ImageView) v.findViewById(R.id.right_nav);
        // Images left navigation





        pager.setAdapter(new MyPagerAdapter(getFragmentManager()));
        ViewPagerIndicator viewPagerIndicator = (ViewPagerIndicator) v.findViewById(R.id.view_pager_indicator);

        viewPagerIndicator.setupWithViewPager(pager);

        leftNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = pager.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    pager.setCurrentItem(tab);
                } else if (tab == 0) {
                    pager.setCurrentItem(tab);
                }
            }
        });

        // Images right navigatin
        rightNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = pager.getCurrentItem();
                tab++;
                pager.setCurrentItem(tab);
            }
        });















        return v;
    }//End onCreateView Method


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return new FragmentFirst();
                case 1: return new FragmentSecond();
                case 2: return new FragmentThird();

                case 3: return new FragmentFourth();

                default: return new FragmentFourth();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }




}
