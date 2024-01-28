package eternalcontext;

import java.util.Scanner;

public class Stairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int limitTime = Integer.parseInt(data[1]);
        String[] floors = scanner.nextLine().split(" ");
        int[] numbersOfFloors = new int[floors.length];
        for (int i = 0; i < floors.length; i++) {
            numbersOfFloors[i] = Integer.parseInt(floors[i]);
        }
        int numberOfOutgoing = scanner.nextInt() - 1;
        int sumMinutes = 0;
        int numbersLast = numbersOfFloors[numbersOfFloors.length - 1] - numbersOfFloors[numberOfOutgoing];
        int numberBeginning = numbersOfFloors[numberOfOutgoing] - numbersOfFloors[0];
        if (!(numberBeginning <= limitTime || numbersLast <= limitTime)) {
            sumMinutes = Math.min(numberBeginning, numbersLast);
        }
        sumMinutes = sumMinutes + numbersOfFloors[numbersOfFloors.length - 1] - numbersOfFloors[0];
        System.out.println(sumMinutes);
    }
}