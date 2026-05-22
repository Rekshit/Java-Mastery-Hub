public class MissingNumber3 {
    public static void main(String[] args) {

        int arr[] = {8, 2, 4, 5, 3, 7, 1};
        int n = arr.length + 1;

        int xor1 = 0;   // XOR of 1 to n
        int xor2 = 0;   // XOR of array elements

        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }

        for (int i = 0; i < arr.length; i++) {
            xor2 ^= arr[i];
        }

        int missing = xor1 ^ xor2;

        System.out.println("Missing Number = " + missing);
    }
}