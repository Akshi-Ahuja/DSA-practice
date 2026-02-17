public class Strings {

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }

        return true;
    }

    public static float shortestPath(String s) {
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'N') {
                y++;
            } else if (s.charAt(i) == 'S') {
                y--;
            } else if (s.charAt(i) == 'E') {
                x++;
            } else {
                x--;
            }
        }

        int sPath = 0;
        int x2 = x * x;
        int y2 = y * y;

        sPath = sPath + x2 + y2;
        return (float) Math.sqrt(sPath);

    }

    public static String largestStringLexi(String str[]) {
        String largest = str[0];
        for (int i = 1; i < str.length; i++) {
            if (largest.compareToIgnoreCase(str[i]) < 0) {
                largest = str[i];
            }
        }

        return largest;
    }

    public static String toUpperCase(String s) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && i < s.length() - 1) {
                sb.append(s.charAt(i));
                i++;
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "noon";
        System.out.println(isPalindrome(str));

        String path = "WNEENESENNN";
        System.out.println("Shortest path from origin to the point is: "
                + shortestPath(path));

        String strings[] = { "akshi", "krish", "jia" };
        System.out.println("Largest string is: " + largestStringLexi(strings));

        String newString = "my NAME is akshi aHUJA";
        System.out.println(toUpperCase(newString));
    }
}
