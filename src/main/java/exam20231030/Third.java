package exam20231030;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCards = Integer.parseInt(scanner.nextLine());
        String[] dataJoeList = scanner.nextLine().split(" ");
        String[] dataWinnerList = scanner.nextLine().split(" ");
        String ans = "YES";
        for (int i = 0; i < numberCards; i++) {
            int count = 0;
            int joeCard = Integer.parseInt(dataJoeList[i]);
            int winnerCard = Integer.parseInt(dataWinnerList[i]);
            if (joeCard != winnerCard) {
                if (count > 0) {
                    ans = "NO";
                    break;
                }
                count++;
                ArrayList<Integer> winnerPart = new ArrayList<>();
                ArrayList<Integer> joePart = new ArrayList<>();
                winnerPart.add(winnerCard);
                joePart.add(joeCard);
                i++;
                if (i < numberCards) {
                    int nextWinnerCard = Integer.parseInt(dataWinnerList[i]);
                    int nextJoeCard = Integer.parseInt(dataJoeList[i]);
                    while (winnerCard <= nextWinnerCard) {
                        winnerPart.add(nextWinnerCard);
                        joePart.add(nextJoeCard);
                        i++;
                        if (i >= numberCards) {
                            break;
                        }
                        winnerCard = nextWinnerCard;
                        nextWinnerCard = Integer.parseInt(dataWinnerList[i]);
                        nextJoeCard = Integer.parseInt(dataJoeList[i]);
                    }
                }
                Collections.sort(joePart);
                if (!joePart.equals(winnerPart)) {
                    ans = "NO";
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}