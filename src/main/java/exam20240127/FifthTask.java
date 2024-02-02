package exam20240127;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class FifthTask {

    HashMap<Integer, TreeSet<Integer>> rooms = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberRooms = Integer.parseInt(scanner.nextLine());
        FifthTask fifthTask = new FifthTask();
        for (int i = 1; i <= numberRooms; i++) {
            fifthTask.rooms.put(i, new TreeSet<>());
        }
        for (int i = 0; i < numberRooms - 1; i++) {
            String[] data = scanner.nextLine().split(" ");
            int firstRoom = Integer.parseInt(data[0]);
            int secondRoom = Integer.parseInt(data[1]);
            TreeSet<Integer> nextFirstRooms = fifthTask.rooms.get(firstRoom);
            nextFirstRooms.add(secondRoom);
            fifthTask.rooms.put(firstRoom, nextFirstRooms);
            TreeSet<Integer> nextSecondRooms = fifthTask.rooms.get(secondRoom);
            nextSecondRooms.add(firstRoom);
            fifthTask.rooms.put(secondRoom, nextSecondRooms);
        }

        int numberQuestions = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberQuestions; i++) {
            String[] data = scanner.nextLine().split(" ");
            int start = Integer.parseInt(data[0]);
            int finish = Integer.parseInt(data[1]);

            ArrayList<Integer> nextRooms = new ArrayList<>(fifthTask.rooms.get(start));

            for (Integer nextRoom : nextRooms) {
                if (nextRoom == finish) {
                    System.out.println(finish);
                    break;
                } else {
                    fifthTask.findRoom(nextRoom, finish, nextRoom, start);
                }
            }
        }
    }

    public void findRoom(int start, int finishRoom, int answer, int prev) {
        ArrayList<Integer> nextRooms = new ArrayList<>(rooms.get(start));

        for (int room : nextRooms) {
            if (room == finishRoom) {
                System.out.println(answer);
                break;
            } else {
                if (room != prev) {
                    findRoom(room, finishRoom, answer, start);
                }
            }
        }
    }
}