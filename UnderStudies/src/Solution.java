import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private String solve(Integer testId, Scanner scanner) {
        Integer roles = scanner.nextInt();

        ArrayList<Double> probabilities = (ArrayList<Double>) parseProbabilities(roles, scanner);
        double successProb = 1.0;
        int extLef = 0;
        int extRight = probabilities.size() - 1;

        while (extLef < extRight) {
            successProb *= (1 - (probabilities.get(extLef) * probabilities.get(extRight)));
            extLef++;
            extRight--;
        }

        return buildAnswer(testId, successProb);
    }

    private List<Double> parseProbabilities(Integer roles, Scanner scanner) {
        ArrayList<Double> probabilities = new ArrayList<>();
        Integer totalRoles = roles * 2;
        for (int i = 0; i < totalRoles; i++) {
            probabilities.add(scanner.nextDouble());
        }
        Collections.sort(probabilities);

        return probabilities;
    }

    private String buildAnswer(Integer testId, Double solution) {
        return String.format(Locale.US, "Case #%d: %.6f", testId, solution);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int testCases = scanner.nextInt();
        long start = System.currentTimeMillis();
        for (int t = 1; t <= testCases; t++) {
            System.out.println(new Solution().solve(t, scanner));
        }
        long end = System.currentTimeMillis();
        System.err.println(end - start);
    }

}
