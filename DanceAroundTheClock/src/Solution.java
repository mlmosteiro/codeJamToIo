import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private String solve(Integer testId, Scanner scanner) {
        int totalDancers = scanner.nextInt();
        int dancerId = scanner.nextInt();
        int turns = scanner.nextInt();

        if (dancerId % 2 == 0) {
            return buildAnswer(testId, getEvenDancerNeighbours(dancerId, totalDancers, turns));
        }
        return buildAnswer(testId, getOddDancerNeighbours(dancerId, totalDancers, turns));
    }

    private List<Integer> getOddDancerNeighbours(int dancerId, int totalDancers, int turns) {
        Integer right = (((dancerId - 2) + (2 * turns)) % totalDancers) + 1;
        Integer left = ((dancerId + (2 * turns)) % totalDancers) + 1;

        return new ArrayList<>(Arrays.asList(left, right));
    }

    // THIS IS WRONG ....
    private List<Integer> getEvenDancerNeighbours(int dancerId, int totalDancers, int turns) {
        Integer right = (((dancerId - 1) + (2 * turns)) % totalDancers);
        Integer left = (((dancerId + 2) + (2 * turns)) % totalDancers);

        return new ArrayList<>(Arrays.asList(left, right));
    }

    private String buildAnswer(Integer testId, List<Integer> solution) {
        return String.format("Case #%d: %s ", testId, mapSolution(solution));
    }

    private String mapSolution(List<Integer> solution) {
        StringBuilder builder = new StringBuilder();
        for (Integer i : solution) {
            builder.append(i);
            String SPACE = " ";
            builder.append(SPACE);
        }
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            System.out.println(new Solution().solve(t, scanner));
        }
    }
}