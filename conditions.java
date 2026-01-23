import java.util.*;

public class conditions {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Question 1....");
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if (num >= 0) {
            System.out.println("Number is positive!");
        } else {
            System.out.println("Number is negative");
        }

        System.out.println();
        System.out.println("Question 2....");

        System.out.println();

        double temp = 103.5;
        if (temp > 100) {
            System.out.println("you have fever! Contact a doctor!");
        } else {
            System.out.println("You are alright, no fever!");
        }

        System.out.println();

        System.out.println("Question 03....");

        System.out.println();

        System.out.println("Enter the day of the week from 1-7");
        int weekDay = sc.nextInt();

        switch (weekDay % 7) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }

        System.out.println();
        System.out.println("Question 4....");

        int a = 63,
                b = 36;
        boolean x = (a < b) ? true : false;
        int y = (a > b) ? a : b;

        System.out.println(x + " , " + y);

        System.out.println();
        System.out.println("Question 5....");

        System.out.println("Enter a year: ");
        int year = sc.nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("Leap Year!");
                } else {
                    System.out.println("Not a leap year");
                }
            } else {
                System.out.println("Not a Leap Year!");
            }
        } else {
            System.out.println("Not a leap year!");
        }
    }
}
