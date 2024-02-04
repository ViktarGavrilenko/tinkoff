package exam20240204;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] data = scanner.nextLine().split(" ");
        int[] arrN = new int[n + 1];
        for (int i = 0; i < n * 4 - 1; i++) {
            arrN[Integer.parseInt(data[i])]++;
        }
        for (int i = 0; i < arrN.length; i++) {
            if (arrN[i] == 3) {
                System.out.println(i);
                break;
            }
        }
    }
}
