// Name: Owen Banton

import java.util.Scanner;

public class EmailValidation {

    public static void main(String[] args) {

        // Print email prompt and receive input through scanner class. Print whether input is valid.

        Scanner input = new Scanner(System.in);
        System.out.print("Email: ");
        String email = input.nextLine();
        if (isValidEmail(email)) {
            System.out.println("\nEmail is valid.");}
        else System.out.println("\nEmail is not valid.");
        }





    // Methods to determine if character fits desired criteria based on ASCII value.

    public static boolean isAlphanumeric(char a) {

        boolean alphaCheck = ((a >= 48 && a <= 57) || (a >= 65 && a <= 90) || (a >= 97 && a <= 122));
        return alphaCheck;
    }

    public static boolean isValidPrefixChar(char b) {

        boolean prefixCheck = ((b >= 48 && b <= 57) || (b >= 65 && b <= 90) || (b >= 97 && b <= 122)
                || (b == 45) || (b == 46) || (b == 95));
        return prefixCheck;
    }

    public static boolean isValidDomainChar(char c) {

        boolean domainCheck = ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)
                || (c == 45) || (c == 46));
        return domainCheck;
    }

    // Method to count number of @ symbols in a string, returning false if the number isn't 1.

    public static boolean exactlyOneAt(String d) {

        int numberAts = 0;

        for (int i = 0; i < d.length(); i++) {
            if (d.charAt(i) == 64) {
                numberAts++;
            }
        }
        boolean h = (numberAts == 1);

        return h;
    }

    // Method to construct a string of the characters until an @ symbol is reached.

    public static String getPrefix(String e) {

        StringBuilder prefixBuilder = new StringBuilder("");

        for (int i = 0; i < e.length(); i++) {
            if (e.charAt(i) != 64) {
                prefixBuilder.append(e.charAt(i));
            } else break;


        }

        return prefixBuilder.toString();
    }

    // Similar to above, but creates string after the @ symbol to retrieve the domain.

    public static String getDomain(String f) {

        StringBuilder domainBuilder = new StringBuilder("");

        for (int i = 0; i < f.length(); i++) {
            if (f.charAt(i) == 64) {
                for (int j = i + 1; j < f.length(); j++) {
                    domainBuilder.append(f.charAt(j));

                }
            }
        }

        return domainBuilder.toString();
    }

    /* Method to cycle through each character of the prefix to make sure it adheres to criteria established in
    earlier method. */

    public static boolean prefixOnlyValidChars(String g) {

        int validChars = 0;

        for (int i = 0; i < g.length(); i++) {
            if (isValidPrefixChar(g.charAt(i))) {
                validChars++;

            }
        }
        if (validChars == g.length()) {
            return true;
        } else {
            return false;
        }

    }

    /* Method to ensure -, ., and _ symbols are followed by an alphanumeric character. If it is the last character
    of the string, or followed by another unauthorized symbol, the counter will be incremented, returning false. */

    public static boolean prefixValidFollowChar(String h) {

        int invalidFollows = 0;

        for (int i = 0; i < h.length(); i++) {
            if ((h.charAt(i) == 45) || (h.charAt(i) == 46) || (h.charAt(i) == 95)) {
                if ((h.charAt(i) == (h.charAt(h.length() - 1))))
                    invalidFollows++;
                else if (!isAlphanumeric(h.charAt(i + 1))) {
                    invalidFollows++;
                }
            }

        }
        boolean b = (invalidFollows == 0);
        return b;
    }

    // Method to check first and last characters of the string.

    public static boolean alphaFirstAndLast(String i) {

        boolean a = isAlphanumeric(i.charAt(0));
        boolean b = isAlphanumeric(i.charAt(i.length() - 1));
        boolean c = a && b;
        return c;
    }

    // Compiling all of the prefix constraints into one boolean method for the prefix.

    public static boolean isValidPrefix(String j) {

        boolean a = (j.length() >= 1);
        boolean b = prefixOnlyValidChars(j);
        boolean c = prefixValidFollowChar(j);
        boolean d = alphaFirstAndLast(j);
        boolean e = (a && b && c && d);
        return e;

    }
    /* Method to extract the first part of the domain. Starts from the end and loops back to account for
    instances of multiple periods. */

    public static String getDomainStart(String k) {

        StringBuilder domainSplitterOne = new StringBuilder("");

        for (int i = k.length() - 1; i > 0; i--) {
            if (k.charAt(i) == 46) {
                for (int j = i; j > 0; j--) {

                }domainSplitterOne.append(k.charAt(i));
            }


        }

        return domainSplitterOne.reverse().toString();
    }

    // Similar to above, but appends characters until a period symbol to retrieve latter portion of domain.

    public static String getDomainEnd(String l) {

        StringBuilder domainSplitterTwo = new StringBuilder("");

        for (int i = l.length() - 1; i > 0; i--) {
            if (l.charAt(i) != 46) {
                domainSplitterTwo.append(l.charAt(i));
            } else break;

        }
        return domainSplitterTwo.reverse().toString();
    }

    // Same function as with @ symbols, but for one or more periods.

    public static boolean atLeastOnePeriod(String m) {

        int numberPeriods = 0;

        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) == 46) {
                numberPeriods++;
            }
        }
        boolean h = (numberPeriods >= 1);

        return h;
    }

    // Same as the method to check prefix characters, but with the domain method.

    public static boolean domainOnlyValidChars(String n) {

        int validChars = 0;

        for (int i = 0; i < n.length(); i++) {
            if (isValidDomainChar(n.charAt(i))) {
                validChars++;

            }
        }
        if (validChars == n.length()) {
            return true;
        } else {
            return false;
        }

    }

    // Same function as earlier for the prefix section, modified for domain criteria.

    public static boolean domainValidFollowChar(String o) {

        int invalidFollows = 0;

        for (int i = 0; i < o.length(); i++) {
            if ((o.charAt(i) == 45) || (o.charAt(i) == 46)) {
                if ((o.charAt(i) == (o.charAt(o.length() - 1))))
                    invalidFollows++;
                else if (!isAlphanumeric(o.charAt(i + 1))) {
                    invalidFollows++;
                }
            }

        }
        boolean b = (invalidFollows == 0);
        return b;
    }

    // Method to determine if a character is alphabetic, followed by one to apply the check to a string.

    public static boolean isAlphabetic(char p) {

        boolean alphaCheck = ((p >= 65 && p <= 90) || (p >= 97 && p <= 122));
        return alphaCheck;
    }

    public static boolean onlyAlphabetic(String q) {

        int validChars = 0;

        for (int i = 0; i < q.length(); i++) {
            if (isAlphabetic(q.charAt(i))) {
                validChars++;

            }
        }
        if (validChars == q.length()) {
            return true;
        } else {
            return false;
        }

    }

    // Compiling all the domain criteria into one boolean check, followed by the final check for email validity.

    public static boolean isValidDomain(String r) {

        boolean a = atLeastOnePeriod(r);
        boolean b = (getDomainStart(r).length() >= 1);
        boolean c = (getDomainEnd(r).length() >= 2);
        boolean d = (domainOnlyValidChars(getDomainStart(r)));
        boolean e = (domainValidFollowChar(getDomainStart(r)));
        boolean f = (alphaFirstAndLast(getDomainStart(r)));
        boolean g = (onlyAlphabetic(getDomainEnd(r)));
        boolean h = (a && b && c && d && e && f && g);
        return h;

    }

    public static boolean isValidEmail(String s) {

        boolean a = isValidPrefix(getPrefix(s));
        boolean b = isValidDomain(getDomain(s));
        boolean c = exactlyOneAt(s);
        boolean d = (a && b && c);
        return d;

    }
}