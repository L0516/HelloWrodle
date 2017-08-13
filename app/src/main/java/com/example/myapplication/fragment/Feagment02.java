package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.FragAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘文艺 on 2017/8/1.
 */

public class Feagment02 extends Fragment {
    private TabLayout tabLayout;
    private ViewPager pager;
    private List<String> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02,container,false);
        tabLayout = (TabLayout) view.findViewById(R.id.f2_tab);
        pager = (ViewPager) view.findViewById(R.id.f2_pager);

        list = new ArrayList<String>();
        list.add("天天优惠");
        list.add("为你精选");
        list.add("亲的最爱");
        pager.setAdapter(new FragAdapter(getActivity().getSupportFragmentManager(),list));
        tabLayout.setupWithViewPager(pager);





        return view;
    }
}
