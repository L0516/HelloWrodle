package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.bean.LogBean;
import com.google.gson.Gson;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class LogActivity extends AppCompatActivity {
    private EditText name,pass;
    private Button button;
    private String path = "http://api.eleteam.com/v1/user/login";
    private DbManager dbManager;
    //    1225515453

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        init();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString()==null||pass.getText().toString()==null){
                    Toast.makeText(LogActivity.this,"请输入用户名或密码",Toast.LENGTH_SHORT).show();
                }else {
                    getHttp(name.getText().toString(),pass.getText().toString());
                }
            }
        });
    }

    public void init(){
        name = (EditText) findViewById(R.id.log_name);
        pass = (EditText) findViewById(R.id.log_pass);
        button = (Button) findViewById(R.id.log_but);
    }

    public void onLog(View view){
        finish();
    }
    public void getHttp(String name,String pass){
        RequestParams params = new RequestParams(path);
        params.addQueryStringParameter("mobile",name);
        params.addQueryStringParameter("password",pass);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                LogBean logBean = gson.fromJson(result, LogBean.class);
                Toast.makeText(LogActivity.this,logBean.getMessage(),Toast.LENGTH_SHORT).show();
                if (logBean.getCode()==1){
                    SharedPreferences sp = getSharedPreferences("user",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("img",logBean.getData().getUser().getAvatar());
                    editor.putString("name",logBean.getData().getUser().getMobile());
                    editor.putString("code",logBean.getCode()+"");
                    editor.putString("app_cart_cookie_id","9bd77a42ab439b618d51b99ed28f801b");
                    editor.putString("access_token","TW5yIGDt5rYDnualXyp6A4rdQNpZoSKQ");
                    editor.putString("user_id",logBean.getData().getUser().getId()+"");
                    editor.commit();
                    finish();
                }
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
