package com.tvlauncherdome;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.tvlauncherdome.fragment.AboutFragment;
import com.tvlauncherdome.fragment.HomeFragment;


public class MainActivity extends BaceActivity implements View.OnClickListener, View.OnFocusChangeListener {

    private Context context;

    private HomeFragment homeFragment;
    private AboutFragment aboutFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        setDefaultFragment();
    }

    private void initView() {


    }

    /**
     * 设置默认
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = new HomeFragment();
        aboutFragment = new AboutFragment();
        transaction.add(R.id.main_content, homeFragment);
        transaction.add(R.id.main_content, aboutFragment);
        transaction.show(homeFragment);
        transaction.hide(aboutFragment);
        transaction.commit();
    }

    /**
     * 设置显示关于我们页面
     */
    public void setVisibleFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(homeFragment);
        transaction.show(aboutFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }

}
