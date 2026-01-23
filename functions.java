public class functions {

    public static void binaryToDecimal(int num) {
        int ans = 0;
        int count = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            ans += (lastDigit * Math.pow(2, count));
            count++;
            num = num / 10;
        }
        System.out.println("Binary to Decimal Conversion of is: " + ans);
    }

    public static void decimalToBinary(int num) {
        int answer = 0;
        int count = 0;
        while (num > 0) {
            int rem = num % 2;
            answer += ((int) Math.pow(10, count) * rem);
            count++;
            num = num / 2;
        }
        System.out.println("Decimal to Binary Conversion of is: " + answer);

    }

    public static void isPalindrome(int number) {
        int reverse = 0;
        int count = 0;
        int actualNum = number;
        while (number > 0) {
            int lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit;
            count++;
            number = number / 10;
        }
        if (reverse == actualNum) {
            System.out.println("Number is Palindrome!");
        } else {
            System.out.println("Not Palindrome!");
        }
    }

    public static void sumOfDigitsInANumber(int num) {
        int ans = 0;
        while (num > 0) {
            int last = num % 10;
            ans += last;
            num /= 10;
        }
        System.out.println("Sum of digits is: " + ans);
    }

    public static void main(String[] args) {
        // binaryToDecimal(10);
        // decimalToBinary(2);
        // decimalToBinary(3);

        // isPalindrome(2222);
        // isPalindrome(1221);
        // isPalindrome(123);

        sumOfDigitsInANumber(123);
    }
}
