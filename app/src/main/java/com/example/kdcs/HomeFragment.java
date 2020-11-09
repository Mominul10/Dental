package com.example.kdcs;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ViewFlipper viewFlipper;
    FragmentManager fragmentManager;
    ImageView imageView, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;


    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageView1 = view.findViewById(R.id.datporiskar);
        imageView = view.findViewById(R.id.dadt);
        imageView2 = view.findViewById(R.id.rootcanal);
        imageView3 = view.findViewById(R.id.dadsil);
        imageView4 = view.findViewById(R.id.dadbandai);
        imageView5 = view.findViewById(R.id.kid);
        imageView6 = view.findViewById(R.id.other);


        //Image Silder
        int[] img = {R.drawable.img1, R.drawable.img2, R.drawable.img3};
        viewFlipper = (ViewFlipper) view.findViewById(R.id.viewflip);
        for (int i = 0; i < img.length; i++) {
            // This will create dynamic image views and add them to the ViewFlipper.
            setFlipperImage(img[i]);
        }


        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main8Activity.class);
                startActivity(intent);

            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main7Activity.class);
                startActivity(intent);

            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main6Activity.class);
                startActivity(intent);

            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main5Activity.class);
                startActivity(intent);

            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main4Activity.class);
                startActivity(intent);

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                startActivity(intent);


            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main3Activity.class);
                startActivity(intent);
            }
        });
        return view;


    }

    //Image Silder Method
    private void setFlipperImage(int res) {
        Log.i("Set Filpper Called", res + "");
        ImageView image = new ImageView(getContext());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
    }

}
