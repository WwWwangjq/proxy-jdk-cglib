package cn.tianwen.cglib;

import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.proxy.Enhancer;

import java.io.FileOutputStream;

/**
 * @Author: wangjq
 * @Date: 2022年05月23日 17:28
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ServiceImpl.class);
        enhancer.setCallback(new MyMethodInterceptor());
        ServiceImpl service = (ServiceImpl) enhancer.create();
        service.method();
        outputClassFile(enhancer);
    }

    private static void outputClassFile(Enhancer enhancer) throws Exception {
        byte[] bytes = DefaultGeneratorStrategy.INSTANCE.generate(enhancer);
        FileOutputStream fos = new FileOutputStream("C:\\work space\\wangjq\\proxy-jdk-cglib\\src\\main\\java\\cn\\tianwen\\cglib\\MyCglibProxy.class");
        fos.write(bytes);
        fos.flush();
    }
}
