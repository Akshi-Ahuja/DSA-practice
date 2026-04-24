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

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        activitySelection(start, end);
    }
}
