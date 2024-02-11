package exam20240211qaingenering;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int numberDevelopers = Integer.parseInt(scanner.nextLine());
            String[] dataConnects = scanner.nextLine().split(" ");
            long connects = 0;
            for (int j = 0; j < dataConnects.length; j++) {
                connects += Long.parseLong(dataConnects[j]);
            }
            if (2 * (numberDevelopers - 1) <= connects || numberDevelopers == 1) {
                ans.append("Yes").append("\n");
            } else {
                ans.append("No").append("\n");
            }
        }
        System.out.println(ans);
    }
}
