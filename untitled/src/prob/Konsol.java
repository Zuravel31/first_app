package prob;

import java.util.Arrays;
import java.util.Scanner;

public class Konsol {
    public static void main(String[] args) {
        Konsol konsol = new Konsol();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность массив N: ");
        int rasmer = scanner.nextInt();
        int[] mas = new int[rasmer];
        for (int i = 0; i < mas.length; i++) {
            System.out.print("Add nums: ");
            mas[i] = scanner.nextInt();
            System.out.println("Массив" + Arrays.toString(mas));
        }
        System.out.println(Arrays.toString(mas));
        konsol.minMax(mas);
    }

    void minMax(int[] mas) {
        int min = 2147483647;
        int max = -2147483647;
        for (int element : mas) {
            if (min > element) {
                min = element;
            }
        }
            for (int element : mas) {
                if (max < element) {
                    max = element;
                }
            }
            System.out.println("Минимальное число: " + min);
            System.out.println("Максимальное число: " + max);
        }
    }
