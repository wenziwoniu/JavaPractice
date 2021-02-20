package javase.test.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {

        List<?> list = new ArrayList<>();

//        List arrayList = new ArrayList();
//        arrayList.add("aaaa");
//        arrayList.add(100);
//
//        for(int i = 0; i< arrayList.size();i++){
//            String item = (String)arrayList.get(i);
//            System.out.println("泛型测试,item = " + item);
//        }

        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("泛型测试类型相同");
        }

        System.out.println(stringArrayList.getClass().getName());
        System.out.println(integerArrayList.getClass().getName());
    }

    private <T> void test(List<? super T> dst, List<T> src){
        for (T t : src) {
            dst.add(t);
        }
    }

    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
//    public <T> T showKeyName(Generic<T extends Number> container) {
//        System.out.println("container key :" + container.getKey());
//        T test = container.getKey();
//        return test;
//    }
    public <T extends Number> T showKeyName2(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }



}
