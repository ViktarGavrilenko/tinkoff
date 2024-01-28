package eternalcontext;

import java.util.Scanner;

public class PhysicalEducation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberStudents = scanner.nextInt();
        scanner.nextLine();
        String[] height = scanner.nextLine().split(" ");
        int even = -1;
        int odd = -1;
        for (int i = 1; i <= numberStudents; i++) {
            int heightStudent = Integer.parseInt(height[i - 1]);
            if (i % 2 == 0) {
                if (heightStudent % 2 != 0) {
                    if (even == -1) {
                        even = i;
                    } else {
                        even = -1;
                        odd = -1;
                        break;
                    }
                }
            } else {
                if (heightStudent % 2 == 0) {
                    if (odd == -1) {
                        odd = i;
                    } else {
                        even = -1;
                        odd = -1;
                        break;
                    }
                }
            }
            if (i == numberStudents && odd == -1 && even == -1 && numberStudents > 2) {
                even = 1;
                odd = 3;
            }
        }
        if (odd == -1 || even == -1) {
            even = -1;
            odd = -1;
        }
        System.out.println(odd + " " + even);
    }
}