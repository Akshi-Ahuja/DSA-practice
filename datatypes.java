import java.util.*;

public class datatypes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int average = ((num1 + num2 + num3) / 3);

        System.out.println("Average of given three numbers is: " + average);

        System.out.println();
        System.out.println("Moving on to question 2");

        System.out.println("Enter side of a square: ");
        int side = sc.nextInt();

        System.out.println("Area of square with side " + side + " is: " + (side * side));
        System.out.println();

        System.out.println("Moving on to question 3...");

        System.out.println("Enter cost for pencil, a pen and an eraser: ");

        float pencil = sc.nextFloat();
        float pen = sc.nextFloat();
        float eraser = sc.nextFloat();

        System.out.println("Total bill without GST: " + (pencil + pen + eraser));

        int total = (int) (pencil + pen + eraser);
        double bill = total + (total * 0.18);

        System.out.println("Total Bill amount with GST: " + bill);
        System.out.println();

        System.out.println("Moving to question 4");

        System.out.println();

        byte b = 4;
        char c = 'a';
        short s = 512;
        int i = 512;
        float f = 3.14f;
        double d = 99.9954;

        double result = (f * b) + (i % c) - (d * s);

        System.out.println(result);

        System.out.println();

        System.out.println("Question 5");

        int $ = 24;

        System.out.println($);

    }
}
