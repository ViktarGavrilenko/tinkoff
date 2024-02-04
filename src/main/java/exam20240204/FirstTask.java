package exam20240204;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] data = scanner.nextLine().split(" ");
        int firstPos = Integer.parseInt(data[0]) - 1;
        int secondPos = Integer.parseInt(data[1]) - 1;
        char first = str.charAt(firstPos);
        char second = str.charAt(secondPos);
        if (firstPos == secondPos) {
            System.out.println(str);
        } else {
            String ans = str.substring(0, firstPos) + second + str.substring(firstPos + 1, secondPos) + first + str.substring(secondPos + 1);
            System.out.println(ans);
        }
    }
}
