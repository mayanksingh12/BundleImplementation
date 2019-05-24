package com.example.bundleimplementation;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Fragment1.Message, Fragment2.Message {

    Fragment1 fragment1;
    Fragment2 fragment2;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.ContainerA,fragment1);
//        fragmentTransaction.add(R.id.ContainerB,fragment2);
//        fragmentTransaction.commit();


        fragment1= (Fragment1) fragmentManager.findFragmentByTag("tag1");
        if(fragment1==null)
        {
            fragment1=new Fragment1();
            fragmentTransaction.add(R.id.ContainerA, fragment1, "tag1");
        }
        fragment2= (Fragment2) fragmentManager.findFragmentByTag("tag2");
        if(fragment2==null)
        {
            fragment2=new Fragment2();
            fragmentTransaction.add(R.id.ContainerB, fragment2, "tag2");
        }



        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        editText = findViewById(R.id.edt2);


    }




    @Override
    public void buttonClick(String data) {
        fragment2.send(data);
    }


    @Override
    public void Recieve(String data) {

        fragment1.recieve(data);

    }
}

