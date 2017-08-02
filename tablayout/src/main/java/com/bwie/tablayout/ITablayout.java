package com.bwie.tablayout;

import android.support.v4.app.Fragment;

/**
 * 类描述 ：
 * 创建人 ：刘洋
 * 时间 ： 2017/6/30.
 */

public interface ITablayout {

    int setlayout();

    int settablayoutId();
    int setFragmentId();

    String[] settitle();
    int[] setimg();

    Fragment getFragment(int position);

}
