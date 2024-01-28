package exam20231030;


import java.util.*;

public class Fourth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int amount = Integer.parseInt(data[0]);
        int numberDenomination = Integer.parseInt(data[1]);

        List<Integer> denominations = new ArrayList<>();
        for (int i = 0; i < numberDenomination; i++) {
            denominations.add(scanner.nextInt());
        }

        Map<Integer, Integer> bank = new HashMap<>();
        for (int nominal : denominations) {
            bank.put(nominal, bank.getOrDefault(nominal, 0) + 2);
        }

        List<Integer> combination = findCombination(amount, bank);
        if (combination == null) {
            System.out.println("-1");
        } else {
            System.out.println(combination.size() + " ");
            for (int nominal : combination) {
                System.out.print(nominal + " ");
            }
        }
    }

    public static List<Integer> findCombination(int total, Map<Integer, Integer> bank) {
        if (total == 0) {
            return new ArrayList<>();
        }

        for (int nominal : bank.keySet()) {
            int count = bank.get(nominal);
            if (count > 0 && total >= nominal) {
                bank.put(nominal, count - 1);
                List<Integer> combination = findCombination(total - nominal, bank);
                if (combination != null) {
                    combination.add(nominal);
                    return combination;
                }
                bank.put(nominal, count);
            }
        }
        return null;
    }
}