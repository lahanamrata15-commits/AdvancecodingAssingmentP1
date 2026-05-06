import java.util.*;

public class ArrayTransformation {

    public static int minOperations(int[] A, int K) {
        int n = A.length;

        // Step 1: Check possibility
        for (int i = 1; i < n; i++) {
            if ((A[i] - A[0]) % K != 0) {
                return -1;
            }
        }

        // Step 2: Convert to B array
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = A[i] / K;
        }

        // Step 3: Sort and find median
        Arrays.sort(B);
        int median = B[n / 2];

        // Step 4: Calculate operations
        int operations = 0;
        for (int i = 0; i < n; i++) {
            operations += Math.abs(B[i] - median);
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        int[] A = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int K = sc.nextInt();

        int result = minOperations(A, K);

        System.out.println(result);

        sc.close();
    }
}