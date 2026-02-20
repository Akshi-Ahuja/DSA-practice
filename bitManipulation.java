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

    public static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void countBits(int n) {
        int ans[] = new int[n + 1];

        for (int i = 0; i < ans.length; i++) {
            int count = 0;
            int x = i;
            while (x > 0) {
                if ((x & 1) != 0)
                    count++;
                x = x >> 1;
            }
            ans[i] = count;
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }

        return ans;
    }

    public static int xRaisedToX(int x) {
        int ans = 1;
        int n = x;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * x;
            }
            x = x * x;
            n = n >> 1;
        }

        return ans;
    }

    public static void swapWThirdValue(int a, int b) {
        System.out.println("Original values: ");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // swap with xor
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("Swaped values values: ");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void toLowerCase() {
        for (int ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' ') + " ");
        }
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

        System.out.println(isPowerOf2(8));
        System.out.println(isPowerOf2(15));

        System.out.println(countSetBits(10));
        System.out.println(countSetBits(15));
        System.out.println(countSetBits(16));

        countBits(5);
        System.out.println();
        System.out.println(fastExpo(3, 5));
        System.out.println(fastExpo(2, 10));

        System.out.println("Square of number itself is: " + xRaisedToX(4));

        swapWThirdValue(2, 45);

        int x = 3;
        System.out.println(x + " + " + 1 + " = " + -~x);

        toLowerCase();
    }
}
