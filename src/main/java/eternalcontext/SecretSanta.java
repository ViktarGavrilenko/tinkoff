package eternalcontext;

import java.util.ArrayList;
import java.util.Scanner;

public class SecretSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberStudents = scanner.nextInt();
        scanner.nextLine();
        String[] list = scanner.nextLine().split(" ");
        ArrayList<ArrayList<Integer>> receiverList = new ArrayList<>();
        for (int i = 0; i <= numberStudents; i++) {
            ArrayList<Integer> givenList = new ArrayList<>();
            receiverList.add(givenList);
        }
        for (int i = 0; i < numberStudents; i++) {
            int number = Integer.parseInt(list[i]);
            ArrayList<Integer> givenList = receiverList.get(number);
            givenList.add(i + 1);
            receiverList.set(number, givenList);
        }
        boolean isImpossible = true;
        int maxNumber = -1;
        int minNumber = -1;
        for (int i = 1; i <= numberStudents; i++) {
            int numbers = receiverList.get(i).size();
            if (numbers > 2) {
                isImpossible = false;
                break;
            }
            if (numbers == 0) {
                if (minNumber == -1) {
                    minNumber = i;
                } else {
                    isImpossible = false;
                    break;
                }
            }
            if (numbers == 2) {
                if (maxNumber == -1) {
                    maxNumber = i;
                } else {
                    isImpossible = false;
                    break;
                }
            }
        }

        int changeableNumber = -1;
        int newNumber = -1;
        int alternativeChangeableNumber = -1;
        ArrayList<Integer> alternativeMax = new ArrayList<>();
        ArrayList<ArrayList<Integer>> alternativeReceiverList = new ArrayList<>();
        boolean alternativeFlag = false;

        if (isImpossible && maxNumber != -1 && minNumber != -1) {
            ArrayList<Integer> maxList = receiverList.get(maxNumber);
            for (int i = 0; i < maxList.size(); i++) {
                if (maxList.get(i) == maxNumber) {
                    ArrayList<Integer> minList = new ArrayList<>();
                    changeableNumber = maxList.get(i);
                    newNumber = minNumber;
                    minList.add(maxList.get(i));
                    receiverList.set(minNumber, minList);
                    maxList.remove(i);
                    receiverList.set(maxNumber, maxList);
                    break;
                }
                if (maxList.get(i) == minNumber) {
                    ArrayList<Integer> maxNewList = new ArrayList<>();
                    maxNewList.add(maxList.get(i));
                    maxList.remove(i);
                    changeableNumber = maxList.get(0);
                    newNumber = minNumber;
                    receiverList.set(minNumber, maxList);
                    receiverList.set(maxNumber, maxNewList);
                    break;
                }
            }
            if (receiverList.get(maxNumber).size() == 2) {
                alternativeReceiverList.addAll(receiverList);
                changeableNumber = maxList.get(0);
                newNumber = minNumber;
                alternativeChangeableNumber = maxList.get(1);
                alternativeMax.add(maxList.get(0));
                receiverList.set(minNumber, alternativeMax);
                alternativeReceiverList.set(maxNumber, alternativeMax);
                maxList.remove(0);
                receiverList.set(maxNumber, maxList);
                alternativeReceiverList.set(minNumber, maxList);
                alternativeFlag = true;
            }
        }
        int step = 1;
        boolean flag = false;
        for (int i = 1; i <= numberStudents + 1; i++) {
            if (receiverList.get(step).size() != 0) {
                int newStep = receiverList.get(step).get(0);
                receiverList.set(step, new ArrayList<>());
                step = newStep;
            } else {
                if (i != numberStudents + 1) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag && alternativeFlag) {
            changeableNumber = alternativeChangeableNumber;
            for (int i = 1; i <= numberStudents + 1; i++) {
                if (alternativeReceiverList.get(step).size() != 0) {
                    int newStep = alternativeReceiverList.get(step).get(0);
                    alternativeReceiverList.set(step, new ArrayList<>());
                    step = newStep;
                } else {
                    if (i != numberStudents + 1) {
                        changeableNumber = -1;
                        newNumber = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(changeableNumber + " " + newNumber);
    }
}