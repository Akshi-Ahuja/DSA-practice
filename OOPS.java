public class OOPS {
    public static void main(String[] args) {
        Complex c1 = new Complex(1, -2);
        Complex c2 = new Complex(2, -1);
        c1.printComplex();

        (Complex.add(c1, c2)).printComplex();

    }
}

// class BankAccount {
// public String username;
// private String password;

// void setPassword(String pwd) {
// password = pwd;
// }
// }

class Pen {
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

// class Student {
// String name;
// int age;
// double percentage;

// void calcPercentage(int phy, int chm, int maths) {
// percentage = (double) (phy + chm + maths) / 3;
// }
// }

// Assignment Questions:

class Complex {
    int real;
    int imag;

    public Complex(int r, int i) {
        real = r;
        imag = i;
    }

    public static Complex add(Complex a, Complex b) {
        return new Complex((a.real + b.real), (a.imag + b.imag));
    }

    public static Complex diff(Complex a, Complex b) {
        return new Complex((a.real - b.real), (a.imag - b.imag));
    }

    public static Complex multiply(Complex a, Complex b) {
        return new Complex(
                ((a.real * b.real) - (a.imag * b.imag)),
                ((a.real * b.real) + (a.imag * b.imag)));
    }

    public void printComplex() {
        if (real == 0 && imag != 0) {
            System.out.println(imag + "i");
        } else if (imag == 0 && real != 0) {
            System.out.println(real);
        } else {
            System.out.println(real + " + " + imag + "i");
        }
    }
}