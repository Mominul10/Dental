package com.example.kdcs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Main9Activity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        viewFlipper =findViewById(R.id.viewfilpper);
        int [] pic = {R.drawable.l1,R.drawable.l2,R.drawable.l3,R.drawable.l4};
        for (int im : pic){
            filpperimg(im);

        }


    }

    private void filpperimg(int im) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(im);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
