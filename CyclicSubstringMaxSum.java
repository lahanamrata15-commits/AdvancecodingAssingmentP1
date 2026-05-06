import java.util.*;

public class CyclicSubstringMaxSum {

    public static int maxCyclicSubstringSum(String s) {
        int n = s.length();
        String doubled = s + s;

        HashSet<Character> set = new HashSet<>();
        int left = 0, sum = 0, maxSum = 0;

        for (int right = 0; right < 2 * n; right++) {
            char ch = doubled.charAt(right);

            while (set.contains(ch) || (right - left + 1) > n) {
                char leftChar = doubled.charAt(left);
                set.remove(leftChar);
                sum -= (leftChar - 'a' + 1);
                left++;
            }

            set.add(ch);
            sum += (ch - 'a' + 1);

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        int result = maxCyclicSubstringSum(s);
        System.out.println("Maximum Sum: " + result);

        sc.close();
    }
}