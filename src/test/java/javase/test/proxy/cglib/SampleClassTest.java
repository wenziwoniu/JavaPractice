package javase.test.proxy.cglib;

import javase.test.proxy.jdk.Developer;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.core.KeyFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SampleClassTest {

    @Test
    public void testFixedValue(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib";
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null)); //拦截test，输出Hello cglib
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        System.out.println(proxy.hashCode());
    }

    @Test
    public void testGenerator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value", String.class);
        Object bean = beanGenerator.create();
        Method setter = bean.getClass().getMethod("setValue", String.class);
        setter.invoke(bean, "Hello cglib");

        Method getter = bean.getClass().getMethod("getValue");
        Assert.assertEquals("Hello cglib", getter.invoke(bean));
    }


}
