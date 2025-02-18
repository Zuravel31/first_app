package prob;

import java.util.Random;
import java.util.Scanner;

public class Intuiciy {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Ты готов проверить свою интуицию? " +
                "Правила игры очень просты, компьтер загадал число от 1 до 500," +
                " попробуй почувствовать это число. Удачи!!!");
        boolean b = true;
        int[] pc = {1};
        for (int i = 0; i < pc.length; i++) {
            pc[i] = random.nextInt(500);
//            System.out.println(Arrays.toString(pc));
            while (b) {
                System.out.print("Введи чиcло: ");
                int people = scanner.nextInt();
                if (people > pc[i]) {
                    System.out.println("Много");
                }
                if (people < pc[i]) {
                    System.out.println("Мало");
                }
                if (people == pc[i]) {
                    System.out.println("Правильно!");
                    return;
                }
            }
        }
    }
}

