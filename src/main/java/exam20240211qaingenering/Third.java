/*
   В первой строке задается количество подарков и максимальная сумма кредита
   во второй стоимости подарков

   нужно взять сумму кредита, с которой останеться максимальная сумма при покупке подарков последовательно согласно списка
*/

package exam20240211qaingenering;

import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int numberGifts = Integer.parseInt(data[0]);
        int maxMoney = Integer.parseInt(data[1]);
        String[] priceGifts = scanner.nextLine().split(" ");
        int high = maxMoney;
        int low = maxMoney;
        for (int i = 0; i < numberGifts; i++) {
            int priceGift = Integer.parseInt(priceGifts[i]);

            if (priceGift < high) {
                high = high - priceGift;
                if (low >= priceGift) {
                    low = priceGift - 1;
                }
            } else {
                if (priceGift == high) {
                    high = priceGift - 1;
                }
                if (low >= priceGift) {
                    low = low - priceGift;
                }
            }
        }
        System.out.println(Math.max(high, low));
    }
}