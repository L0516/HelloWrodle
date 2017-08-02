package com.example.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.bwie.tablayout.BaseFragmentActivity;

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
        return new int[]{R.drawable.tab_home_s,R.drawable.tab_topic_s,R.drawable.main_index_cart_pressed,R.drawable.main_index_my_pressed};
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
