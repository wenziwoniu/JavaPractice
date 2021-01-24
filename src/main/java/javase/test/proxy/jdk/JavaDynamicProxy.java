package javase.test.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class JavaDynamicProxy {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Developer zack = new JavaDeveloper("zack");
        zack.code();
        zack.debug();

        //创建动态代理
       /* Developer zackProxy = (Developer) Proxy.newProxyInstance(
            zack.getClass().getClassLoader(),
            zack.getClass().getInterfaces(),
            (proxy, method, argsObject) -> {
                if (method.getName().equals("code")) {
                    System.out.println("Zack is praying for the code");
                }
                if (method.getName().equals("debug")) {
                    System.out.println("Zack have no bug");
                }

                return null;
            }
        );*/

       InvocationHandler invocationHandler = new DynamicProxyHandlerDeveloper(zack);
//       Developer zackProxy = (Developer) Proxy.newProxyInstance(zack.getClass().getClassLoader(),
//               zack.getClass().getInterfaces(),
//               invocationHandler);
//        zackProxy.code();
//        zackProxy.debug();

        Class proxyClass = Proxy.getProxyClass(Developer.class.getClassLoader(), new Class[]{Developer.class});
        Developer zackProxy = (Developer) proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);

        System.out.println(zackProxy.codeCount());

        System.out.println(Proxy.isProxyClass(proxyClass));
        System.out.println(zackProxy instanceof Developer);
        System.out.println(invocationHandler == Proxy.getInvocationHandler(zackProxy));
    }
}
