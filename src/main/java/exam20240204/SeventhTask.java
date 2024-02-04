package exam20240204;

import java.util.HashSet;
import java.util.Scanner;

public class SeventhTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);
        int numberColors = Integer.parseInt(data[2]);
        int numberLines = Integer.parseInt(data[3]);

        String[] lines = new String[numberLines];
        for (int i = 0; i < numberLines; i++) {
            lines[i] = scanner.nextLine();
        }
        HashSet<Integer> horizontal = new HashSet<>();
        HashSet<Integer> vertical = new HashSet<>();

        int[] dictionaryColor = new int[numberColors + 1];

        for (int i = lines.length - 1; i >= 0; i--) {
            String[] dataLine = lines[i].split(" ");
            int type = Integer.parseInt(dataLine[0]);
            int number = Integer.parseInt(dataLine[1]) - 1;
            int color = Integer.parseInt(dataLine[2]);

            switch (type) {
                case 1:
                    if (!horizontal.contains(number)) {
                        dictionaryColor[color] += b - vertical.size();
                        horizontal.add(number);
                    }
                    break;
                case 2:
                    if (!vertical.contains(number)) {
                        dictionaryColor[color] += a - horizontal.size();
                        vertical.add(number);
                    }
                    break;
            }
        }
        for (int i = 1; i < dictionaryColor.length; i++) {
            System.out.print(dictionaryColor[i] + " ");
        }
    }
}