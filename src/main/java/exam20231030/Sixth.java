package exam20231030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Sixth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int numberSpirits = Integer.parseInt(data[0]);
        int numberQuestions = Integer.parseInt(data[1]);
        ArrayList<Spirit> spirits = new ArrayList<>();
        spirits.add(new Spirit(0, 0));
        HashMap<Integer, ArrayList<Integer>> gangs = new HashMap<>();
        int maxNumberGang = 0;
        for (int i = 1; i <= numberSpirits; i++) {
            spirits.add(new Spirit(1, i));
            ArrayList<Integer> listGang = new ArrayList<>();
            listGang.add(i);
            gangs.put(i, listGang);
            maxNumberGang = i;
        }
        for (int i = 0; i < numberQuestions; i++) {
            String[] question = scanner.nextLine().split(" ");
            switch (Integer.parseInt(question[0])) {
                case 1:
                    int gangNumberFirst = spirits.get(Integer.parseInt(question[1])).gangNumber;
                    int gangNumberSecond = spirits.get(Integer.parseInt(question[2])).gangNumber;
                    if (gangNumberFirst != gangNumberSecond) {
                        maxNumberGang++;
                        ArrayList<Integer> listGang = new ArrayList<>();
                        for (int j = 0; j < gangs.get(gangNumberFirst).size(); j++) {
                            listGang.add(gangs.get(gangNumberFirst).get(j));
                            Spirit spiritFromGang = spirits.get(gangs.get(gangNumberFirst).get(j));
                            spiritFromGang.setGangNumber(maxNumberGang);
                            spiritFromGang.setNumberOfGangs(spiritFromGang.getNumberOfGangs() + 1);
                            spirits.set(gangs.get(gangNumberFirst).get(j), spiritFromGang);
                        }
                        gangs.remove(gangNumberFirst);
                        for (int j = 0; j < gangs.get(gangNumberSecond).size(); j++) {
                            listGang.add(gangs.get(gangNumberSecond).get(j));
                            Spirit spiritFromGang = spirits.get(gangs.get(gangNumberSecond).get(j));
                            spiritFromGang.setGangNumber(maxNumberGang);
                            spiritFromGang.setNumberOfGangs(spiritFromGang.getNumberOfGangs() + 1);
                            spirits.set(gangs.get(gangNumberSecond).get(j), spiritFromGang);
                        }
                        gangs.remove(gangNumberSecond);
                        gangs.put(maxNumberGang, listGang);
                    }
                    break;
                case 2:
                    if (spirits.get(Integer.parseInt(question[1])).gangNumber ==
                            spirits.get(Integer.parseInt(question[2])).gangNumber) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    break;
                case 3:
                    System.out.println(spirits.get(Integer.parseInt(question[1])).numberOfGangs);
            }
        }
    }

    static class Spirit {
        int numberOfGangs;
        int gangNumber;

        public Spirit(int numberOfGangs, int gangNumber) {
            this.numberOfGangs = numberOfGangs;
            this.gangNumber = gangNumber;
        }

        public int getNumberOfGangs() {
            return numberOfGangs;
        }

        public void setNumberOfGangs(int numberOfGangs) {
            this.numberOfGangs = numberOfGangs;
        }

        public void setGangNumber(int gangNumber) {
            this.gangNumber = gangNumber;
        }
    }
}