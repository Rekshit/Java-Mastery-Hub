public class WaterTrapping1 {
    public static void main(String[] args) {

        int arr[] = {3, 0, 1, 0, 4, 0, 2};
        int n = arr.length;
        int totalWater = 0;

        for (int i = 0; i < n; i++) {

            int leftMax = arr[i];
            for (int j = 0; j <= i; j++) {
                if (arr[j] > leftMax) {
                    leftMax = arr[j];
                }
            }

            int rightMax = arr[i];
            for (int j = i; j < n; j++) {
                if (arr[j] > rightMax) {
                    rightMax = arr[j];
                }
            }

            int water = Math.min(leftMax, rightMax) - arr[i];
            totalWater += water;
        }

        System.out.println("Total Water Trapped = " + totalWater);
    }
}