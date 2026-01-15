//importing a scanner tool to incorportate user data
import java.util.Scanner;

public class Exercise06_31 {
public static void main(String[] args) {
    //adds the scanner and calls it scanner
    Scanner scanner = new Scanner(System.in);

    System.out.println("Please enter card number.");
    //converts string to long
    long number = Long.parseLong(scanner.nextLine());

    if (isValid(number)) {
            System.out.println(number + " is valid");
        } else {
            System.out.println(number + " is invalid");
        }
    }
        //code from book
           public static boolean isValid(long number) {
        // Check if number has between 13 and 16 digits
        int size = getSize(number);
        if (size < 13 || size > 16) {
            return false;
        }

        if (!prefixMatched(number, 4) && !prefixMatched(number, 5) && 
            !prefixMatched(number, 37) && !prefixMatched(number, 6)) {
            return false;
        }

          int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return sum % 10 == 0;
    }

    //get answer from step 2
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numStr = number + "";
        
        // Start from second digit from right, move left by 2 each time
        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += getDigit(digit * 2);
        }
        
        return sum;
    }

     public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }

     public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numStr = number + "";
        
        // Start from the rightmove left by 2 each time
        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            sum += Character.getNumericValue(numStr.charAt(i));
        }
        
        return sum;
     }
        public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
        }
         public static int getSize(long d) {
        return (d + "").length();
    }

    public static long getPrefix(long number, int k) {
        if (getSize(number) < k) {
            return number;
        }
        String numStr = number + "";
        return Long.parseLong(numStr.substring(0, k));
    }
}

