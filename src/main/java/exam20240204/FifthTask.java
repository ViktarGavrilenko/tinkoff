package exam20240204;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FifthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        HashMap<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put((char) (97 + i), 0);
        }
        for (int i = 0; i < str.length(); i++) {
            dictionary.put(str.charAt(i), dictionary.get(str.charAt(i)) + 1);
        }

        int[] arrSadness = new int[300001];
        arrSadness[0] = 0;
        arrSadness[1] = 0;
        arrSadness[2] = 1;

        for (int i = 3; i < 300001; i++) {
            arrSadness[i] = arrSadness[i - 1] + i - 1;
        }
        int ans = 0;
        for (Map.Entry<Character, Integer> entry : dictionary.entrySet()) {
            Integer value = entry.getValue();
            ans += arrSadness[value];
        }
        System.out.println(ans);
    }
}