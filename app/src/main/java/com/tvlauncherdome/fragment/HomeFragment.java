package com.tvlauncherdome.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;


import com.tvlauncherdome.R;

import anim.ScaleAnimEffect;
import view.FlyBorderView;
import view.MainLayout;
import view.ShadowFrameLayout;

/**
 * Created by surge on 2017/11/15.
 */

public class HomeFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {

    private ScaleAnimEffect animEffect = new ScaleAnimEffect();
    private FlyBorderView mFlyBorderView = null;
    private MainLayout mMainLayout = null;
    private ShadowFrameLayout frameLayoutTv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,null);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        mFlyBorderView = (FlyBorderView) view.findViewById(R.id.flyBorder_view);
        mMainLayout = (MainLayout) view.findViewById(R.id.main_layout);
        frameLayoutTv=view.findViewById(R.id.frame_tv);
        for (int index = 0; index < mMainLayout.getChildCount(); index++) {
            mMainLayout.getChildAt(index).setOnFocusChangeListener(this);
            mMainLayout.getChildAt(index).setOnClickListener(this);
        }
    }


    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.frame_tv:
                Log.e("tv", "tv");
                break;

            case R.id.frame_myapp:

                break;

            case R.id.frame_center:

                break;

            case R.id.frame_setting:

                break;

            case R.id.frame_live:

                break;

            case R.id.frame_vod:

                break;

            case R.id.frame_app1:

                break;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        ViewGroup vp = (ViewGroup) view;
        if (b) {
            mFlyBorderView.setVisibility(View.VISIBLE);
            mFlyBorderView.setTvScreen(false);
            mFlyBorderView.setFocusView(vp.getChildAt(0), 1.20f);
            showOnFocusAnimation(view, 1.20f);
        } else {
            mFlyBorderView.setVisibility(View.INVISIBLE);
            showLoseFocusAnimation(view, 1.20f);
        }
    }

    private void showOnFocusAnimation(View v, float scale) {
        animEffect.setAttributs(1.0f, scale, 1.0f, scale, 100);
        Animation anim = animEffect.createAnimation();
        v.startAnimation(anim);
        v.bringToFront();
    }

    private void showLoseFocusAnimation(View v, float scale) {
        animEffect.setAttributs(scale, 1.0f, scale, 1.0f, 100);
        Animation anim = animEffect.createAnimation();
        v.startAnimation(anim);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            //重新显示时，焦点回到tv上
            frameLayoutTv.requestFocus();
        }
    }
}
