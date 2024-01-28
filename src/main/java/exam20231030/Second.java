package exam20231030;

import java.util.HashMap;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        HashMap<Character, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (dictionary.containsKey(str.charAt(i))) {
                int numberLetter = dictionary.get(str.charAt(i)) + 1;
                dictionary.put(str.charAt(i), numberLetter);
            } else {
                dictionary.put(str.charAt(i), 1);
            }
        }
        String sheriff = "sheri";
        int min = 0;
        if (dictionary.containsKey('f')) {
            min = dictionary.get('f') / 2;
            for (int i = 0; i < sheriff.length(); i++) {
                if (dictionary.containsKey(sheriff.charAt(i))) {
                    if (dictionary.get(sheriff.charAt(i)) < min) {
                        min = dictionary.get(sheriff.charAt(i));
                    }
                } else {
                    min = 0;
                    break;
                }
            }
        }
        System.out.println(min);
    }
}