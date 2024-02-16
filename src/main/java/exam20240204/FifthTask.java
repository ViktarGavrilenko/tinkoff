package exam20240204;

import java.util.Scanner;

public class FifthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();

        int[] arrSadness = new int[300001];
        arrSadness[0] = 0;
        arrSadness[1] = 0;
        arrSadness[2] = 1;

        for (int i = 3; i < 300001; i++) {
            arrSadness[i] = arrSadness[i - 1] + i - 1;
        }
        int ans = 0;
        int similar = 1;
        for (int i = 1; i < l; i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                similar++;
            } else {
                if (similar > 1) {
                    ans += arrSadness[similar];
                }
                similar = 1;
            }
        }
        if (similar > 1) {
            ans += arrSadness[similar];
        }
        System.out.println(ans);
    }
}