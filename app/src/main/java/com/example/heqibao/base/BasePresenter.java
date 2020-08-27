package com.example.heqibao.base;

import com.example.heqibao.contract.IBaseView;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView>{
    public WeakReference<V> weakReference;
    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }
    public void deatch(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference = null;
        }
    }
    public V getView(){
        V v = weakReference.get();
        return v;
    }
}
