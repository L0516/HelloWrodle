package com.bwie.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * 类描述 ：
 * 创建人 ：刘洋
 * 时间 ： 2017/6/30.
 */

public abstract class BaseFragmentActivity extends AppCompatActivity implements ITablayout{

    private TabLayout tabLayout;
    private Fragment[] fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setlayout());
        tabLayout = (TabLayout) findViewById(settablayoutId());
        if (settitle()!=null){
            fragments = new Fragment[settitle().length];
            for (int i=0;i<settitle().length;i++){
                TabLayout.Tab tab = tabLayout.newTab();
                tab.setText(settitle()[i]);
                if (setimg()!=null&&i<setimg().length){
                    tab.setIcon(setimg()[i]);
                }
                tabLayout.addTab(tab);
            }
        }
        showFragment(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                showFragment(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void showFragment(int position) {
        Fragment fragment = fragments[position];
        if (fragment==null){
            fragment = getFragment(position);
            fragments[position] = fragment;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(setFragmentId(),fragment)
                .commit();
    }

}
