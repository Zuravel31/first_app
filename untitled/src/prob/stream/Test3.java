package prob.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {
    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
//                new Person("Alice", 30),
//                new Person("Bob", 25),
//                new Person("Charlie", 35)
        );

        List<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(names); // [Alice, Bob, Charlie]    }


        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );

        List<String> flatList = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flatList); // [a, b, c, d, e, f, g, h, i]
    }
}
