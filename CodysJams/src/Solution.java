import java.util.*;

public class Solution {

    private String solve(Integer testId, Scanner scanner) {
        Integer items = scanner.nextInt();

        ArrayList<Long> prices = parsePrices(items, scanner);
        ArrayList<Long> salePrices = new ArrayList<>();

        Iterator<Long> priceIterator = prices.iterator();
        while (priceIterator.hasNext()) {
            Long aux = priceIterator.next();
            Long normalPrice = aux * 4 / 3;

            if (prices.contains(normalPrice)) {
                salePrices.add(aux);
                prices.remove(aux);
                prices.remove(normalPrice);
                priceIterator = prices.iterator();
            }
        }
        return buildAnswer(testId, mapSolution(salePrices));
    }

    private ArrayList<Long> parsePrices(Integer totalPrices, Scanner scanner) {
        ArrayList<Long> prices = new ArrayList<>();
        int totalRoles = totalPrices * 2;
        for (int i = 0; i < totalRoles; i++) {
            prices.add(scanner.nextLong());
        }
        return prices;
    }


    private String mapSolution(ArrayList<Long> solution) {
        StringBuilder builder = new StringBuilder();
        for (Long i : solution) {
            builder.append(i);
            String SPACE = " ";
            builder.append(SPACE);
        }
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    private String buildAnswer(Integer testId, String solution) {
        return String.format("Case #%d: %s", testId, solution);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            System.out.println(new Solution().solve(t, scanner));
        }
    }
}