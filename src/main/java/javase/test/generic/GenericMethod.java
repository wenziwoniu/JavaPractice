package javase.test.generic;

import java.util.*;

public class GenericMethod<T> {

    private T key;

    public T getKey() {
        return this.key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    /**
     * 此处的T 是泛型类的参数T
     * @param tClass
     */
    public void genericMethodDemo(Class<T> tClass) {
    }

    /**
     * <E> 说明E 是泛型方法的参数
     * @param tClass
     * @param <E>
     * @return
     */
    public <E> String genericMethodDemo2(Class<E> tClass) throws ClassNotFoundException {

        return tClass.getName();
    }

    /**
     * 此处的T 是泛型方法的参数T 和类定义上的T不是一回事
     * 返回结果的T 也是方法的参数T
     * 如果想要返回结果T等同于类定义的T，则需要改变<T>为其它 例如<E>
     * @param tClass
     */
    public <E> E genericMethodDemo3(Class<E> tClass) throws IllegalAccessException, InstantiationException {

        return tClass.newInstance();
    }

    public void genericMethodDemo4(Class<?> tClass) {

    }

    static void fromArrayToCollection(Object[] a, Collection<Object> c) {

        for (Object o : a) {
            c.add(o);
        }
    }

    static <T> void fromArrayToCollection2(Collection<T> c, T[] a) {

//        for (T o : a) {
//            c.add(o);
//        }
    }



    public static void main(String[] args) throws ClassNotFoundException {

        GenericMethod<Long> generic = new GenericMethod<>();
//        报编译异常
//        generic.genericMethodDemo(Integer.class);

//        System.out.println(generic.genericMethodDemo2(Integer.class));
//        System.out.println(generic.genericMethodDemo2(Long.class));

        GenericMethod genericMethod = new GenericMethod();
        genericMethod.genericMethodDemo(Integer.class);
        genericMethod.genericMethodDemo(Long.class);

        String[] strArr = {"a", "b"};
        List<String> strList = new ArrayList<>();
        // Collection<String>不能当成Collection<Object>使用
//        fromArrayToCollection(strArr, strList);

//        fromArrayToCollection2(strArr, strList);


        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<>();
        // 下面代码中T代表Object类型
//        fromArrayToCollection2(oa, co);

        String[] sa = new String[100];
        sa[0] = "a";
        sa[1] = "b";
        sa[2] = "c";
        Collection<String> cs = new ArrayList<>();
        // 下面代码中T代表String类型
//        fromArrayToCollection2(sa, cs);

        // 下面代码中T代表Object类型
//        fromArrayToCollection2(sa, co);

        Integer[] ia = new Integer[100];
        Collection<Number> cn = new ArrayList<>();
//        fromArrayToCollection2(ia, cn);

        Number[] na = new Number[100];
        Collection<Integer> ci = new ArrayList<>();
//        fromArrayToCollection2(ci, na);

        Cookie cookie = new Cookie();
        Cookie cookie2 = new Cookie();
        List<Cookie> cookies = Arrays.asList(cookie, cookie2);
//        String auth = cookies.stream()
//                .filter(c -> c.getName().equals("auth"))
//                .map(Cookie::getValue);

        Map<?, List<?>> map = new HashMap<>();
//        map.put("n", "s");
//        map.put("name", 123);

        List<List<?>> list = new ArrayList<>();

        List<?> list2 = new ArrayList<>();
//        list2.add("a");

        Map<String, List<String>> map2 = new HashMap<>();

//        test(map2);

        Map<String, List<Long>> map3 = new HashMap<>();
//        test(map3);

    }

    public static void test(Map<?, List<?>> map) {

//        test2(map);
    }

    public static <T> void test2(Map<T, List<T>> map) {

    }
}
