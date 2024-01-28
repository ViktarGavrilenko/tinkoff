package eternalcontext;

import java.util.Scanner;

public class Lunches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberDays = scanner.nextInt();
        scanner.nextLine();
        int[] costLunch = new int[numberDays];
        int maxCoupon = 0;
        int infinity = 10000000;
        for (int i = 0; i < numberDays; i++) {
            costLunch[i] = scanner.nextInt();
            scanner.nextLine();
            if (costLunch[i] > 100) {
                maxCoupon++;
            }
        }
        int[][] dp = new int[numberDays][maxCoupon + 3];
        if (numberDays > 0) {
            for (int i = 0; i < maxCoupon + 3; i++) {
                dp[0][i] = infinity;
            }
            if (costLunch[0] > 100) {
                dp[0][2] = costLunch[0];
                dp[0][1] = infinity;
            } else {
                dp[0][1] = costLunch[0];
            }
            for (int i = 1; i < numberDays; i++) {
                for (int j = 0; j < maxCoupon + 3; j++) {
                    dp[i][j] = infinity;
                }
                for (int j = 1; j < maxCoupon + 2; j++) {
                    if (costLunch[i] > 100) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + costLunch[i], dp[i - 1][j + 1]);

                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + costLunch[i], dp[i - 1][j + 1]);
                    }
                }
            }
            int minCost = dp[numberDays - 1][1];
            for (int i = 1; i < maxCoupon + 2; i++) {
                if (dp[numberDays - 1][i] <= minCost) {
                    minCost = dp[numberDays - 1][i];
                }
            }
            System.out.println(minCost);
        }
        if (numberDays == 0) {
            System.out.println(0);
        }
    }
}