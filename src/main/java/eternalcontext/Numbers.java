package eternalcontext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int amountOfNumbers = Integer.parseInt(firstLine[0]);
        int amountOfNewNumbers = Integer.parseInt(firstLine[1]);
        ArrayList<ArrayList<Integer>> allNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            allNumbers.add(new ArrayList<>());
        }
        long allSum = 0;
        String[] secondLine = scanner.nextLine().split(" ");
        for (int i = 0; i < amountOfNumbers; i++) {
            int number = Integer.parseInt(secondLine[i]);
            allSum = allSum + number;
            int count = 0;
            int tempNumber = number;
            while (tempNumber / 10 >= 1) {
                count++;
                tempNumber = tempNumber / 10;
            }
            ArrayList<Integer> numbers = allNumbers.get(count);
            numbers.add(number);
            allNumbers.set(count, numbers);
        }
        long difference = 0;
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> numbers = allNumbers.get(i);
            Collections.sort(numbers);
            allNumbers.set(i, numbers);
        }

        for (int i = allNumbers.size() - 1; i >= 0; i--) {
            for (int j = 0; j < allNumbers.get(i).size(); j++) {
                int number = allNumbers.get(i).get(j);
                String strNumber = String.valueOf(number);
                for (int k = 0; k <= i; k++) {
                    if (amountOfNewNumbers > 0) {
                        strNumber = strNumber.substring(0, k) + "9" + strNumber.substring(k + 1);
                        amountOfNewNumbers--;
                    } else {
                        break;
                    }
                }
                int newNumber = Integer.parseInt(strNumber);
                difference = difference + (newNumber - number);
                if (amountOfNewNumbers == 0) {
                    break;
                }
            }
            if (amountOfNewNumbers == 0) {
                break;
            }
        }
        System.out.println(difference);
    }
}