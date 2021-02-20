package javase.test.generic;

public class GenericInterfaceDemo {

    public static void main(String[] args) {

        Test2 test = new Test2();
    }
}

interface GenericInterface<T> {

    T next();
}

class Test<T> implements GenericInterface<T> {

    @Override
    public T next() {
        return null;
    }
}

class Test2 implements GenericInterface<String> {

    @Override
    public String next() {
        return null;
    }

}
