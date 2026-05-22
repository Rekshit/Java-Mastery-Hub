public class MissingNumber1 {
    public static void main(String[] args) {

        int arr[] = {8, 2, 4, 5, 3, 7, 1};
        int n = arr.length + 1;   // because one number is missing
        int missing = -1;

        for (int i = 1; i <= n; i++) {

            boolean found = false;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                missing = i;
                break;
            }
        }

        System.out.println("Missing Number = " + missing);
    }
}