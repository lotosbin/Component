package com.ehi.component.service;

import android.support.annotation.Nullable;

import com.ehi.component.impl.service.EHiService;

/**
 * 单例服务,这是注册服务默认的形式
 *
 * @param <T>
 */
public abstract class SingletonService<T> implements IServiceLoad<T> {

    @Nullable
    private T instance;

    @Override
    public final T get() {
        if (instance == null) {
            synchronized (EHiService.class) {
                instance = getRaw();
            }
        }
        return instance;
    }

    /**
     * 获取真正的对象
     *
     * @return
     */
    abstract protected T getRaw();

}