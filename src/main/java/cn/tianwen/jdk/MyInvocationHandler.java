package cn.tianwen.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: wangjq
 * @Date: 2022年05月23日 14:44
 */
public class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("前置");
        try {
            System.out.println("jdk代理方法执行");
        } catch (Exception e) {
            System.out.println("异常");
        }
        System.out.println("后置");
        return null;
    }
}
