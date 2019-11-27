package com.example.s4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Main3Activity extends AppCompatActivity {
    BottomNavigationView navigation;
    FrameLayout frameLayout;

    private Fragment1 homeFragment;
    private Fragment3 profileFragment;
    private Fragment2 statsFragment;
    private Fragment4 assisFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        navigation=findViewById(R.id.bottomNavigationView);
        frameLayout=findViewById(R.id.frame_layout);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"ubuntulight.ttf",true);

        homeFragment=new Fragment1();
        profileFragment=new Fragment3();
        statsFragment=new Fragment2();
        assisFragment=new Fragment4();



        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new Fragment1()).commit();



        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        InitializeFragment(homeFragment);
                        return true;
                    case R.id.stats:
                        InitializeFragment(statsFragment);
                        return true;
                    case R.id.profile:
                        InitializeFragment(profileFragment);
                        return true;
                    case R.id.assignment:
                        InitializeFragment(assisFragment);
                        return true;
                }


                return false;
            }
        });



    }
    public void myClickMethod(View v) {
        assisFragment.myClickMethod(v);
    }


   private void InitializeFragment(Fragment fragment){
       FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
       fragmentTransaction.replace(R.id.frame_layout, fragment);
       fragmentTransaction.commit();


   }
}
