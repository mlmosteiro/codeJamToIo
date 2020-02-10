import java.util.Scanner;

public class Solution {
    private static String BREAK = "\n";

    private String solve(Integer testId, Scanner scanner) {
        Structure structure = new Structure(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        if (structure.getWinners() == (structure.getColumns() * structure.getRows() - 1)) {
            return buildAnswer(testId, "IMPOSSIBLE");
        } else {
            return buildAnswer(testId, "POSSIBLE") +
                    BREAK +
                    buildPossibleSolution(structure);
        }
    }

    private String buildAnswer(Integer testId, String solution) {
        return String.format("Case #%d: %s", testId, solution);
    }

    private String buildPossibleSolution(Structure structure) {
        int noWinners = structure.getColumns() * structure.getRows() - structure.getWinners();
        int processedCells = 0;
        String lastDirection = null;

        String[][] solution = new String[structure.getRows()][structure.getColumns()];

        for (int row = 0; row < structure.getRows(); row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < structure.getColumns() - 1; col++) {
                    processedCells++;
                    lastDirection = checkEastCells(processedCells, noWinners, lastDirection);
                    solution[row][col] = lastDirection;
                }
                processedCells++;
                lastDirection = checkSouthCells(processedCells, noWinners, lastDirection);
                solution[row][structure.getColumns() - 1] = lastDirection;
            } else {
                for (int col = structure.getColumns() - 1; col > 0; col--) {
                    processedCells++;
                    lastDirection = checkWestCells(processedCells, noWinners, lastDirection);
                    solution[row][col] = lastDirection;
                }
                processedCells++;
                lastDirection = checkSouthCells(processedCells, noWinners, lastDirection);
                solution[row][0] = lastDirection;
            }
        }
        return mapSolution(solution);
    }

    private String checkSouthCells(int processedCells, int noWinners, String lastDirection) {
        if (processedCells == noWinners) {
            if (lastDirection == null) return "N";
            return getReverseOf(lastDirection);
        } else {
            return "S";
        }
    }

    private String checkWestCells(int processedCells, int noWinners, String lastDirection) {
        if (processedCells == noWinners) {
            if (lastDirection == null) return "N";
            return getReverseOf(lastDirection);
        } else {
            return "W";
        }
    }

    private String checkEastCells(int processedCells, int noWinners, String lastDirection) {
        if (processedCells == noWinners) {
            if (lastDirection == null) return "N";
            return getReverseOf(lastDirection);
        } else {
            return "E";
        }
    }

    private String getReverseOf(String a) {
        switch (a) {
            case "N":
                return "S";
            case "S":
                return "N";
            case "W":
                return "E";
            case "E":
                return "W";
        }
        return "N";
    }

    private String mapSolution(String[][] solution) {
        StringBuilder builder = new StringBuilder();
        for (String[] r : solution) {
            for (String c : r) {
                builder.append(c);
            }
            builder.append(BREAK);
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        long start = System.currentTimeMillis();
        for (int t = 1; t <= testCases; t++) {
            System.out.println(new Solution().solve(t, scanner));
        }
        long end = System.currentTimeMillis();
        System.err.println(end - start);
    }

    public class Structure {
        private Integer columns;
        private Integer rows;
        private Integer winners;

        public Structure(Integer rows, Integer columns, Integer winners) {
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
