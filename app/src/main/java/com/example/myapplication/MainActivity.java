package com.example.myapplication;

import android.support.v4.app.Fragment;

import com.bwie.tablayout.BaseFragmentActivity;
import com.example.myapplication.fragment.Feagment01;
import com.example.myapplication.fragment.Feagment02;
import com.example.myapplication.fragment.Feagment03;
import com.example.myapplication.fragment.Feagment04;

public class MainActivity extends BaseFragmentActivity{
    @Override
    public int setlayout() {
        return R.layout.activity_main;
    }

    @Override
    public int settablayoutId() {
        return R.id.tab;
    }

    @Override
    public int setFragmentId() {
        return R.id.framgent;
    }

    @Override
    public String[] settitle() {
        return new String[]{"月光茶人","优惠","购物车","我的"};
    }

    @Override
    public int[] setimg() {
        return new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    }

    @Override
    public Fragment getFragment(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Feagment01();
                break;
            case 1:
                fragment = new Feagment02();
                break;
            case 2:
                fragment = new Feagment03();
                break;
            case 3:
                fragment = new Feagment04();
                break;
        }
        return fragment;
    }
}
