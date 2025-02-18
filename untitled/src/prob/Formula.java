package prob;

public class Formula {
    int discrimenant(double a, double b, double c) {
        double chislo = b;
        int stepen = 2;
        double s = Math.pow(chislo, stepen);
        double reshenie = s - 4 * a * c;
        System.out.println("Дискрименант: " + reshenie);
        if (reshenie < 0) {
            System.out.println("Корней нет");
        }
        double nahozhdenieCorney1 = ((-b + Math.sqrt(reshenie)) / (2 * a));
        if (nahozhdenieCorney1 > 0) {
            System.out.println("Первый корень: " + nahozhdenieCorney1);
        }
        if (nahozhdenieCorney1 == 0) {
            System.out.println("Первый корень: " + nahozhdenieCorney1);
        }
        if (nahozhdenieCorney1 < 0) {
            System.out.println("Первый корень: " + nahozhdenieCorney1);
        }
        double nahozhdenieCorney2 = ((-b - Math.sqrt(reshenie)) / (2 * a));
        if (nahozhdenieCorney2 > 0) {
            System.out.println("Второй : " + nahozhdenieCorney2);
        }
        if (nahozhdenieCorney2 == 0) {
            System.out.println("Второй корень: " + nahozhdenieCorney2);
        }
        if (nahozhdenieCorney2 < 0) {
            System.out.println("Второй корень: " + nahozhdenieCorney2);
        }
        return (int) reshenie;
    }

    public static void main(String[] args) {
 Formula formula = new Formula();
        double triCesla1 = formula.discrimenant(4.0,5.0,1.0);
        double triCesla2 = formula.discrimenant(7,-2,3);

    }
}

