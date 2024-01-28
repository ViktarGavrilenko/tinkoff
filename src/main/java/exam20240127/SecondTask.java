package exam20240127;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int str = Integer.parseInt(scanner.nextLine());
        String[] heightBooksStr = scanner.nextLine().split(" ");
        HashMap<Integer, Integer> books = new HashMap<>();
        for (String s : heightBooksStr) {
            int heightBook = Integer.parseInt(s);
            if (books.containsKey(heightBook)) {
                books.put(heightBook, books.get(heightBook) + 1);
            } else {
                books.put(heightBook, 1);
            }
        }
        ArrayList<Integer> sortHeightBooks = new ArrayList<>();
        for (HashMap.Entry<Integer, Integer> entry : books.entrySet()) {
            sortHeightBooks.add(entry.getValue());
        }
        Collections.sort(sortHeightBooks);
        System.out.println(sortHeightBooks.size());
        StringBuilder out = new StringBuilder();
        for (Integer height : sortHeightBooks) {
            out.append(height).append(" ");
        }
        System.out.println(out);
    }
}