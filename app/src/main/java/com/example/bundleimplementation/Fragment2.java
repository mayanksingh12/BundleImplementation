package com.example.bundleimplementation;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment2 extends Fragment {

     String TAG ="some" ;
    EditText editText;
    Button button;
    Message message;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, " frag2 onCreateView:");

        View v= inflater.inflate(R.layout.fragment_fragment2, container, false);

        editText=v.findViewById(R.id.edt2);
      button=v.findViewById(R.id.bt2);
        return  v;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        EditText editText1=editText.findViewById(R.id.edt2);
        outState.putString("two", String.valueOf(editText1));


    }

    public void send(String data) {

   editText.setText(data);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        message= (Message) context;
        Log.d(TAG, " frag2 onAttach:");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, " frag2 onCreate:");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, " frag2 onStart:");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, " frag2 onResume:");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, " frag2 onPause:");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, " frag2 onStop:");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, " frag2 onDestroyView:");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, " frag2 onDestroy:");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, " frag2 onDetach:");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                message.Recieve(editText.getText().toString());

            }
        });
        Log.d(TAG, " frag2 onActivityCreated:");
    }


    public interface Message
    {
        void Recieve(String data);
    }


}
