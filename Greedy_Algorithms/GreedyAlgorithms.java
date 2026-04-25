import java.util.*;

public class GreedyAlgorithms {

    public static void activitySelection(int start[], int end[]) {
        // sorting
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda fn - short form of a fn
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // end time sorting
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity select
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEndTime = activities[0][2];

        // check for others
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] > lastEndTime) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEndTime = activities[i][2];
            }
        }

        System.out.println("Activities selected: " + maxAct);
        System.out.print("Activities: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void knacksack(int val[], int weight[], int W) {
        double ratio[][] = new double[val.length][2];
        // 0th -> original idx, 1 -> ratio of v/w;
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // Ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalValue = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finalValue += val[idx];
                capacity -= weight[idx];
            } else {
                finalValue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Final Value: " + finalValue);
    }

    public static void minAbsDifSum(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);

        int minDiff = 0;
        for (int i = 0; i < a.length; i++) {
            minDiff += (Math.abs((a[i] - b[i])));
        }
        System.out.println("Min Absolute Difference for pairs: " + minDiff);
    }

    public static void maxLenChain(int pairs[][]) {
        // sorting
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // add 1st pair
        int chainLen = 1;
        int chainEnd = pairs[0][1]; // Last selected pair end // chain end

        // check for other pairs
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Max Chain Length: " + chainLen);

    }

    public static void indianCoins(int amount, Integer coins[]) {
        Arrays.sort(coins, Comparator.reverseOrder());

        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Total min coins used: " + count);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void jobSequencing(int jobsInfo[][]) {
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit); // descending sorting

        ArrayList<Integer> ans = new ArrayList<>();
        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                ans.add(curr.id);
                time++;
            }
        }

        System.out.println("Max jobs: " + ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static void chocolaProblem(Integer costV[], Integer costH[]) {
        Arrays.sort(costV, Collections.reverseOrder());
        Arrays.sort(costH, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costH.length && v < costV.length) {
            if (costV[v] <= costH[h]) { // horizontal cut
                cost += (costH[h] * vp);
                hp++;
                h++;
            } else { // vertical cut
                cost += (costV[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < costH.length) {
            cost += (costH[h] * vp);
            hp++;
            h++;
        }

        while (v < costV.length) {
            cost += (costV[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Cost: " + cost);
    }

    public static void main(String[] args) {
        // Activity Selection
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        activitySelection(start, end);

        // Fraction Knacksack
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;
        knacksack(val, weight, W);

        // Minimum Absolute Difference Pairs
        int A[] = { 4, 1, 8, 7 }; // { 1, 2, 3 };
        int B[] = { 2, 3, 6, 5 }; // { 2, 1, 3 };
        minAbsDifSum(A, B);

        // Max Length - Chain of Pairs (Like Acitivity Selection)
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        maxLenChain(pairs);

        // Indian Coins
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        indianCoins(1093, coins);

        // Job sequencing
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        jobSequencing(jobsInfo);
        System.out.println();

        // Chocola Problem
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };
        chocolaProblem(costVer, costHor);
    }
}
