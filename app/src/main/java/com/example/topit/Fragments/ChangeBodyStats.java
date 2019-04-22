package com.example.topit.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.topit.DatabaseContent.User;
import com.example.topit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeBodyStats extends Fragment {
    EditText editMyName,editHeight,editWeight,editBodyFat,editBiceps,editForearms,editChest,editWaist,editThighs,editCalves;
    DatabaseReference dtName, dtHeight;
            


    public ChangeBodyStats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_change_body_stats, container, false);
        dtName = FirebaseDatabase.getInstance().getReference().child("name");
        dtHeight = FirebaseDatabase.getInstance().getReference().child("height");


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


        return v;
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
                    editName();
                    break;
                case R.id.ap2:
                    editHeight();
                    break;

            }

        }


    };

    private void editName(){

        String name = editMyName.getText().toString().trim();
        User user = new User();
        user.setUserName(name);

        if(!TextUtils.isEmpty(name)){


            dtName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(name);

        }else{
            Toast.makeText(getActivity(),"Please enter name",Toast.LENGTH_LONG).show();
        }

    }
    private void editHeight(){
        String height = editHeight.getText().toString().trim();

        if(!TextUtils.isEmpty(height)){

            dtHeight.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(height);
        }
        else{
            Toast.makeText(getActivity(),"Please enter height",Toast.LENGTH_LONG).show();
        }

    }

}
