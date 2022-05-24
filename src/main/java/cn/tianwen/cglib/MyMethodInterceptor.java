package cn.tianwen.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: wangjq
 * @Date: 2022年05月23日 17:26
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("前置");
        try {
            System.out.println("cglib代理方法执行");
        } catch (Throwable throwable) {
            System.out.println("异常");
        }
        System.out.println("后置");
        return null;
    }
}
