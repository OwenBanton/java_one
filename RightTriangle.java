// Name: Owen Banton
public class RightTriangle {

    public static void main(String[] args) {

        // Set up command line argument input for size of the triangle.

        int size = Integer.parseInt(args[0]);

        /* Creating condition to exclude negative numbers, store triangle program in a method to consolidate space
        in main method. */

        if (size < 0)
            System.out.println("Error: input value must be >= 0");
        else
            triangleBuilderTwo(size);

    }

    public static void triangleBuilderTwo(int size) {

        /* Nested loop where outer loop determines number of rows, inner loops print contents of each column.
        Number of rows determined directly through input value, so a <= size. One inner loop prints decreasing number
        of spaces to push asterisks towards the right, second inner loop prints increasing number of asterisks. */

        for (int a = 1; a <= size; a++) {

        /* Required number of spaces corresponds inversely to the number of rows, so the condition b <= size
        causes the loop to print one less space each time it increments towards the input size. */

            for (int b = a; b <= size; b++)
                System.out.print(" ");

        /* Number of asterisks increase by setting b = 1 with <= a as the condition, as it's starting point will
        be one less each loop, allowing more space for asterisks on each subsequent row. */

            for (int b = 1; b <= a; b++)
                System.out.print("*");

            // Empty println function placed at the end of the outer loop to move to the next row.

            System.out.println();
        }

    }
}
