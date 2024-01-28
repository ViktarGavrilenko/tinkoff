package exam20240127;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class FifthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberRooms = Integer.parseInt(scanner.nextLine());
        HashMap<Integer, TreeSet<Integer>> rooms = new HashMap<>();
        for (int i = 1; i <= numberRooms; i++) {
            rooms.put(i, new TreeSet<>());
        }
        for (int i = 0; i < numberRooms - 1; i++) {
            String[] data = scanner.nextLine().split(" ");
            int firstRoom = Integer.parseInt(data[0]);
            int secondRoom = Integer.parseInt(data[1]);
            TreeSet<Integer> nextFirstRooms = rooms.get(firstRoom);
            nextFirstRooms.add(secondRoom);
            rooms.put(firstRoom, nextFirstRooms);
            TreeSet<Integer> nextSecondRooms = rooms.get(secondRoom);
            nextSecondRooms.add(firstRoom);
            rooms.put(secondRoom, nextSecondRooms);
        }

        System.out.println(rooms);


        int numberQuestions = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberQuestions; i++) {
            String[] data = scanner.nextLine().split(" ");
            int start = Integer.parseInt(data[0]);
            int finish = Integer.parseInt(data[1]);

            ArrayList<Integer> nextRooms = new ArrayList<>(rooms.get(start));
            int minSteps = Integer.MAX_VALUE;
            int minNumberRoom;

            for (int j = 0; j < nextRooms.size(); j++) {
                int steps = 1;
                if (finish == nextRooms.get(j)) {
                    minSteps = steps;
                    minNumberRoom = nextRooms.get(j);
                    break;
                }
                HashMap<Integer, TreeSet<Integer>> cloneRooms = (HashMap<Integer, TreeSet<Integer>>) rooms.clone();
                ArrayList<Integer> nextPath = new ArrayList<>(cloneRooms.get(j));
                cloneRooms.remove(j);

                while (!nextPath.isEmpty()) {
                    int nextNumber = nextPath.get(nextRooms.size() - 1);
                    if (finish == nextNumber) {
                        if (steps < minSteps) {
                            minSteps = steps;
                            minNumberRoom = nextRooms.get(j);
                        }
                        break;
                    } else {
                        nextPath.remove(nextPath.size() - 1);
                        nextPath.addAll(rooms.get(nextNumber));
                    }
                }
            }
        }
    }
}

