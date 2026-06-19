import java.io.File;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }
        String path = args[0];

        Scanner sc1 = new Scanner(new File(path));
        int count = 0;
        while (sc1.hasNextInt()) {
            count++;
            sc1.nextInt();
        }
        sc1.close();

        if (count == 0) {
            System.out.print(0);
            return;
        }
        int[] n = new int[count];
        Scanner sc2 = new Scanner(new File(path));
        for (int i = 0; i < count; i++) {
            n[i] = sc2.nextInt();
        }
        sc2.close();

        for (int i = 0; i < n.length - 1; i++) {
            for (int j = 0; j < n.length - i - 1; j++) {
                if (n[j] > n[j + 1]) {
                    int temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }
            }
        }

        int mediana = n[n.length / 2];
        long moves = 0;
        for (int i = 0; i < n.length; i++) {
            int diff = n[i] - mediana;
            if (diff < 0) {
                diff = -diff;
            }
            moves += diff;
        }
        if (moves <= 20) {
            System.out.print(moves);
        } else {
            System.out.print("20 ходов недостаточно для приведения всех элементов массива к одному числу");
        }
    }
}