public class MissingNumber2 {
    public static void main(String[] args) {

        int arr[] = {8, 2, 4, 5, 3, 7, 1};
        int n = arr.length + 1;

        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;

        for (int i = 0; i < arr.length; i++) {
            arraySum += arr[i];
        }

        int missing = totalSum - arraySum;

        System.out.println("Missing Number = " + missing);
    }
}