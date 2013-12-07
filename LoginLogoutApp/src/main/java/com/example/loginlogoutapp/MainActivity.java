package com.example.loginlogoutapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.Window;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        FragmentLogin loginFragment = new FragmentLogin();

        transaction.add(R.id.content, loginFragment);
        transaction.commit();

    }

    public void changeFragment(View view){

        Fragment newFragment;

        if( view == findViewById(R.id.btnLogin)){
            newFragment = new FragmentLogin();
        }
        else  if(view == findViewById(R.id.btnRegister)){
            newFragment = new FragmentRegister();
        }
        else {
            newFragment = new FragmentLogin();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
