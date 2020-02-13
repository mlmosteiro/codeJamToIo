import java.util.*;

public class Solution {

    private String solve(Integer testId, Scanner scanner) {
        int items = scanner.nextInt();
        ArrayList<Integer> optimalDistances = parseOptimalDistance(items, scanner);
        Collections.sort(optimalDistances);

        if (items % 2 != 0) {
            return buildAnswer(testId, getOddAnswer(optimalDistances));
        }
        return buildAnswer(testId, getEvenAnswer(optimalDistances));
    }

    private Integer getEvenAnswer(ArrayList<Integer> optimalDistances) {
        Integer actualDistance = 0;
        Double solution = 0.0;

        for (int i = 0; i < optimalDistances.size(); i += 2) {
            solution += (Math.pow(optimalDistances.get(i) - actualDistance, 2) +
                    Math.pow(optimalDistances.get(i + 1) - actualDistance, 2));
            actualDistance++;
        }
        return solution.intValue();
    }

    private Integer getOddAnswer(ArrayList<Integer> optimalDistances) {
        Integer actualDistance = 0;
        Double solution = 0.0;
        int i;

        for (i = 0; i < optimalDistances.size() - 1; i += 2) {
            solution += (Math.pow(optimalDistances.get(i) - actualDistance, 2) +
                    Math.pow(optimalDistances.get(i + 1) - actualDistance, 2));
            actualDistance++;
        }
        solution += Math.pow(optimalDistances.get(i) - actualDistance, 2);

        return solution.intValue();
    }

    private ArrayList<Integer> parseOptimalDistance(Integer totalIngredients, Scanner scanner) {
        ArrayList<Integer> optimalDistance = new ArrayList<>();
        for (int i = 0; i < totalIngredients; i++) {
            optimalDistance.add(scanner.nextInt());
        }
        return optimalDistance;
    }

    private String buildAnswer(Integer testId, Integer solution) {
        return String.format("Case #%d: %d ", testId, solution);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            System.out.println(new Solution().solve(t, scanner));
        }
    }
}