package com.example.milkaggregatorapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class profileFragment extends Fragment{

    ImageView cover;
    ImageView fav;
    EditText name,mobile,address;
    EditText name1,mobile1,address1;
    TextView button;
    Intent intent;

    public static final String EXTRA_NAME="name";
    public static final String EXTRA_NUMBER="number";
    public static final String EXTRA_ADDRESS="address";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        cover = (ImageView) view.findViewById(R.id.profile_image);
        fav = (ImageView) view.findViewById(R.id.floatingActionButton);

        name = (EditText) view.findViewById(R.id.entername);
        mobile = (EditText) view.findViewById(R.id.entern0);
        address = (EditText) view.findViewById(R.id.enteradd);
        button=(TextView)view.findViewById(R.id.del);

        intent = new Intent(getActivity(), selection.class);

        name1 = (EditText) view.findViewById(R.id.entername);
        mobile1 = (EditText) view.findViewById(R.id.entern0);
        address1 = (EditText) view.findViewById(R.id.enteradd);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name= name1.getText().toString();
//                String number= mobile1.getText().toString();
//                String address= address1.getText().toString();
//
//                intent.putExtra(EXTRA_NAME,name);
//                intent.putExtra(EXTRA_NUMBER,number);
//                intent.putExtra(EXTRA_ADDRESS,address);
//                startActivity(intent);
//            }
//        });
//






        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ImagePicker.with(profileFragment.this)
                        .crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


            Uri selectedImg = data.getData();

            cover.setImageURI(selectedImg);
        }

    public void performEditProfile (View v) {


            // Input is valid, here send data to your server

            String firstName = name.getText().toString();
            String lastName = mobile.getText().toString();
            String email = address.getText().toString();


//            Toast.makeText(this,"Profile Update Successfully",Toast.LENGTH_SHORT).show();
            // Here you can call you API


    }
    }