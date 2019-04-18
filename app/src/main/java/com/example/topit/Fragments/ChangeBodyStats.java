package com.example.topit.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.topit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeBodyStats extends Fragment {


    public ChangeBodyStats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_change_body_stats, container, false);



        return  v;
    }

    public void onResume(){
        super.onResume();
        getActivity().setTitle("Change your body stats");
    }



}
