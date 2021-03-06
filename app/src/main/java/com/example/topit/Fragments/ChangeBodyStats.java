package com.example.topit.Fragments;


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
import com.example.topit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeBodyStats extends Fragment {
    EditText editMyName,editHeight,editWeight,editBodyFat,editBiceps,editForearms,editChest,editWaist,editThighs,editCalves;
    private Repository repository;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


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
        ok3.setOnClickListener(handleClick);
        ok4.setOnClickListener(handleClick);
        ok5.setOnClickListener(handleClick);
        ok6.setOnClickListener(handleClick);
        ok7.setOnClickListener(handleClick);
        ok8.setOnClickListener(handleClick);
        ok9.setOnClickListener(handleClick);
        ok10.setOnClickListener(handleClick);


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

    public void updateHeight(){
        String height = editHeight.getText().toString();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        Log.d("update", " id: " + id);
        repository.updateUserHeight(id, height);
        Log.d("update", " height was updated ");

    }

    public void updateWeight(){
        String weight = editWeight.getText().toString();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        Log.d("update", " id: " + id);
        repository.updateUserWeight(id, weight);
        Log.d("update", " weight was updated ");

    }
    public void updateBodyFat(){
        String bodyFat = editBodyFat.getText().toString();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        Log.d("update", " id: " + id);
        repository.updateUserBodyFat(id, bodyFat);
        Log.d("update", " body fat was updated ");

    }
    public void updateBicep(){
        String bicep = editBiceps.getText().toString();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        Log.d("update", " id: " + id);
        repository.updateUserBicep(id, bicep);
        Log.d("update", " bicep was updated ");

    }
    public void updateForearm(){
        String forearm = editForearms.getText().toString();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        Log.d("update", " id: " + id);
        repository.updateUserForearm(id, forearm);
        Log.d("update", " forearm was updated ");

    }
    public void updateChest(){
        String chest = editChest.getText().toString();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        Log.d("update", " id: " + id);
        repository.updateUserChest(id, chest);
        Log.d("update", " chest was updated ");

    }
    public void updateWaist(){
        String waist = editWaist.getText().toString();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        Log.d("update", " id: " + id);
        repository.updateUserWaist(id,waist);
        Log.d("update", " waist was updated ");

    }
    public void updateThighs(){
        String thigh = editThighs.getText().toString();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        Log.d("update", " id: " + id);
        repository.updateUserThigh(id,thigh);
        Log.d("update", " thighs were updated ");

    }
    public void updateCalves(){
        String calves = editCalves.getText().toString();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        Log.d("update", " id: " + id);
        repository.updateUserCalves(id,calves);
        Log.d("update", " calves were updated ");

    }



    private View.OnClickListener handleClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ap1:

                    updateName();
                    editMyName.getText().clear();
                    break;
                case R.id.ap2:
                    updateHeight();
                    editHeight.getText().clear();
                    break;
                case R.id.ap3:
                   updateWeight();
                    editWeight.getText().clear();
                    break;
                case R.id.ap4:
                    updateBodyFat();
                    editBodyFat.getText().clear();
                    break;
                case R.id.ap5:
                    updateBicep();
                    editBiceps.getText().clear();
                    break;
                case R.id.ap6:
                    updateForearm();
                    editForearms.getText().clear();
                    break;
                case R.id.ap7:
                    updateChest();
                    editChest.getText().clear();
                    break;
                case R.id.ap8:
                    updateWaist();
                    editWaist.getText().clear();
                    break;
                case R.id.ap9:
                    updateThighs();
                    editThighs.getText().clear();
                    break;
                case R.id.ap10:
                    updateCalves();
                    editCalves.getText().clear();
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
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Change your body stats");
    }

}
