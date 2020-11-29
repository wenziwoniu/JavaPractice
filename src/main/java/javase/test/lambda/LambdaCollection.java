package javase.test.lambda;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaCollection {

    static Predicate<Item> test = x -> {

        if (x.getName().equals("wang")) {
            return true;
        }
        return false;
    };

    public static void main(String[] args) {

//        mapDemo();
//        filterDemo();
//        limitDemo();
//        sortedDemo();
//        parallelDemo();
//          mapToIntDemo();
//        reduceDemo();
        listToMap();
    }

    public static void reduceDemo() {

        List<Integer> listint = new ArrayList<Integer>();
        listint.add(100);
        listint.add(2);
        listint.add(5);
        listint.add(10);
        listint.add(3);
        // 对元素求和
//        Integer count = listint.stream().reduce(0, (a, b) -> a + b);
        Integer count2 = listint.stream().reduce(10, Integer::max);
//        System.out.println(count);
        System.out.println(count2);
//        listint.stream().reduce((i, j) -> i + j).ifPresent(System.out::println);

        Integer count3 = listint.stream().reduce(0, (i, j) -> i > j ? i : j);
        System.out.println("3:" + count3);
    }

    public static void listToMap() {

        List<Item> listint = new ArrayList<Item>();
        listint.add(new Item("wang", "qixian"));
        listint.add(new Item("chen", "yongzhen"));

        Map<String, String> map = listint.stream().collect(Collectors.toMap(Item::getName, Item::getAddress));
        Map<String, String> map2 = listint.stream().collect(Collectors.toMap(x -> x.getName(), x -> x.getAddress()));
        System.out.println(map2);
    }

    public static void mapToIntDemo() {

        List<Integer> listint = new ArrayList<Integer>();
        listint.add(1);
        listint.add(2);
        listint.add(3);
        listint.add(4);
        listint.add(5);
        IntSummaryStatistics stat = listint.stream().mapToInt((item)->item).summaryStatistics();
        System.out.println("max:"+stat.getMax());
        System.out.println("min:"+stat.getMin());
        System.out.println("sum:"+stat.getSum());
        System.out.println("count:"+stat.getCount());
        System.out.println("average:"+stat.getAverage());
    }

    /**
     * parallel 并行处理，处理的结果带有随机性
     */
    public static void parallelDemo() {

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "2", "3", "4", "5","6","7","8","9","10");
        list.stream().forEach(System.out::println);
        System.out.println("------------------");
        list.stream().parallel().forEach(System.out::println);

    }

    /**
     */
    public static void sortedDemo() {

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "6", "2", "3", "4", "5");
//        list.stream().sorted().forEach(System.out::println);
        list.stream().sorted((x, y) -> Integer.valueOf(y).compareTo(Integer.valueOf(x))).forEach(System.out::println);
    }

    /**
     *
     */
    public static void limitDemo() {

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "6", "2", "3", "4", "5");
        list.stream().limit(3).forEach(System.out::println);
    }

    /**
     * fileter 只保留filter里函数返回结果为true的元素
     */
    public static void filterDemo() {

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "ab", "", "cd");
        List<String> result = list.stream().filter(x -> StringUtils.isEmpty(x)).collect(Collectors.toList());
        list.forEach(System.out::println);
        result.forEach(System.out::println);
        System.out.println(list.size());
        System.out.println(result.size());
    }

    /**
     * map对流的元素进行处理后得到新的结果
     */
    public static void mapDemo() {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3);
        List<String> result = list.stream().map(x -> {
            return String.valueOf(x) + "a";}).collect(Collectors.toList());
        result.forEach(x -> System.out.println(x));
        list.forEach(x -> System.out.println(x));
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


