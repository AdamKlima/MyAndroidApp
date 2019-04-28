package com.example.topit.Fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.topit.DatabaseContent.Repository;
import com.example.topit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class BodyStatsFragment extends Fragment{

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private Repository repository;
    FloatingActionButton fab;
    TextView nameToChange, heigthToChange, weightToChange,bodyFatChange, bicepChange, forearmChange, chestChange, waistCHange, thighChange, calvesChange;


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

        repository= new Repository(this.getContext());


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
    bodyFatChange = (TextView) v.findViewById(R.id.bodyFatChange);
    bicepChange = (TextView) v.findViewById(R.id.bicepsChange);
    forearmChange = (TextView) v.findViewById(R.id.forearmnsChange);
    chestChange = (TextView) v.findViewById(R.id.chestChange);
    waistCHange = (TextView) v.findViewById(R.id.waistChange);
    thighChange = (TextView) v.findViewById(R.id.thighsChange);
    calvesChange= (TextView) v.findViewById(R.id.calvesChange);

    mAuth =FirebaseAuth.getInstance();

    initName();
    initHeight();
    initWeight();
    initBodyFat();
    initBicep();
    initForearm();
    initChest();
    initWaist();
    initThigh();
    initCalves();

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
        return v;
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



    private void initName() {
        new SetUserNameAsync().execute();
    }


     class SetUserNameAsync extends AsyncTask<Void, Void, Void> {

        public SetUserNameAsync() {}

        @Override
        protected Void doInBackground(Void... voids) {
            String id = mAuth.getCurrentUser().getUid();
            final String name = repository.getUser(id).getName();
            BodyStatsFragment.this.getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    nameToChange.setText(name);
                }
            });

            return null;
        }
    }

    private void initHeight(){
        new SetUserHeightAsync().execute();
    }

    class SetUserHeightAsync extends AsyncTask<Void, Void, Void>{

        public SetUserHeightAsync(){}

        @Override
        protected Void doInBackground(Void... voids) {
            String id = mAuth.getCurrentUser().getUid();
            final String height = repository.getUser(id).getHeight();
            BodyStatsFragment.this.getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    heigthToChange.setText(height+ " cm");
                }
            });
            return null;
        }
    }

    private void initWeight(){
        new SetUserWeightAsync().execute();
    }

    class SetUserWeightAsync extends AsyncTask<Void, Void, Void>{

        public SetUserWeightAsync(){}

        @Override
        protected Void doInBackground(Void... voids) {
            String id = mAuth.getCurrentUser().getUid();
            final String weight = repository.getUser(id).getWeight();
            BodyStatsFragment.this.getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    weightToChange.setText(weight+ " kg");
                }
            });
            return null;
        }
    }

    private void initBodyFat(){
        new SetUserBodyFatAsync().execute();
    }

    class SetUserBodyFatAsync extends AsyncTask<Void, Void, Void>{

        public SetUserBodyFatAsync(){}

        @Override
        protected Void doInBackground(Void... voids) {
            String id = mAuth.getCurrentUser().getUid();
            final String bodyFat = repository.getUser(id).getBodyFat();
            BodyStatsFragment.this.getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    bodyFatChange.setText(bodyFat+"%");
                }
            });
            return null;
        }
    }

    private void initBicep(){new SetUserBicepAsync().execute();}

    class SetUserBicepAsync extends  AsyncTask<Void, Void, Void>{
        public SetUserBicepAsync(){}

        @Override
        protected Void doInBackground(Void... voids) {
            String id = mAuth.getCurrentUser().getUid();
            final String bicep = repository.getUser(id).getBicep();
            BodyStatsFragment.this.getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                   bicepChange.setText(bicep+" cm");
                }
            });
            return null;
        }

    }
    private void initForearm(){new SetUserForearmAsync().execute();}
    class SetUserForearmAsync extends  AsyncTask<Void, Void, Void>{
        public SetUserForearmAsync(){}

        @Override
        protected Void doInBackground(Void... voids) {
            String id = mAuth.getCurrentUser().getUid();
            final String forearm = repository.getUser(id).getForearm();
            BodyStatsFragment.this.getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    forearmChange.setText(forearm+" cm");
                }
            });
            return null;
        }

    }
    private void initChest(){new SetUserChestAsync().execute();}
    class SetUserChestAsync extends  AsyncTask<Void, Void, Void>{
        public SetUserChestAsync(){}

        @Override
        protected Void doInBackground(Void... voids) {
            String id = mAuth.getCurrentUser().getUid();
            final String chest = repository.getUser(id).getChest();
            BodyStatsFragment.this.getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    chestChange.setText(chest+" cm");
                }
            });
            return null;
        }

    }
    private void initWaist(){new SetUserWaistAsync().execute();}
    class SetUserWaistAsync extends  AsyncTask<Void, Void, Void>{
        public SetUserWaistAsync(){}

        @Override
        protected Void doInBackground(Void... voids) {
            String id = mAuth.getCurrentUser().getUid();
            final String waist = repository.getUser(id).getWaist();
            BodyStatsFragment.this.getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    waistCHange.setText(waist+" cm");
                }
            });
            return null;
        }

    }
    private void initThigh(){new SetUserThighAsync().execute();}
    class SetUserThighAsync extends  AsyncTask<Void, Void, Void>{
        public SetUserThighAsync(){}

        @Override
        protected Void doInBackground(Void... voids) {
            String id = mAuth.getCurrentUser().getUid();
            final String thigh = repository.getUser(id).getThighs();
            BodyStatsFragment.this.getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    thighChange.setText(thigh+" cm");
                }
            });
            return null;
        }

    }
    private void initCalves(){ new SetUserCalvesAsync().execute();}
    class SetUserCalvesAsync extends  AsyncTask<Void, Void, Void>{
        public SetUserCalvesAsync(){}

        @Override
        protected Void doInBackground(Void... voids) {
            String id = mAuth.getCurrentUser().getUid();
            final String calves = repository.getUser(id).getCalves();
            BodyStatsFragment.this.getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    calvesChange.setText(calves+" cm");
                }
            });
            return null;
        }

    }



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
