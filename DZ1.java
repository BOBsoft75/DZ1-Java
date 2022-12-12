import java.util.Scanner;

public class DZ1 {
    public static void main(String[] args) {
        menu();

    }
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Главное меню по ДЗ №1 (Java):");
        System.out.println();
        System.out.println("1 - Задача 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n)");
        System.out.println("2 - Задача 2. Вычислить n! (произведение чисел от 1 до n)");
        System.out.println("3 - Задача 3. Вывести все простые числа от 1 до 1000");
        System.out.println("4 - Задача 4. Реализовать простой калькулятор");
        System.out.println("5 - Задача 5*. Задано уравнение вида q + w = e, q, w, e >= 0.");
        while (true) {
            String choice = get_data(scanner, "Выборите (от 1 до 5, 0 - Выход): ");
            switch (choice) {
                case "1":
                    System.out.println("Введите число n: ");
                    int x = scanner.nextInt();
                    System.out.println("Треуголное число от " + x + " = " + triangle_num(x));
                    break;
                case "2":
                    System.out.println("Введите число n: ");
                    int y = scanner.nextInt();
                    System.out.println(y + "! = " + fact(y));
                    break;
                case "3":
                    int z = 1000;
                    System.out.println("Простые числа от 1 до 1000:");
                    simpleNumber1000(z);
                    break;
                case "4":
                    calculator();
                    break;
                case "5":
                    System.out.println("Не реализовано (((");
                    break;
                case "0":
                    scanner.close();
                    break;
            }
            System.out.println();
        }
    }
    public static int triangle_num(int x) {
        return x * (x + 1) / 2;
    }
    public static long fact(int y) {
        if (y == 1 || y == 0)
            return 1;
        return y*fact(y-1);
    }
    public static void simpleNumber1000(int x) {

        System.out.print("1");
        int[] arr = new int[x+1];
        for (int i = 2; i <= x; i++) {
            if (arr[i] == 0){
                System.out.print(" " + i);
                for (int j = i*2 ; j <= x ; j += i) {
                    arr[j] = -1;
                }
            }
        }
    }
    public static void calculator() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            double num1 = Double.parseDouble(get_data(scanner, "Введите первое число: "));
            double num2 = Double.parseDouble(get_data(scanner, "Введите второе число: "));
            String calculate = get_data(scanner, "Введите действие (Пример: +, -, *, /): ");
            Double res = 0.0;
            switch (calculate) {
                case "+": res = num1 + num2;
                    break;
                case "-": res = num1 - num2;
                    break;
                case "*": res = num1 * num2;
                    break;
                case "/": res = num1 / num2;
                    break;
            }
            System.out.println(num1 + " " + calculate + " " + num2 + " = " + res);
            break;
        }
    }
    public static String get_data(Scanner scanner, String text) {

        if (text.equals("")){
            scanner.close();
            return null;
        }
        System.out.println();
        System.out.print(text);
        String res =  scanner.nextLine();
        return res;

    }
}