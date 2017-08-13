package com.example.myapplication.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.LogActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ShopCarAdapter;
import com.example.myapplication.bean.ShopCarBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by 刘文艺 on 2017/8/1.
 */

public class Feagment03 extends Fragment {
    private ListView listView;
    private TextView jiage;
    private TextView jiesuan;
    private TextView qvdenglu;
    private ImageView tishi;
//    private String path = "http://api.eleteam.com/v1/cart";
    String path = "http://api.eleteam.com/v1/cart?access_token=TW5yIGDt5rYDnualXyp6A4rdQNpZoSKQ&app_cart_cookie_id=9bd77a42ab439b618d51b99ed28f801b&user_id=158&_terminal_type=Android";
    private SharedPreferences sp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment03,container,false);
        init(view);
        sp = getActivity().getSharedPreferences("user", MODE_PRIVATE);
        String code = sp.getString("code", "0");
        if ("1".equals(code)){
            listView.setVisibility(View.VISIBLE);
            jiesuan.setVisibility(View.VISIBLE);
            jiage.setVisibility(View.VISIBLE);
            qvdenglu.setVisibility(View.INVISIBLE);
            tishi.setVisibility(View.INVISIBLE);
            getHttp();

        }else {
            listView.setVisibility(View.INVISIBLE);
            jiesuan.setVisibility(View.INVISIBLE);
            jiage.setVisibility(View.INVISIBLE);
            qvdenglu.setVisibility(View.VISIBLE);
            tishi.setVisibility(View.VISIBLE);
        }
        qvdenglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), LogActivity.class);
                startActivity(it);
            }
        });
        return view;
    }

    public void getHttp(){
        RequestParams params = new RequestParams(path);
//        params.addQueryStringParameter("access_token",access_token);
//        params.addQueryStringParameter("app_cart_cookie_id",app_cart_cookie_id);
//        params.addQueryStringParameter("user_id",user_id);
//        params.addQueryStringParameter("terminal_type","Android");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ShopCarBean shopCarBean = gson.fromJson(result, ShopCarBean.class);
                List<ShopCarBean.DataBean.CartItemsBean> cartItems = shopCarBean.getData().getCartItems();
                listView.setAdapter(new ShopCarAdapter(getActivity(),cartItems,jiage,jiesuan));
//                Toast.makeText(getActivity(),logBean.getMessage(),Toast.LENGTH_SHORT).show();

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
    public void init(View view){
        listView = (ListView) view.findViewById(R.id.f3_listView);
        jiage = (TextView) view.findViewById(R.id.f3_jiage);
        jiesuan = (TextView) view.findViewById(R.id.f3_jiesuan);
        qvdenglu = (TextView) view.findViewById(R.id.f3_qvdenglu);
        tishi = (ImageView) view.findViewById(R.id.f3_tishi);
    }

    @Override
    public void onStart() {
        super.onStart();
        getHttp();
    }
}
