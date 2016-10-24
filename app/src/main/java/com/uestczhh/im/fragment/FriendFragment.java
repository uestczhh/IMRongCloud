package com.uestczhh.im.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.rong.imkit.RongIM;

/**
 * Created by zhanghao on 2016/10/24.
 */
public class FriendFragment extends Fragment {

    private static FriendFragment instance;

    public FriendFragment() {
    }

    public static FriendFragment getIntance() {
        if (instance == null) {
            instance = new FriendFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
        textView.setText("第三页");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RongIM.getInstance().startPrivateChat(getActivity(), "10000", "聊天");
            }
        });
        return textView;
    }
}
