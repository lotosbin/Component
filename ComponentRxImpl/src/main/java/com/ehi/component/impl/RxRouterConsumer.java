package com.ehi.component.impl;

import android.support.annotation.Nullable;

import com.ehi.component.error.ActivityResultException;
import com.ehi.component.error.NavigationFailException;
import com.ehi.component.error.TargetActivityNotFoundException;
import com.ehi.component.error.UnknowException;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Consumer;

/**
 * RxRouter 的默认处理处理方式,如果使用中没有处理,那么这里默认不处理
 * <p>
 * time   : 2018/11/20
 *
 * @author : xiaojinzi 30212
 */
public class RxRouterConsumer<T extends Throwable> implements Consumer<T> {

    private static final Class IGNORE_ERROR_CLASSED[] = {
            NavigationFailException.class,
            ActivityResultException.class,
            TargetActivityNotFoundException.class,
            UnknowException.class
    };


    @Nullable
    private Consumer<T> preConsumer = null;

    public RxRouterConsumer(Consumer<T> preConsumer) {
        this.preConsumer = preConsumer;
    }

    @Override
    public void accept(T throwable) throws Exception {

        Throwable currThrowable = throwable;
        if (currThrowable != null) {
            do {
                for (Class errorClass : IGNORE_ERROR_CLASSED) {
                    if (currThrowable.getClass() == errorClass) {
                        return;
                    }
                }
                currThrowable = currThrowable.getCause();
            } while (currThrowable != null);
        }

        if (preConsumer != null) {
            preConsumer.accept(throwable);
            return;
        }
        if (throwable instanceof Exception) {
            throw ((Exception) throwable);
        } else {
            throw new OnErrorNotImplementedException(throwable);
        }

    }

}