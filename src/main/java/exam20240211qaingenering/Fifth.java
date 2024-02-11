package exam20240211qaingenering;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Fifth {
    HashSet<Integer> friends = new HashSet<>();
    int countManul = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int numberChildren = Integer.parseInt(data[0]);
        int numberPairs = Integer.parseInt(data[1]);
        int numberEvents = Integer.parseInt(data[2]);
        String[] dataManull = scanner.nextLine().split(" ");
        ArrayList<Fifth> childrenList = new ArrayList<>();
        childrenList.add(new Fifth());
        for (int i = 0; i < dataManull.length; i++) {
            Fifth child = new Fifth();
            child.countManul = Integer.parseInt(dataManull[i]);
            childrenList.add(child);
        }
        for (int i = 0; i < numberPairs; i++) {
            String[] pair = scanner.nextLine().split(" ");
            int first = Integer.parseInt(pair[0]);
            int second = Integer.parseInt(pair[1]);
            childrenList.get(first).friends.add(second);
            childrenList.get(second).friends.add(first);

        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numberEvents; i++) {
            String[] event = scanner.nextLine().split(" ");
            if (event.length == 2) {
                ans.append(childrenList.get(Integer.parseInt(event[1])).countManul).append("\n");
            } else {
                HashSet<Integer> friends = childrenList.get(Integer.parseInt(event[1])).friends;
                for (int friend : friends) {
                    childrenList.get(friend).countManul += Integer.parseInt(event[2]);
                }
            }
        }
        System.out.println(ans);
    }
}