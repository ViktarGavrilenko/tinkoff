package exam20240211qaingenering;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Fourth {
    ArrayList<TopTree> listTop = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int treeSize = Integer.parseInt(data[0]);
        int numberCompanies = Integer.parseInt(data[1]);

        String[] companies = new String[numberCompanies];
        for (int i = 0; i < numberCompanies; i++) {
            companies[i] = scanner.nextLine();
        }
        Fourth fourth = new Fourth();

        for (int i = 0; i < treeSize; i++) {
            String[] dataTop = scanner.nextLine().split(" ");
            TopTree top = new TopTree(i, Long.parseLong(dataTop[1]), dataTop[2]);
            fourth.listTop.add(top);
            if (Integer.parseInt(dataTop[0]) != 0) {
                TopTree parents = fourth.listTop.get(Integer.parseInt(dataTop[0]) - 1);
                parents.subTreeTop.add(i);
                parents.subTreeNames.add(dataTop[2]);
            }
        }

        fourth.getCostSubTree(0);

        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < fourth.listTop.size(); i++) {
            boolean flag = true;
            for (String company : companies) {
                if (!fourth.listTop.get(i).subTreeNames.contains(company)) {
                    flag = false;
                    break;
                }
            }
            if (flag && fourth.listTop.get(i).sumCost < minCost) {
                minCost = fourth.listTop.get(i).sumCost;
            }
        }
        System.out.println(minCost);
    }

    public long getCostSubTree(int subTop) {
        TopTree topTree = listTop.get(subTop);
        long sumCost = topTree.sumCost;
        if (topTree.subTreeTop.isEmpty()) {
            return sumCost;
        } else {
            for (int top : topTree.subTreeTop) {
                sumCost += getCostSubTree(top);
            }
        }
        topTree.sumCost = sumCost;
        return sumCost;
    }

    static class TopTree {
        int numberTop;
        long costTop;
        long sumCost;
        String name;
        HashSet<String> subTreeNames = new HashSet<>();
        HashSet<Integer> subTreeTop = new HashSet<>();

        public TopTree(int numberTop, long costTop, String name) {
            this.numberTop = numberTop;
            this.costTop = costTop;
            this.name = name;
            this.sumCost = costTop;
            subTreeNames.add(name);
        }
    }
}