public class WaterTrapping3 {
    public static void main(String[] args) {

        int arr[] = {3, 0, 1, 0, 4, 0, 2};
        int n = arr.length;

        int left = 0;
        int right = n - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while (left <= right) {

            if (arr[left] <= arr[right]) {

                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    totalWater += leftMax - arr[left];
                }
                left++;

            } else {

                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    totalWater += rightMax - arr[right];
                }
                right--;
            }
        }

        System.out.println("Total Water Trapped = " + totalWater);
    }
}