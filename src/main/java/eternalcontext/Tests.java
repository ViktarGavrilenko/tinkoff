package eternalcontext;

import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        long min = Long.parseLong(data[0]);
        long max = Long.parseLong(data[1]);
        int lengthMin = data[0].length();
        int lengthMax = data[1].length();
        int numberOfTest = 0;
        int firstDigitMin = (int) (min / Math.pow(10, lengthMin - 1));
        int firstDigitMax = (int) (max / Math.pow(10, lengthMax - 1));
        long firstTest = 0;
        for (int i = 0; i < lengthMin; i++) {
            firstTest = firstTest * 10 + firstDigitMin;
        }
        long lastTest = 0;
        for (int i = 0; i < lengthMax; i++) {
            lastTest = lastTest * 10 + firstDigitMax;
        }
        if (lengthMin == lengthMax) {
            numberOfTest = firstDigitMax - firstDigitMin + 1;
            if (firstTest < min) {
                numberOfTest--;
            }
            if (lastTest > max) {
                numberOfTest--;
            }
        } else {
            for (int i = lengthMin + 1; i < lengthMax; i++) {
                numberOfTest += 9;
            }
            if (firstTest >= min) {
                numberOfTest = numberOfTest + 10 - firstDigitMin;
            } else {
                numberOfTest = numberOfTest + 10 - firstDigitMin - 1;
            }
            if (lastTest > max) {
                numberOfTest = numberOfTest + firstDigitMax - 1;
            } else {
                numberOfTest = numberOfTest + firstDigitMax;
            }
        }
        System.out.println(numberOfTest);
    }
}