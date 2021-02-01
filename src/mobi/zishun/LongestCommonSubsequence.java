package mobi.zishun;

import java.util.Arrays;

public class LongestCommonSubsequence {
    private static int[][] longestCommonSubsequence(String wordA, String wordB) {
        int[][] cell = new int[wordA.length()][wordB.length()];

        int count = 1;

        for (int i = 0; i < wordA.length(); i++) {
            for (int j = 0; j < wordB.length(); j++) {
//                cell[i][j] = count;
//                count++;
//                [1, 2, 3, 4]
//                [5, 6, 7, 8]
//                [9, 10, 11, 12]
//                [13, 14, 15, 16]
                if (wordA.charAt(i) == wordB.charAt(j)) {
                    if (i > 0 && j > 0) {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    } else {
                        cell[i][j] = 1;
                    }
                } else {
                    if (i > 0 && j > 0) {
                        cell[i][j] = cell[i - 1][j] >= cell[i][j - 1] ? cell[i - 1][j] : cell[i][j - 1]; //Math.max(cell[i - 1][j], cell[i][j - 1]);
                    } else if (i > 0 && j == 0) {
                        cell[i][j] = cell[i - 1][j];
                    } else if (i == 0 && j > 0) {
                        cell[i][j] = cell[i][j - 1];
                    } else {
                        cell[i][j] = 0;
                    }
                }
            }
        }

        return cell;
    }

    private static void printCell(int[][] cell) {
        for (int[] row : cell) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int findMax(int[][] cell) {
        int max = 0;
        for (int[] row : cell) {
            for (int i : row) {
                if (i > max) {
                    max = i;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        printCell(longestCommonSubsequence("fish", "fosh"));
        System.out.println("The number of longest Common Subsequence is " + findMax(longestCommonSubsequence("fish", "fosh")));
    }
}
