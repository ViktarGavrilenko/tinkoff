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

        HashMap<Integer, Integer> sadness = new HashMap<>();
        sadness.put(0, 0);
        sadness.put(1, 0);
        sadness.put(2, 1);
        for (int i = 3; i < 300001; i++) {
            sadness.put(i, (sadness.get(i - 1)) + i - 1);
        }
        int ans = 0;
        for (Map.Entry<Character, Integer> entry : dictionary.entrySet()) {
            Integer value = entry.getValue();
            ans += sadness.get(value);
        }
        System.out.println(ans);

    }
}
