public class OOPS {

}

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

class Student {
    String name;
    int age;
    double percentage;

    void calcPercentage(int phy, int chm, int maths) {
        percentage = (double) (phy + chm + maths) / 3;
    }
}
