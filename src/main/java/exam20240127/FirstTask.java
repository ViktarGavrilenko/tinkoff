package exam20240127;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String out = str.replaceAll("code\\d+", "???");
        System.out.println(out);
    }
}