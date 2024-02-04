package exam20240204;

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        long l = Long.parseLong(data[1]);
        long w = Long.parseLong(data[2]);
        String[] coordinates = scanner.nextLine().split(" ");

        long count = 0;
        long indicator = 0;
        int numberCoordinates = 0;
        while (indicator < l) {
            if (numberCoordinates < coordinates.length) {
                long startWall = Long.parseLong(coordinates[numberCoordinates]);
                if (startWall > indicator) {
                    long numberWalls = round((startWall - indicator), w);
                    indicator += w * numberWalls;
                    if (indicator > startWall) {
                        indicator = startWall + w;
                        numberCoordinates++;

                    }
                    count += numberWalls;
                } else {
                    indicator += w;
                    numberCoordinates++;
                }
            } else {
                count += round((l - indicator), w);
                indicator += round((l - indicator), w) * w;
            }
        }
        System.out.println(count);
    }

    static long round(long a, long b) {
        if (a % b == 0) {
            return a / b;
        } else {
            return a / b + 1;
        }
    }
}