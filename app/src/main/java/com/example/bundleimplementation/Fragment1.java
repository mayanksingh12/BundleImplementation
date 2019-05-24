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


public class Fragment1 extends Fragment {

     String TAG ="some" ;
    Message message;
EditText et;
Button bt;

    public Fragment1() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, " frag1 onCreateView:");

        View v= inflater.inflate(R.layout.fragment_fragment1, container, false);

  et=v.findViewById(R.id.edt1);
 bt=v.findViewById(R.id.bt1);


 setRetainInstance(true);

        return  v;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText ets=et.findViewById(R.id.edt1);
         outState.getString("sh", String.valueOf(ets));

    }



//    @Override
//    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
//        super.onViewStateRestored(savedInstanceState);
//
//       et.setText(savedInstanceState.getString("sh"));
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        message= (Message) context;
        Log.d(TAG, " frag1 onAttach:");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, " frag1 onCreate:");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, " frag1 onStart:");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, " frag1 onResume:");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, " frag1 onPause:");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, " frag1 onStop:");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, " frag1 onDestroyView:");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, " frag1 onDestroy:");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, " frag1 onDetach:");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d(TAG, " frag1 onActivityCreated:");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.buttonClick(et.getText().toString());

            }
        });


    }

    public void recieve(String data) {

        et.setText(data);
    }

    public interface Message
    {
        void buttonClick(String data);

    }

}
