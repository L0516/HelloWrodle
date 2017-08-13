package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.YouAdapter;
import com.example.myapplication.bean.YouHuiBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by 刘文艺 on 2017/8/1.
 */

public class Feagment02_f1 extends Fragment {

    public static Feagment02_f1 newInstance(String text){
        Bundle bundle = new Bundle();
        bundle.putString("text",text);
        Feagment02_f1 blankFragment = new Feagment02_f1();
        blankFragment.setArguments(bundle);
        return  blankFragment;
    }

    private String ttyh = "http://api.eleteam.com/v1/product/list-featured-price";
    private String wnjx = "http://api.eleteam.com/v1/product/list-featured-topic";
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02_f1,container,false);
        listView = (ListView) view.findViewById(R.id.f2_list);
        String text = getArguments().getString("text");
        if ("天天优惠".equals(text)){
            loatHttp(ttyh);

        }else if ("为你精选".equals(text)){
            loatHttp(wnjx);

        }else if ("亲的最爱".equals(text)){

        }

        return view;
    }

    public void loatHttp(String path){
        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                YouHuiBean youHuiBean = gson.fromJson(result, YouHuiBean.class);
                List<YouHuiBean.DataBean.ProductsBean> products = youHuiBean.getData().getProducts();
                listView.setAdapter(new YouAdapter(getActivity(),products));
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }




}
