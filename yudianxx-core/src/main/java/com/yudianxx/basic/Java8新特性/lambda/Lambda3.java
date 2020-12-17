package com.yudianxx.basic.Java8新特性.lambda;

/**
 * @author huangyongwen
 * @date 2020/9/9
 * @Description
 */


import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Common standard functions from the Java API.
 *
 * @author Benjamin Winterberg
 */
public class Lambda3 {

    @FunctionalInterface
    interface Fun {
        void foo();
    }

    public static void main(String[] args) throws Exception {

        // Predicates

        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


        // Functions

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"


        // Suppliers

        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person


        // Consumers
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));



        // Comparators 比较设置
//        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Comparator<Person> comparator = (p1, p2) -> p1.secondName.compareTo(p2.secondName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        Person p3 = new Person("Alice1", "Wonderland1");
        Person p4 = new Person("Alice4", "Wonderland4");


//        compare比较是返回一个整型
        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0
        System.out.println(comparator.compare(p3,p4));  // <0

        // Runnables

        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();


        // Callables

        Callable<UUID> callable = UUID::randomUUID;
        callable.call();
    }

}
