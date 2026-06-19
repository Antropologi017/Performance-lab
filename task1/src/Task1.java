public class Task1 {
    public static void main(String[] args) {

        if (args.length < 4) {
            System.out.println("Введите 4 аргумента: n1 m1 n2 m2");
            return;
        }
        // аргументы
        int n1 = Integer.parseInt(args[0]);
        int m1 = Integer.parseInt(args[1]);
        int n2 = Integer.parseInt(args[2]);
        int m2 = Integer.parseInt(args[3]);

        String itog = "";

        // Массив1
        int i = 0;
        while (true) {
            itog += (i + 1);
            i = (i + m1 - 1) % n1;
            if (i == 0) {
                break;
            }
        }

        // Массив 2
        int j = 0;
        while (true) {
            itog += (j + 1);
            j = (j + m2 - 1) % n2;
            if (j == 0) {
                break;
            }
        }
        System.out.println(itog);
    }
}