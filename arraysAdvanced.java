public class arraysAdvanced {

    public static int maxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = 0; j < arr.length; j++) {
                int end = j;
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += arr[k];
                }
                System.out.print(sum);
                System.out.println();
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static int prefixArrayMaxSum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        int prefixArray[] = new int[arr.length];
        prefixArray[0] = arr[0];

        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = start == 0 ? prefixArray[end] : prefixArray[end] - prefixArray[start - 1];
            }
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static int kadanes(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i : arr) {
            currSum += i;
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void trappedRainwater(int heights[]) {
        int n = heights.length;

        // calculate left max
        int leftMax[] = new int[n];
        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(heights[i], leftMax[i - 1]);
        }

        // calculate right max
        int rightMax[] = new int[n];
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(heights[i], rightMax[i + 1]);
        }

        // calculate waterlevel and trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            // water level
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - heights[i];
        }

        System.out.println("Trapped rain water for the given heights is: " + trappedWater);
    }

    public static int maxProfitFromBuyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i : prices) {
            if (buyPrice < i) {
                int profit = i - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = i;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 0, 6, 3, 2, 5, 11 };
        // System.out.println("Maximum sum from all the subArrays is: " +
        // maxSubArray(arr));
        // System.out.println("Max Sub Array sum through Prefix Array approach is: " +
        // prefixArrayMaxSum(arr));

        // System.out.println("Max sub array sum through kadanes algorithm is: " +
        // kadanes(arr));

        // trappedRainwater(arr);

        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Best Profit to earn from the given prices is: " + maxProfitFromBuyAndSellStocks(prices));
    }
}
