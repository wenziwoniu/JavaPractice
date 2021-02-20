package javase.test.generic;

class Holder<T>{
    private T value;
    public Holder(){}
    public Holder(T val){ value = val;}
    public void set(T val){value = val;}
    public T get(){ return value;}
    public boolean equals(Object obj){
        return value.equals(obj);
    }
}

public class CaptureConversion{
    static <T> void f1(Holder<T> holder){
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static <T> T f3(Holder<T> holder){
        T t = holder.get();
        return t;
    }
    static void f2(Holder<?> holder){

        f3(holder);
        f1(holder);
    }
    //@SuppressWarnings("unchecked")
    public static void main(String[] args){
        Holder raw = new Holder<Integer>(1);
        System.out.println(raw.get() instanceof Integer);

        f1(raw);//Unchecked invocation f1(Holder) of the generic method f1(Holder<T>) of type
        f2(raw);
        Holder rawBasic = new Holder();
        rawBasic.set(new Object());//Type safety: The method set(Object) belongs to the raw type Holder. References to generic type Holder<T> should be parameterized
        f2(rawBasic);//No warnings
        //Upcast to Holder<?>, still figures out:
        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded);
    }
}