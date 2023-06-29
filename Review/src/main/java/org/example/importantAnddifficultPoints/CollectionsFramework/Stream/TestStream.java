package org.example.importantAnddifficultPoints.CollectionsFramework.Stream;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Date: 2023/3/14
 * @Author: LTisme
 * @ClassName: TestStream
 * @Description: ---> ① Stream 的创建
 *                    ② Stream 的终止操作
 *                    ③ Stream 的中间操作
 */

public class TestStream {
    /**
     * ①这里创建一个串行流，后面还有并行流，速度更快
     */
    @Test
    public void Test_createStream(){
        // 1、使用java.util.Collection.stream() 方法用集合创建流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 2、使用java.util.Arrays.stream(T[] array)方法用数组创建流
        String[] arr = {"1"};
        Stream<String> stream1 = Arrays.stream(arr);

        // 3、使用Stream的静态方法：of()、iterate()、generate()
        Stream<String> concat = Stream.concat(stream, stream1);
        Stream<String> s = Stream.of("a", "b");
        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);

        // Random
        IntStream ints = new Random().ints(1000);
        ints.forEach(System.out::println);
    }

    /**
     * ②这里进行Stream的终止操作，先来初始化数据，方便后续使用
     */
    static class Person {
        private String name;  // 姓名
        private int salary; // 薪资
        private int age; // 年龄
        private String sex; //性别
        private String area;  // 地区

        public Person() {
        }

        public Person(String name, int salary, int age, String sex, String area) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.sex = sex;
            this.area = area;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        public String getSex() {
            return sex;
        }

        public String getArea() {
            return area;
        }

        @Override
        public String toString() {
            return "[" +
                    "name:" + getName() +
                    " salary:" + getSalary() +
                    " sex:" + getSex() +
                    " age:" + getAge() +
                    " area:" + getArea() +
                    "]";
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }

    static class LambdaTest {

        public static List<Person> personList = new ArrayList<>();

        static {
            {
                personList.add(new Person("张三",3000,23,"男","太原"));
                personList.add(new Person("李四",7000,34,"男","西安"));
                personList.add(new Person("王五",5200,22,"女","太原"));
                personList.add(new Person("小黑",1500,33,"女","上海"));
                personList.add(new Person("狗子",8000,44,"女","北京"));
                personList.add(new Person("铁蛋",6200,36,"女","南京"));
            }
        }
        public static List<Integer> simpleList = Arrays.asList(15, 22, 9, 11, 33, 52, 14);
    }

    // 遍历/匹配（foreach/find/match）
    @Test
    public void Test_foreach(){
        LambdaTest.personList.stream().forEach((x) -> System.out.println(x.toString()));
//        LambdaTest.personList.forEach(System.out::println);   // 这句话也行，但是其他操作这样做不行
    }

    @Test
    public void Test_find(){
        Optional<Integer> first = LambdaTest.simpleList.stream().findFirst();
        first.ifPresent(System.out::println);
        Optional<Integer> any = LambdaTest.simpleList.stream().findAny();
        any.ifPresent(System.out::println);

        // 再用parallelStream测试多线程情况，any处哪个得到的快，就拿到哪个
        Optional<Integer> firstMulti = LambdaTest.simpleList.parallelStream().findFirst();
        firstMulti.ifPresent(System.out::println);
        Optional<Integer> anyMulti = LambdaTest.simpleList.parallelStream().findAny();
        anyMulti.ifPresent(System.out::println);
    }

    @Test
    public void Test_match(){
        // 判断是否所有人工资大于某数
        boolean flag = LambdaTest.personList.stream().allMatch((item) -> item.getSalary() > 8000);
        System.out.println("是否所有人工资大于8000?-->" + flag);
    }

    /**
     * 这里进行统计(count/averaging/sum/max/min）
     */
    @Test
    public void Test_count(){
        // 计数
        long count = LambdaTest.personList.stream().count();
        System.out.println(count);

        // 求和
        int sum = LambdaTest.simpleList.stream().mapToInt(i -> i).sum();
        System.out.println("sum = " + sum);

        // 求平均
        OptionalDouble average = LambdaTest.simpleList.stream().mapToInt(i -> i).average();
        average.ifPresent(System.out::println);

        // 求最大最小
        OptionalInt max = new Random().ints(20).max();
        max.ifPresent(System.out::println);
    }

    /**
     * 这里测试归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
     */
    @Test
    public void Test_reduce(){
        // 下方的1是初始值，n1是计算后的结果，n2是一个一个遍历的元素值
        Integer result = LambdaTest.simpleList.stream().reduce(1,(n1, n2) -> n1*n2);
        System.out.println(result);
    }

    /**
     * 这里测试拼接，看看用法就好，不需要有多深的理解
     */
    @Test
    public void Test_joining(){
        List<String> list = Arrays.asList("A", "B", "C");
        String str = list.stream().collect(Collectors.joining("-"));
        System.out.println("str = " + str);
    }

    /**
     * 这里测试分区、分组
     */
    @Test
    public void Test_group(){
        // 根据判断条件将结果分区
        Map<Boolean, List<Person>> collect = LambdaTest.personList.stream().collect(Collectors.partitioningBy(item -> item.getSalary() > 5000));
        System.out.println(collect);

        // 根据条件分组
        Map<String, List<Person>> collect1 = LambdaTest.personList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(collect1.get("男"));
    }

    /**
     * 这里测试归集，就是转换成另一种集合，重点来看转换成Map怎么转换【重要！！！】
     */
    @Test
    public void Test_Collect(){
        List<Integer> collect = LambdaTest.simpleList.stream().collect(Collectors.toList());
        Set<Integer> collect1 = LambdaTest.simpleList.stream().collect(Collectors.toSet());
        // 单值的列表如何转换成键值对映射的Map呢？是要写两个lambda表达式了，第一个是告诉JVM如何转换成key，第二个是如何转换成val
        Map<String, Person> collect2 = LambdaTest.personList.stream().collect(Collectors.toMap(Person::getName, person -> person));
        System.out.println(collect2.get("张三"));
    }

    /**
     * 这里测试③中间操作：filter，map，sort，peek等
     */
    @Test
    public void Test_Filter(){
        // 中间操作
        LambdaTest.personList.stream().filter(person -> person.getSalary() > 5000)
                // 终止操作
                .forEach(System.out::println);
    }

    /**
     * 映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为 map 和 flatMap ：

     * map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
     */
    @Test
    public void Test_Map(){
        // Map这里做的是给所有人涨1000的工资
        LambdaTest.personList.stream().map(item -> {
            item.setSalary(item.getSalary() + 1000);
            return item;
        })
                .forEach(System.out::println);
    }

    /**
     * sorted，中间操作。有两种排序：

     * sorted()：自然排序，流中元素需实现Comparable接口
     * sorted(Comparator com)：Comparator排序器自定义排序
     */
    @Test
    public void Test_Sort(){

//        LambdaTest.personList.stream().sorted()
//                .forEach(System.out::println);
        LambdaTest.personList.stream().sorted(Comparator.comparing(Person::getSalary))
                .forEach(System.out::println);
    }

    /**
     * peek：它的作用是在stream中间进行调试，因为stream不支持debug，并不存储数据。故用他来打印一些数据，来看看结果对不对。
     * 调试的时候可以放进日志中去；另外 peek 还有一个功能是进行赋值
     */
    @Test
    public void Test_Peek(){
        // 如果不加终止操作的话，是会不执行的，只有加上终止操作才能执行
        LambdaTest.personList.stream().filter(person -> person.getSalary() > 5000).peek(System.out::println);
        // 加上了终止操作
        LambdaTest.personList.stream().filter(person -> person.getSalary() > 5000).peek(System.out::println)
                .collect(Collectors.toList());

        // 使用peek进行赋值——对Test_Map中的涨工资进行操作
        LambdaTest.personList.stream().peek(person -> person.setSalary(person.getSalary() + 1000))
                .forEach(System.out::println);
    }

    /**
     * 这里测试其他：流也可以进行
     * 合并
     * 去重distinct
     * 限制limit
     * 跳过skip
     * 等操作。
     */
    @Test
    public void Test_Other(){
        System.out.println("------------limit---------------");
        // limit:拿到工资前三的人，正序排列不好拿，所以倒序排列
        LambdaTest.personList.stream().sorted((o1, o2) -> o2.getSalary() - o1.getSalary()).limit(3)
                .forEach(System.out::println);
        System.out.println("------------distinct---------------");
        // distinct:去重
        IntStream.of(1,2,3,3,4,4,5,6,7).distinct()
                .forEach(System.out::println);
        System.out.println("------------skip---------------");
        // skip：跳过指定个数个元素
        IntStream.of(1,2,3,4,5,6,7,8,9,0).skip(2)
                .forEach(System.out::println);
    }
}
