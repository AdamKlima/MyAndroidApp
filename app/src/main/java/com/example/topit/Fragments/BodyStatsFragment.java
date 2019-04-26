package com.example.topit.Fragments;


import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topit.DatabaseContent.User;
import com.example.topit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class BodyStatsFragment extends Fragment{

    private FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private DatabaseReference myRef;
    private String userID;


    FloatingActionButton fab;
    TextView nameToChange, heigthToChange, weightToChange;
   /* private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference().child("name");
    private DatabaseReference mNameRef = mRootReference.child("name");*/

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


        ImageView qm1 = (ImageView) v.findViewById(R.id.qm1);
        ImageView qm2 = (ImageView) v.findViewById(R.id.qm2);
        ImageView qm3 = (ImageView) v.findViewById(R.id.qm3);
        ImageView qm4 = (ImageView) v.findViewById(R.id.qm4);
        ImageView qm5 = (ImageView) v.findViewById(R.id.qm5);
        ImageView qm6 = (ImageView) v.findViewById(R.id.qm6);


    qm1.setOnClickListener(handleClick);
    qm2.setOnClickListener(handleClick);
    qm3.setOnClickListener(handleClick);
    qm4.setOnClickListener(handleClick);
    qm5.setOnClickListener(handleClick);
    qm6.setOnClickListener(handleClick);



    weightToChange = (TextView)v.findViewById(R.id.weightChange);
    heigthToChange = (TextView)v.findViewById(R.id.heightChange);
    nameToChange = (TextView) v.findViewById(R.id.nameChange);
    mAuth =FirebaseAuth.getInstance();
    mFirebaseDatabase = FirebaseDatabase.getInstance();
    myRef = mFirebaseDatabase.getReference();
    FirebaseUser user = mAuth.getCurrentUser();
    userID = user.getUid();

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
                Toast.makeText(getActivity(),"Successfully signed out",Toast.LENGTH_SHORT).show();
            }
        }
    };

    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange( DataSnapshot dataSnapshot) {

            showData(dataSnapshot);

        }

        @Override
        public void onCancelled( DatabaseError databaseError) {

        }
    });





        return v;
    }

    private void showData(DataSnapshot dataSnapshot){
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            User userInfo = new User();

            userInfo.setUserName(ds.child(userID).getValue(User.class).getUserName());
            userInfo.setUserHeight(ds.child(userID).getValue(User.class).getUserHeight());

            nameToChange.setText(userInfo.getUserName());
            heigthToChange.setText(userInfo.getUserHeight());
            weightToChange.setText(userInfo.getUserWeight());



        }

    }

    private View.OnClickListener handleClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.qm1:
                    Toast.makeText(getActivity(),"Measure at the thickest part of the bicep", Toast.LENGTH_LONG).show();
                    break;
                case R.id.qm2:
                    Toast.makeText(getActivity(),"Measure at the widest part of your forearms", Toast.LENGTH_LONG).show();
                    break;
                case R.id.qm3:
                    Toast.makeText(getActivity(),"Wrap the measure around your chest and place it under your armpits", Toast.LENGTH_LONG).show();
                    break;
                case R.id.qm4:
                    Toast.makeText(getActivity(),"Measure at the top of your hips and the base of your rib cage", Toast.LENGTH_LONG).show();
                    break;
                case R.id.qm5:
                    Toast.makeText(getActivity(),"Wrap the tape around the thickest part of your thigh", Toast.LENGTH_LONG).show();
                    break;
                case R.id.qm6:
                    Toast.makeText(getActivity(),"Wrap the tape around the thickest part of your calf", Toast.LENGTH_LONG).show();
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
