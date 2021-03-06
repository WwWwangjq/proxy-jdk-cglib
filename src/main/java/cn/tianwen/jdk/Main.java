package cn.tianwen.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: wangjq
 * @Date: 2022年05月23日 11:49
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // 需要代理的接口
        Class<?>[] interfaces = new Class[]{IMyService.class};
        // 声明代理逻辑
        InvocationHandler h = new MyInvocationHandler();
        // 创建代理类
        IMyService proxy = (IMyService) Proxy.newProxyInstance(Main.class.getClassLoader(), interfaces, h);
        // 实际执行代理类
        proxy.method();
        outputClassFile();
    }

    /** 将代理类的运行时数据结构输出到磁盘上成为字节码文件 利用反编译观察 */
    private static void outputClassFile() throws Exception {
        byte[] bytes = ProxyGenerator.generateProxyClass("$proxy0", new Class[]{IMyService.class});
        FileOutputStream fos = new FileOutputStream("C:\\work space\\wangjq\\proxy-jdk-cglib\\src\\main\\java\\cn\\tianwen\\jdk\\MyJdkProxy.class");
        fos.write(bytes);
        fos.flush();
    }
}
