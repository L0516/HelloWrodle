package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘文艺 on 2017/8/1.
 */

public class Feagment01 extends Fragment {
    private ListView listView,listView2;

    private String path = "http://api.eleteam.com/v1/category/list-with-product";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01,container,false);
        listView = (ListView) view.findViewById(R.id.listView);
        listView2 = (ListView) view.findViewById(R.id.listView2);
        loatHttp();
        return view;
    }
    public void loatHttp(){
        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                FoodBean foodBean = gson.fromJson(result, FoodBean.class);
                final List<FoodBean.DataBean.CategoriesBean> categories = foodBean.getData().getCategories();
                List<String> list = new ArrayList<String>();
                for (FoodBean.DataBean.CategoriesBean fb:categories){
                    list.add(fb.getName());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_expandable_list_item_1,list);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        List<FoodBean.DataBean.CategoriesBean.ProductsBean> products = categories.get(position).getProducts();
                        listView2.setAdapter(new Base(getActivity(),products));
                    }
                });

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
