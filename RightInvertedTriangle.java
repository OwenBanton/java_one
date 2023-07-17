// Name: Owen Banton

public class RightInvertedTriangle {

    public static void main(String[] args) {

        // Set up command line argument input for size of the triangle.

        int size = Integer.parseInt(args[0]);

        /* Creating condition to exclude negative numbers, store triangle program in a method to consolidate space
        in main method. */

        if (size < 0)
            System.out.println("Error: input value must be >= 0");
        else
            triangleBuilder(size);

    }

    public static void triangleBuilder(int size) {

        /* Nested loop where outer loop determines number of rows, inner loops print contents of each column.
        Number of rows determined directly through input value, so a <= size. One inner loop prints increasing number
        of spaces to push asterisks towards the right, second inner loop prints decreasing number of asterisks. */

        for (int a = 1; a <= size; a++) {

        // Required number of spaces corresponds to number of rows, so b <= a is the condition here.

           for (int b = 1; b <= a; b++)
                System.out.print(" ");

        /* Number of asterisks decrease by setting b = a with the size as the condition, as it's starting point will
        be one greater each row. */

           for (int b = a; b <= size; b++)
                System.out.print("*");

        // Empty println function placed at the end of the outer loop to move to the next row.

           System.out.println();
        }

    }
}