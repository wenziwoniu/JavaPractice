package javase.test.classobject;
import java.util.*;

class CountedInteger{
    private static long counter;
    //每次创建一个实例，都会执行一次初始化id=counter++
    private static long id = counter++;
    public String toString(){
        return Long.toString(id);
    }
}

public class FilledList<T>{
    private Class<T> type;
    public FilledList(Class<T> type){
        this.type = type;
    }
    public List<T> create(int nElements){
        List<T> result = new ArrayList<T>();
        try{
            for(int i=0;i<nElements;i++){
                //CountedInteger必须提供默认的构造函数，通过CountedInteger类的Class对象创建一个实例对象
                result.add(type.newInstance());
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args){
//        FilledList<CountedInteger> f1 = new FilledList<CountedInteger>(CountedInteger.class);
//        System.out.println(f1.create(15));
        CountedInteger countedInteger = new CountedInteger();
        CountedInteger countedInteger2 = new CountedInteger();
//        System.out.println(countedInteger.toString());
//        System.out.println(countedInteger2.toString());
        System.out.println("end");
    }
}