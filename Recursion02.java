public class Recursion02 {

    public static int tillingProblem(int n) {

        // base case
        if (n == 0 || n == 1)
            return 1;

        // kaam
        // vertical choice
        int fnm1 = tillingProblem(n - 1);

        // horizontal choice
        int fnm2 = tillingProblem(n - 2);

        int totalWays = fnm1 + fnm2;

        return totalWays;
    }

    public static void removeDup(String str, int idx, StringBuilder newStr, boolean[] map) {

        // base case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        // kaam
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDup(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDup(str, idx + 1, newStr.append(currChar), map);
        }

    }

    public static void main(String[] args) {
        System.out.println(tillingProblem(5));

        String str = "aappnaccollegd";
        removeDup(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
