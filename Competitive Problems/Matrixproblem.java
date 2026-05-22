import java.util.Scanner;

public class Matrixproblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] A = new int[3][3];
        int[][] B = new int[3][3];
        int[][] C = new int[3][3];

        System.out.println("Enter elements of Matrix A:");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of Matrix B:");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                B[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        int temp = C[0][0];
        C[0][0] = C[2][2];
        C[2][2] = temp;

        int temp2 = C[0][2];
        C[0][2] = C[2][0];
        C[2][0] = temp2;
        
        System.out.println("Result Matrix:");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}