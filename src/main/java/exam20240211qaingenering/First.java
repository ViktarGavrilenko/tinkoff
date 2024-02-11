package exam20240211qaingenering;

import java.util.HashMap;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < t; i++) {
            HashMap<Character, Integer> dictionary = new HashMap<>();
            String str = scanner.nextLine();
            boolean flag = true;
            if (str.length() == 7) {
                for (int j = 0; j < str.length(); j++) {
                    if (dictionary.containsKey(str.charAt(j))) {
                        int numberLetter = dictionary.get(str.charAt(j)) + 1;
                        dictionary.put(str.charAt(j), numberLetter);
                    } else {
                        dictionary.put(str.charAt(j), 1);
                    }
                }
                String sheriff = "TINKO";

                if (dictionary.containsKey('F')) {
                    if (dictionary.get('F') >= 2) {
                        for (int j = 0; j < sheriff.length(); j++) {
                            if (!dictionary.containsKey(sheriff.charAt(j))) {
                                flag = false;
                                break;
                            }
                        }
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
            if (flag) {
                ans.append("Yes").append("\n");
            } else {
                ans.append("No").append("\n");
            }
        }
        System.out.println(ans);
    }
}
