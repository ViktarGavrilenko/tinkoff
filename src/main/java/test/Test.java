package test;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        int total = 0;

        for (Integer x : numbers) {
            if (x % 2 == 0) total += x * x;
        }
        System.out.println(total);

        //int t= numbers.stream().filter(x->x%2==0).collect(Collections.toInt());
        //int t= numbers.stream().mapToInt(x->{if (x%2==0) return x*x}).sum();
        int t = numbers.stream().mapToInt(x -> x % 2 == 0 ? x * x : 0).sum();
        System.out.println(t);
    }
}
