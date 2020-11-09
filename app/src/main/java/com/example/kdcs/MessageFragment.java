package com.example.kdcs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    DatabaseReference databaseReference;
    Button button;
    EditText editText, editText1,editText2,editText3,editText4;
    AlertDialog.Builder alertbilder;


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_message, container, false);
        editText = view.findViewById(R.id.s1);
        editText1 = view.findViewById(R.id.s2);
        editText3 = view.findViewById(R.id.s3);
        editText2 = view.findViewById(R.id.s4);
        editText4 = view.findViewById(R.id.s5);




        //FireBaseDelecare
        databaseReference = FirebaseDatabase.getInstance().getReference("Serial");

        button = view.findViewById(R.id.send);
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        String name = editText.getText().toString().trim();
                        String age = editText1.getText().toString().trim();
                        String phone = editText2.getText().toString().trim();
                        String address = editText3.getText().toString().trim();
                        String date = editText4.getText().toString().trim();

                        if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(age)&&!TextUtils.isEmpty(phone)&&!TextUtils.isEmpty(address)&&!TextUtils.isEmpty(date)){
                            String key = databaseReference.push().getKey();
                            pasent Pasent = new pasent(name,age,address,date,phone);
                            databaseReference.child(key).setValue(Pasent);
                            Toast.makeText(getContext(),"আপনার সিরিয়াল দেওয়া হয়েছে।। \n ধন্যবাদ ",Toast.LENGTH_LONG).show();
                            editText.setText("");
                            editText1.setText("");
                            editText2.setText("");
                            editText3.setText("");
                            editText4.setText("");
                        }
                        else if (TextUtils.isEmpty(name)&&TextUtils.isEmpty(age)&&TextUtils.isEmpty(phone)&&TextUtils.isEmpty(address)&&TextUtils.isEmpty(date)){
                            Toast.makeText(getContext(),"ফরমটি সঠিক ভাবে পূরণ করুন",Toast.LENGTH_LONG).show();
                        }
                }
            });

        } else {
            alertbilder = new AlertDialog.Builder(getActivity());
            alertbilder.setTitle("ইন্টারনেট");
            alertbilder.setMessage("ইন্টারনেট সংযোগটি অন করুন");
            alertbilder.setIcon(R.drawable.ic);
            alertbilder.setPositiveButton("ওকে", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    WifiManager wifi = (WifiManager)getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);

                }
            });
            AlertDialog alertDialog = alertbilder.create();
            alertDialog.show();
        }

        return view;
        }

    }


