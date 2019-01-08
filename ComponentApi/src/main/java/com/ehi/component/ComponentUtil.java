package com.ehi.component;

/**
 * time   : 2018/07/26
 *
 * @author : xiaojinzi 30212
 */
public class ComponentUtil {

    /**
     * 当使用 Fragment 或者 Context 中有这个 tag 的 fragment,那么就会最终用这个实现跳转
     */
    public static final String FRAGMENT_TAG = "EHiRxFragment";

    /**
     * 1.这是注解驱动器生成类的时候的目录
     * 2.这也是一些写好的实现类的包名字,不要轻易更改,如果要更改,请仔细比对
     * ComponentApiImpl 模块的实现类的位置
     */
    public static final String IMPL_OUTPUT_PKG = "com.ehi.component.impl";

    /**
     * 点
     */
    public static final String DOT = ".";

    /**
     * 生成的文件名称的后缀
     */
    public static final String UIROUTER = "RouterGenerated";

    /**
     * 生成的文件名称的后缀
     */
    public static final String MODULE_APPLCATION = "ModuleApplicationGenerated";

    /**
     * 生成的文件名称的后缀
     */
    public static final String SERVICE = "ServiceGenerated";

    /**
     * 生成的文件名称的后缀
     */
    public static final String INTERCEPTOR = "InterceptorGenerated";

    public static final String INTERCEPTOR_ANNO_CLASS_NAME = "com.ehi.component.anno.EHiInterceptorAnno";
    public static final String ROUTER_ANNO_CLASS_NAME = "com.ehi.component.anno.EHiRouterAnno";
    public static final String MODULE_APP_ANNO_CLASS_NAME = "com.ehi.component.anno.EHiModuleAppAnno";
    public static final String SERVICE_ANNO_CLASS_NAME = "com.ehi.component.anno.EHiServiceAnno";

    // 路由框架基础实现类的全类名

    public static final String UIROUTER_IMPL_CLASS_NAME = IMPL_OUTPUT_PKG + DOT + "EHiModuleRouterImpl";
    public static final String MODULE_APPLICATION_IMPL_CLASS_NAME = IMPL_OUTPUT_PKG + DOT + "application" + DOT + "EHiModuleApplicationImpl";
    public static final String SERVICE_IMPL_CLASS_NAME = IMPL_OUTPUT_PKG + DOT + "service" + DOT + "EHiMuduleServiceImpl";
    public static final String INTERCEPTOR_IMPL_CLASS_NAME = IMPL_OUTPUT_PKG + DOT + "interceptor" + DOT + "EHiMuduleInterceptorImpl";

    /**
     * 首字母小写
     *
     * @param str
     * @return
     */
    public static String firstCharUpperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    public static String genHostModuleApplicationClassName(String host) {
        String claName = IMPL_OUTPUT_PKG + DOT + "application" + DOT + firstCharUpperCase(host) + MODULE_APPLCATION;
        return new String(claName);
    }

    public static String genHostRouterClassName(String host) {
        String claName = IMPL_OUTPUT_PKG  + DOT + firstCharUpperCase(host) + UIROUTER;
        return new String(claName);
    }

    public static String genHostServiceClassName(String host) {
        String claName = IMPL_OUTPUT_PKG + DOT + "service" + DOT + firstCharUpperCase(host) + SERVICE;
        return new String(claName);
    }

    public static String genHostInterceptorClassName(String host) {
        String claName = IMPL_OUTPUT_PKG + DOT + "interceptor" + DOT + firstCharUpperCase(host) + INTERCEPTOR;
        return new String(claName);
    }

}