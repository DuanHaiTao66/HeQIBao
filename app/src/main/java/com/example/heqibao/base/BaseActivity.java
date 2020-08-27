package com.example.heqibao.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.heqibao.contract.IBaseView;
import com.jaeger.library.StatusBarUtil;

public abstract class BaseActivity<P extends BasePresenter>extends AppCompatActivity implements IBaseView {
    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        if (getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        StatusBarUtil.setTransparent(this);
        presenter = initPresenter();
        if (presenter!=null) {
            presenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null) {
            presenter.deatch();
        }
    }
}
