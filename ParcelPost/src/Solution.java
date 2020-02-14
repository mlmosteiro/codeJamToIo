import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {


    private String solve(Integer testId, Scanner scanner) {
        int length = scanner.nextInt();
        ArrayList<Integer> elevations = parseElevations(length, scanner);
        return buildAnswer(testId, recursiveCheckDesirableZones(elevations) - 1);
    }

    private int recursiveCheckDesirableZones(List<Integer> elevations) {
        Integer markA = 0;
        Integer markB = markA + 1;
        Integer markC = markB + 1;

        while (markC < elevations.size()) {
            if (existVariation(elevations, markA, markB, markC)) {
                List<Integer> aux = elevations.subList(markC, elevations.size());
                return 1 + recursiveCheckDesirableZones(aux);
            } else {
                markB++;
                markC++;
            }
        }
        return 0;
    }

    private boolean existVariation(List<Integer> elevations, Integer markA, Integer markB, Integer markC) {
        return ((elevations.get(markA) - elevations.get(markB)) *
                (elevations.get(markC) - elevations.get(markB)) > 0);
    }

    private ArrayList<Integer> parseElevations(Integer length, Scanner scanner) {
        ArrayList<Integer> optimalDistance = new ArrayList<>();
        for (int i = 0; i < length + 1; i++) {
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