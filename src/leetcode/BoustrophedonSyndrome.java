package leetcode;

public class BoustrophedonSyndrome {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            int start = (i - 1) * n + 1;
            int end = i * n;

            if (i % 2 == 0) {
                for (int j = end; j >= start; j--) {
                    System.out.print(j + " ");
                }
            } else {
                for (int j = start; j <= end; j++) {
                    System.out.print(j + " ");
                }
            }

            System.out.println();
        }
    }
}
