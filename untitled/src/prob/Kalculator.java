package prob;

import java.util.Scanner;

public class Kalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = 0;
        boolean b = true;
        String d = "+";
        do {
            System.out.print("Введите число: ");
            double f = scanner.nextDouble();
            switch (d) {
                case "+":
                    a += f;
                    break;
                case "-":
                    a -= f;
                    break;
                case "*":
                    a *= f;
                    break;
                case "/":
                    a *= f;
                    if (a == 0 || f ==0) {
                        System.out.print("Делить на ноль нельзя");
                        return;
                    }
                    break;
            }
            System.out.print("+, -, *, /, = ");
            d = scanner.next();
            if (d.equals("=")) {
                b = false;
            }
        }
            while (b) ;
        System.out.println(a);

        }
}