package exam20231030;

import java.util.Arrays;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int numberDollars = Integer.parseInt(data[1]);
        String[] dataPrice = scanner.nextLine().split(" ");
        int[] price = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            price[i] = Integer.parseInt(dataPrice[i]);
        }
        Arrays.sort(price);
        System.out.println(binarySearch(0, price.length - 1, numberDollars, price));
    }

    static int binarySearch(int left, int right, int check, int[] array) {
        while (left < right) {
            int middle = (left + right + 1) / 2;
            if (check > array[middle]) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        if (left == 0) {
            if (check >= array[left]) {
                return array[left];
            } else {
                return 0;
            }
        }
        return array[left];
    }
}