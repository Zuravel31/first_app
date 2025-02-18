package shpors.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Test2 {
    public static void main(String[] args) {
        List<People> people = Arrays.asList(
                new People("Ivan", 16, People.Sex.MAN),
                new People("Petr", 16, People.Sex.MAN),
                new People("Elena", 46, People.Sex.WOMEN),
                new People("Artem", 26, People.Sex.MAN),
                new People("Masha", 17, People.Sex.WOMEN),
                new People("Kirill", 16, People.Sex.MAN),
                new People("Andrey Andreevich", 69, People.Sex.MAN)
        );

        List<People> peopleList1 = people.stream()// отфильтровать по призывному возрасту мужчин
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 27 && p.getSex() == People.Sex.MAN)
                .collect(Collectors.toList());
        peopleList1.stream().forEach(System.out::println);

        double averageAge = people.stream().filter(p -> p.getSex() == People.Sex.MAN)// отфильтровать по полу
                .mapToInt(People::getAge)
                .average()
                .getAsDouble();
        System.out.println(averageAge);

        List<People> peopleList2 = people.stream()// отфильтровать по трудовому возрасту и полу
                .filter(p -> p.getAge() > 18)
                .filter(p -> (p.getAge() < 60 && p.getSex() == People.Sex.MAN) ||
                        (p.getAge() < 55 && p.getSex() == People.Sex.WOMEN))
                .collect(Collectors.toList());
        peopleList2.stream().forEach(System.out::println);

        people.stream().sorted(new PeopleAgeComparable()).forEach(System.out::println); // отфильровать список по возрасту

        people.stream().sorted(new PeopleAgeComparable().thenComparing(new PeopleAgeComparable()))
                .forEach(System.out::println); // отфильтровать список по возрасту(а с одинаковым возрастом по Имени)

    }
}

class PeopleAgeComparable implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        return o1.getAge() - o2.getAge();
    }
}

class PeopleNameComparable implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class People {
    private String name;
    private int age;
    private Sex sex;

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }


    public enum Sex {
        MAN, WOMEN
    }
}