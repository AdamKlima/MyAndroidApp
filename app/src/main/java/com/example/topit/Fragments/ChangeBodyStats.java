package com.example.topit.Fragments;


import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.topit.DatabaseContent.Repository;
import com.example.topit.DatabaseContent.UserInfo;
import com.example.topit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeBodyStats extends Fragment {
    EditText editMyName,editHeight,editWeight,editBodyFat,editBiceps,editForearms,editChest,editWaist,editThighs,editCalves;
    private Repository repository;

    private LiveData<UserInfo> userInfo;
    private FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private DatabaseReference myRef;

    public ChangeBodyStats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_change_body_stats, container, false);

        repository = new Repository(this.getContext());
        mAuth =FirebaseAuth.getInstance();


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Log.d(TAG, "onAuthStateChanged: signed_in:" + user.getUid());
                    // Toast.makeText(getActivity(),"Successfully signed in with: "+user.getEmail(),Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d(TAG,"onAuthStateChanged: signed_out:");
                    //Toast.makeText(getActivity(),"Successfully signed out",Toast.LENGTH_SHORT).show();
                }
            }
        };




        editMyName = (EditText) v.findViewById(R.id.editName);
        editHeight = (EditText) v.findViewById(R.id.editHeight);
         editWeight = (EditText) v.findViewById(R.id.editWeight);
         editBodyFat = (EditText) v.findViewById(R.id.editBodyFat);
         editBiceps = (EditText) v.findViewById(R.id.editBiceps);
         editForearms = (EditText) v.findViewById(R.id.editForearms);
         editChest = (EditText) v.findViewById(R.id.editChest);
         editWaist = (EditText) v.findViewById(R.id.editWaist);
         editThighs = (EditText) v.findViewById(R.id.editThighs);
         editCalves = (EditText) v.findViewById(R.id.editCalves);
        ImageView ok1 = (ImageView) v.findViewById(R.id.ap1);
        ImageView ok2 = (ImageView) v.findViewById(R.id.ap2);
        ImageView ok3 = (ImageView) v.findViewById(R.id.ap3);
        ImageView ok4 = (ImageView) v.findViewById(R.id.ap4);
        ImageView ok5 = (ImageView) v.findViewById(R.id.ap5);
        ImageView ok6 = (ImageView) v.findViewById(R.id.ap6);
        ImageView ok7 = (ImageView) v.findViewById(R.id.ap7);
        ImageView ok8 = (ImageView) v.findViewById(R.id.ap8);
        ImageView ok9 = (ImageView) v.findViewById(R.id.ap9);
        ImageView ok10 = (ImageView) v.findViewById(R.id.ap10);

        ok1.setOnClickListener(handleClick);
        ok2.setOnClickListener(handleClick);

        FirebaseUser user = mAuth.getCurrentUser();
        String userID = user.getUid();

        return v;
    }

    public void updateName() {
        String name = editMyName.getText().toString();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        Log.d("update", " id: " + id);
        repository.updateUserName(id, name);
        Log.d("update", " name was updated ");
    }

    public void onResume() {
        super.onResume();
        getActivity().setTitle("Change your body stats");
    }

    private View.OnClickListener handleClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ap1:
                    updateName();

                    break;
                case R.id.ap2:

                    break;

            }

        }


    };



    @Override
    public void onStart() {

        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }
    @Override
    public void onStop(){
        super.onStop();
        if(mAuthStateListener != null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }

    }

}
