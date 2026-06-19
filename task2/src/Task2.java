import java.io.File;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) return;

        Scanner sc1 = new Scanner(new File(args[0]));
        double x0 = sc1.nextDouble(), y0 = sc1.nextDouble();
        double a = sc1.nextDouble(), b = sc1.nextDouble();
        sc1.close();

        Scanner sc2 = new Scanner(new File(args[1]));
        while (sc2.hasNextDouble()) {
            double x = sc2.nextDouble();
            double y = sc2.nextDouble();
            double res = ((x - x0) * (x - x0)) / (a * a) + ((y - y0) * (y - y0)) / (b * b);

            if (Math.abs(res - 1.0) < 1e-9) {
                System.out.println(0);
            } else if (res < 1.0) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
        sc2.close();
    }
}