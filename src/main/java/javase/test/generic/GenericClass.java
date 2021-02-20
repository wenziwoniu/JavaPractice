package javase.test.generic;

/**
 *
 * @param <T>
 */
public class GenericClass<T> {

    private T key;

    public GenericClass() {

    }

    public GenericClass(T key) {
        this.key = key;
    }

    public T getKey() {
        return this.key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public static void main(String[] args) {

        // 不指定类型时，可以理解T为Object类型
        GenericClass genericClass = new GenericClass();
        genericClass.setKey("123");
        genericClass.setKey(1);

        GenericClass<Integer> genericClass1 = new GenericClass<>();
        genericClass1.setKey(123);
//        genericClass1.setKey();
    }
}
