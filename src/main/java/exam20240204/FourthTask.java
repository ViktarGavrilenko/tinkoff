package exam20240204;

import java.util.HashMap;
import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        HashMap<Character, Integer> key = new HashMap<>();
        key.put('D', 0);
        key.put('U', 1);
        key.put('L', 2);
        key.put('R', 3);
        int[] x = new int[]{0, 0, -1, 1};
        int[] y = new int[]{-1, 1, 0, 0};
        int[][] path = new int[l * 2 + 1][l * 2 + 1];
        int pointX = l;
        int pointY = l;
        path[pointX][pointY] = 1;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            int direction = key.get(str.charAt(i));
            if (path[pointX + x[direction]][pointY + y[direction]] == 1) {
                System.out.println("YES");
                flag = false;
                break;
            } else {
                path[pointX + x[direction]][pointY + y[direction]] = 1;
                pointX += x[direction];
                pointY += y[direction];
            }
        }
        if (flag) {
            System.out.println("NO");
        }
    }
}