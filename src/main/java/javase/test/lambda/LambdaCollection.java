package javase.test.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class LambdaCollection {

    static Predicate<Item> test = x -> {

        if (x.getName().equals("wang")) {
            return true;
        }
        return false;
    };

    public static void main(String[] args) {

        Item item = new Item();
        item.setName("wang");
        System.out.println(test.test(item));

        removeDemo();
    }

    public static void removeDemo() {

        List<String> list = new ArrayList();
        Collections.addAll(list, "a", "b", "c");

        list.removeIf(x -> x.equals("b"));
        list.forEach(System.out::println);
    }


    public void listForeachDemo() {

        List<String> list = new ArrayList();
        Collections.addAll(list, "a", "b", "c");

        list.forEach(x -> System.out.println(x));
        list.forEach(System.out::println);

        list.forEach(element -> {
            if (element.equals("b")) {
                System.out.println(element);
            }
        });

    }
}


