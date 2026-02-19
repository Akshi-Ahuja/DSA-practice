public class bitManipulation {

    public static void oddOrEven(int n) {
        int bitmask = 1;
        if ((n & bitmask) == 1) {
            // odd number
            System.out.println("odd number");
        } else {
            // even number
            System.out.println("even number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitmask = 1 << i;
        if ((n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;
        return n | bitmask;
    }

    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if (newBit == 0) {
        // return clearIthBit(n, i);
        // } else {
        // return setIthBit(n, i);
        // }
        n = clearIthBit(n, i);
        int newBitmask = newBit << i;
        return n | newBitmask;
    }

    public static int clearIBits(int n, int i) {
        int bitmask = (~0) << i;
        return n & bitmask;
    }

    public static int clearRangeOfBits(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = ((1 << i) - 1);
        int bitMask = a | b;
        return n & bitMask;
    }

    public static void main(String[] args) {
        // oddOrEven(3);
        // oddOrEven(26);

        System.out.println(getIthBit(10, 3));
        System.out.println(setIthBit(10, 2));
        System.out.println(clearIthBit(10, 1));

        System.out.println(updateIthBit(10, 2, 1));

        System.out.println(clearIBits(15, 2));

        System.out.println(clearRangeOfBits(2515, 2, 7));
    }
}
