package eternalcontext;

import java.util.Scanner;

public class Roll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numberOfPersons = scanner.nextLong();
        long cuts = 0;
        if (numberOfPersons != 1) {
            for (long i = 0; i < 32; i++) {
                long degree = 2L << i;
                if (degree >= numberOfPersons) {
                    cuts = i + 1;
                    break;
                }
            }
        }
        System.out.println(cuts);
    }
}