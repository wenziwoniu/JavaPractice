package javase.test.lambda;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//        listToMap();
//        sortedDemo2();
//        collecttest1();
//        collecttest3();
        findFist();
    }

    public static void findFist() {

        List<Integer> listint = new ArrayList<Integer>();
        listint.add(100);
        listint.add(2);
        listint.add(5);

        Optional optional = listint.stream().filter(x -> x > 1).findFirst();
        System.out.println(optional.isPresent());
        System.out.println(optional.orElseGet(() -> 100));
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
     */
    public static void sortedDemo2() {

        List<Item> list = new ArrayList<>();
        Item item = new Item();
        item.setName("a");
        Item item2 = new Item();
        item2.setName("b");
        list.add(item2);
        list.add(item);

        list.forEach(x -> System.out.println(x.getName()));
        list.stream().sorted(Comparator.comparing(Item::getName)).forEach(x -> System.out.println(x.getName()));
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

    public void groupingBy() {

        List<Item> list = new ArrayList<>();
        Item item = new Item();
        item.setName("a");
        Item item2 = new Item();
        item2.setName("b");
        list.add(item2);
        list.add(item);

        list.forEach(x -> System.out.println(x.getName()));
        List<Item> result = list.stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList());

    }

    /**
     * stream.collect() 的本质由三个参数构成,
     * 1. Supplier 生产者, 返回最终结果
     * 2. BiConsumer<R, ? super T> accumulator 累加器
     * 第一个参数是要返回的集合, 第二个参数是遍历过程中的每个元素,
     * 将流中每个被遍历的元素添加到集合中
     * 3. BiConsumer<R, R> combiner 合并器, 在有并行流的时候才会有用, 一个流时代码不会走到这里
     * 将第二步遍历得到的所有流形成的list都添加到最终的list中,
     * 最后返回list1
     */
    public static void collecttest1() {
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        // 最原始和基础的方式

   /*     List<String> list = stream.collect(
                ()->new ArrayList(),
                (theList, item) -> theList.add(item),
                (list1, list2) -> list1.addAll(list2)
        );*/

        // 打印出更详尽的过程
        List<String> listDetail = stream.collect(
                () -> {
                    ArrayList<String> arrayList = new ArrayList<>();
                    System.out.println("第一个list诞生, size: " + arrayList.size());
                    return arrayList;
                },
                (theList, item) -> {
                    System.out.println("第二个list的size: " + theList.size());
                    theList.add(item);
                },
                (list1, list2) -> {
                    System.out.println("第三个list1的size: " + list1.size());
                    System.out.println("第四个list2的size: " + list2.size());
                    list1.addAll(list2);
                }
        );
        /* 输出
            第一个list诞生, size: 0
            第二个list的size: 0
            第二个list的size: 1
            第二个list的size: 2
        * */
        Stream<String> stream2 = Stream.of("hello", "world", "helloworld");
        // 使用方法引用来传递行为, 更加清晰易懂, new(新建) -> add(累加) -> addAll(合并)
        List<String> list2 = stream2.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        String concat = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(concat);
    }

    public static void collecttest2() {
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        // 这样的写法兼具灵活和简单
        List<String> result = stream.collect(Collectors.toList());
//        ArrayList<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        TreeSet<String> treeSet = stream.collect(Collectors.toCollection(TreeSet::new));
//        String s = stream.collect(Collectors.joining()); // 拼接成字符串
        HashMap<String, String> map = stream.collect(HashMap::new, (x, y) -> {
            x.put(y, y); // 自己做自己的key
        }, HashMap::putAll);
        System.out.println("a");
    }

    public static void collecttest3() {

        List<Item> list = new ArrayList<>();
        Item item = new Item();
        item.setName("a");
        item.setAddress("anhui");
        Item item2 = new Item();
        item2.setName("b");
        item2.setAddress("zhejiang");
        Item item3 = new Item();
        item3.setName("a");
        item3.setAddress("jiangsu");
        list.add(item2);
        list.add(item3);
        list.add(item);

        // key 是 name
        Map<String, List<Item>> map = list.stream().collect(Collectors.groupingBy(Item::getName));

        // 外侧的key 是 name, 内侧的key 是 address
        Map<String, Map<String, List<Item>>> map2 = list.stream().collect(Collectors.groupingBy(Item::getName, Collectors.groupingBy(Item::getAddress)));


        Map<String, Item> map3 = list.stream().collect(Collectors.groupingBy(Item::getName, Collectors.collectingAndThen(Collectors.toList(), value -> value.get(0))));

        Item item1 = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), value -> value.get(0)));

        System.out.println("a");
    }

}


