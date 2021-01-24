package javase.test.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理器
 */
public class DynamicProxyHandlerDeveloper implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandlerDeveloper(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("code")) {
            System.out.println("Zack is praying for the code");
        }

        if (method.getName().equals("debug")) {
            System.out.println("Zack have no bug! No need to debug");
        }

        if (method.getName().equals("codeCount")) {
            return Integer.parseInt(method.invoke(proxied, args).toString()) + 10;
        }

        // 被代理对象zack, 这里可以将请求转发给原本方法
        return method.invoke(proxied, args);
        // 代理对象zackProxy， 会陷入死循环
//        return method.invoke(proxy, args);
//        return null;
    }
}
