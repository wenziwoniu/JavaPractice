package javase.test.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SampleClass {

    public void test() {
        System.out.println("Hello World");
    }

    public String test(String input) {
        return "Hello World";
    }

    public static void main(String[] args) {

        System.out.println(SampleClass.class.getName());
        System.out.println(SampleClass.class.getSimpleName());
        System.out.println(SampleClass.class);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object resutl = proxy.invokeSuper(obj, args);
                System.out.println("after method run...");
                return resutl;
            }

        });

        SampleClass sampleClass = (SampleClass) enhancer.create();

        System.out.println(Proxy.isProxyClass(sampleClass.getClass()));
        System.out.println(sampleClass instanceof SampleClass);

        sampleClass.test();
    }
}
