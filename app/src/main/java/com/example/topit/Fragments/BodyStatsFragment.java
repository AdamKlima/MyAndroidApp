package com.example.topit.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.topit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BodyStatsFragment extends Fragment {

    FloatingActionButton fab;


    public BodyStatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_body_stats, container, false);
        fab = (FloatingActionButton) v.findViewById(R.id.floatingActionButtonChangeStats);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main, new ChangeBodyStats());
                ft.commit();
            }
        });



        return v;
    }







}
