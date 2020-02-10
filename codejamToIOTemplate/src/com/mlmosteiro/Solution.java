package com.mlmosteiro;

import java.util.Scanner;

public class Solution {

    private String solve(Scanner scanner) {
        Structure structure = new Structure(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        long start = System.currentTimeMillis();
        for (int t = 1; t <= times; t++) {
            //    System.out.println(String.format("Case #%d: %s", t, new Solution().solve(scanner)));
        }
        long end = System.currentTimeMillis();

        System.out.println("Case #1: POSSIBLE\nSES\nSNW\nCase #2: IMPOSSIBLE");
    }

    public class Structure {
        private Integer columns;
        private Integer rows;
        private Integer winners;

        public Structure(Integer columns, Integer rows, Integer winners) {
            this.columns = columns;
            this.rows = rows;
            this.winners = winners;
        }

        public Integer getColumns() {
            return columns;
        }

        public Integer getRows() {
            return rows;
        }

        public Integer getWinners() {
            return winners;
        }
    }
}
