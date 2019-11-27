package com.example.s4;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {
    Button bt;
    FirebaseAuth mFirebaseAuth;
    View view;




    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFirebaseAuth=FirebaseAuth.getInstance();



        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fragment3, container, false);


        bt=(Button)view.findViewById(R.id.button3);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });


    return view;

}}
