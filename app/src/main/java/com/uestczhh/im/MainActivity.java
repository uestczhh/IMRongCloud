package com.uestczhh.im;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,RongIM.UserInfoProvider{

    private Button btn10086;
    private Button btn10000;
    private Button btnList;

    private String token10086 = "VsSDQp5WSw0P+1C+6klMam5NufDTVH3eS7Ci87uCIeNI0/wbYduVSQLjm8W/onGGynUoVAX+SOp7x011eeeafg==";
    private String token10000 = "8c1a53XtmwU6KD5CM7dP5m5NufDTVH3eS7Ci87uCIeNI0/wbYduVSR81rZW5I0X//enizH+ZA+rOiN0LFtsgEA==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        RongIM.setUserInfoProvider(this,true);

    }

    private void initView() {
        btn10086 = (Button) findViewById(R.id.btn_one);
        btn10000 = (Button) findViewById(R.id.btn_two);
        btnList = (Button) findViewById(R.id.btn_three);
        btn10086.setOnClickListener(this);
        btn10000.setOnClickListener(this);
        btnList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                connect10086();
                break;
            case R.id.btn_two:
                connect10000();
                break;
            case R.id.btn_three:
//                RongIM.getInstance().startPrivateChat(MainActivity.this, "10000", "聊天");
                break;
        }
    }

    private void connect10086() {
        RongIM.connect(token10086, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {

            }

            @Override
            public void onSuccess(String userId) {
                Log.e("MainActivity", "——onSuccess—-" + userId);
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e("MainActivity", "——onError—-" + errorCode);
            }
        });
    }

    private void connect10000() {
        RongIM.connect(token10000, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {

            }

            @Override
            public void onSuccess(String userId) {
                Log.e("MainActivity", "——onSuccess—-" + userId);
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e("MainActivity", "——onError—-" + errorCode);
            }
        });
    }

    @Override
    public UserInfo getUserInfo(String s) {
        return null;
    }
}
