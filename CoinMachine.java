public class CoinMachine {

    public static void main(String[] args) {

        /*
        Name: Owen Banton
        */

        // Configure command line arguments for amount and cost inputs.

        int amount = Integer.parseInt(args[0]);
        int cost = Integer.parseInt(args[1]);

        // Subtract cost from amount to receive change amount.

        int changeAmountOriginal = amount - cost;

        // Divide change amount by 200 to determine amount of toonies.

        int t = changeAmountOriginal / 200;

        // Remainder of change amount divided by 200 to determine amount of change left to distribute.

        int changeAmount = changeAmountOriginal % 200;

        // Repeat last two steps for each of the smaller denominations.

        int l = changeAmount / 100;
        changeAmount = changeAmount % 100;

        int q = changeAmount / 25;
        changeAmount = changeAmount % 25;

        int d = changeAmount / 10;
        changeAmount = changeAmount % 10;

        int n = changeAmount / 5;

        // Print input data, amount of change, and distribution of coins.

        System.out.println();
        System.out.println("Amount received: " + amount);
        System.out.println("Cost of the item: " + cost);

        System.out.println("Required change: " + changeAmountOriginal);
        System.out.println();

        System.out.println("Change:");
        System.out.println("    toonies x " + t);
        System.out.println("    loonies x " + l);
        System.out.println("    quarters x " + q);
        System.out.println("    dimes x " + d);
        System.out.println("    nickels x " + n);

    }
}
