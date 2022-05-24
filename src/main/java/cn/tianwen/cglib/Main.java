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
        // 需要代理的类
        enhancer.setSuperclass(ServiceImpl.class);
        // 声明代理逻辑
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建代理类
        ServiceImpl service = (ServiceImpl) enhancer.create();
        // 实际执行代理类
        service.method();
        outputClassFile(enhancer);
    }

    /** 将代理类的运行时数据结构输出到磁盘上成为字节码文件 利用反编译观察 */
    private static void outputClassFile(Enhancer enhancer) throws Exception {
        byte[] bytes = DefaultGeneratorStrategy.INSTANCE.generate(enhancer);
        FileOutputStream fos = new FileOutputStream("C:\\work space\\wangjq\\proxy-jdk-cglib\\src\\main\\java\\cn\\tianwen\\cglib\\MyCglibProxy.class");
        fos.write(bytes);
        fos.flush();
    }
}
