package eternalcontext;

import java.util.Scanner;

public class FirsTask{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int subscriptionFee = Integer.parseInt(data[0]);
        int numberMb = Integer.parseInt(data[1]);
        int costOver = Integer.parseInt(data[2]);
        int sizeMb = Integer.parseInt(data[3]);
        int ans;
        if (sizeMb <= numberMb) {
            ans= subscriptionFee;
        } else {
            ans= subscriptionFee + (sizeMb - numberMb) * costOver;
        }
        System.out.println(ans);
    }
}