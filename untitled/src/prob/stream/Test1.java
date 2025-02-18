package shpors.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        Collection collection = Arrays.asList("a1", "a3", "a2", "a3");
        System.out.println(collection.stream().filter("a3"::equals).count());// или filter(a -> a.equalse "a3"), count()- возвращает число
        System.out.println(collection.stream().findFirst().orElse(0));// что бы вывести 1 элемент или 0 если коллекция пуста
        System.out.println(collection.stream().skip(collection.size()-1).findFirst().orElse("empty"));// что бы вывести последний элемент или empty если коллекция пуста
        System.out.println(collection.stream().filter("a2"::equals).findFirst().get());// что бы вывести a2
        System.out.println(collection.stream().skip(2).findFirst().get());// что бы вывести 3 элемент
        System.out.println(collection.stream().skip(1).limit(2).collect(Collectors.toList()));// что бы вывести 2 элемента пропустив 1-й элемент


    }
}
