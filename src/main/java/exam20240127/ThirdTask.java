package exam20240127;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberGifts = Integer.parseInt(scanner.nextLine());
        ArrayList<ArrayList<Integer>> daysOfSend = new ArrayList<>();
        for (int i = 0; i < numberGifts; i++) {
            String[] data = scanner.nextLine().split(" ");
            ArrayList<Integer> days = new ArrayList<>();
            int startDay = Integer.parseInt(data[0]) + Integer.parseInt(data[1]);
            int ensDay = Integer.parseInt(data[2]);
            for (int j = startDay; j <= ensDay; j++) {
                days.add(j);
            }
            daysOfSend.add(days);
        }

        while (daysOfSend.size() > 0) {
            daysOfSend.sort(new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                    return Integer.compare(list1.size(), list2.size());
                }
            });
            if (daysOfSend.get(0).size() == 0) {
                System.out.println("NO");
                return;
            }
            int day = daysOfSend.get(0).get(0);

            for (int i = 1; i < daysOfSend.size(); i++) {
                int result = Collections.binarySearch(daysOfSend.get(i), day);
                if (result != -1) {
                    daysOfSend.get(i).remove(result);
                }
            }
            daysOfSend.remove(0);
        }
        System.out.println("YES");
    }
}