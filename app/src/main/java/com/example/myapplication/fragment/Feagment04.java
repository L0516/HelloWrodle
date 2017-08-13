package com.example.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.LogActivity;
import com.example.myapplication.R;

/**
 * Created by 刘文艺 on 2017/8/1.
 */

public class Feagment04 extends Fragment {
    private ImageView imageView,head;
    private TextView textView,bank;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment04,container,false);
        imageView = (ImageView) view.findViewById(R.id.imageView3);
        head = (ImageView) view.findViewById(R.id.headphoto);
        textView = (TextView) view.findViewById(R.id.phone);
        bank = (TextView) view.findViewById(R.id.tuichu);
        head.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        bank.setVisibility(View.INVISIBLE);
        sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        editor = sp.edit();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), LogActivity.class);
                startActivity(it);
            }
        });
        bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                imageView.setVisibility(View.VISIBLE);
                head.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                bank.setVisibility(View.INVISIBLE);
            }
        });


        return view;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//    }

    @Override
    public void onResume() {
        super.onResume();
        String code = sp.getString("code","0");
//        Toast.makeText(getActivity(),code+"",Toast.LENGTH_SHORT).show();
        if ("1".equals(code)){
            imageView.setVisibility(View.INVISIBLE);
            head.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
            bank.setVisibility(View.VISIBLE);
            Glide.with(getActivity()).load(sp.getString("img",null)).into(head);
            textView.setText(sp.getString("name",null));
        }
    }
}
