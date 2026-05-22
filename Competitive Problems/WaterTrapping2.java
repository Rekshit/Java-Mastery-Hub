public class WaterTrapping2 {
    public static void main(String[] args) {

        int arr[] = {3, 0, 1, 0, 4, 0, 2};
        int n = arr.length;

        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        int totalWater = 0;

        // Fill leftMax array
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        System.out.println("Total Water Trapped = " + totalWater);
    }
}