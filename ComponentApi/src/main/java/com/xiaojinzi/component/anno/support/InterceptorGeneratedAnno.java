package com.xiaojinzi.component.anno.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标记所有 Component 生成的拦截器类
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface InterceptorGeneratedAnno {
}