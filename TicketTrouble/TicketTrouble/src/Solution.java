import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private String solve(Integer testId, Scanner scanner) {
        Structure structure = new Structure(scanner.nextInt(), scanner.nextInt());
        structure.setTickets(parseTickets(structure.getFriends(), scanner));

        int[] aux = new int[structure.getGridDimensions()];
        Arrays.fill(aux, 0);

        for (Ticket t : structure.getTickets()) {
            if (t.getRow().equals(t.getColumn())) {
                aux[t.getRow() - 1]++;
            } else {
                aux[t.getRow() - 1]++;
                aux[t.getColumn() - 1]++;
            }
        }

        List<Integer> apparitions = Arrays.stream(aux).boxed().collect(Collectors.toList());

        return buildAnswer(testId, Collections.max(apparitions));
    }

    private TreeSet<Ticket> parseTickets(Integer friends, Scanner scanner) {
        TreeSet<Ticket> tickets = new TreeSet<>();
        for (int i = 0; i < friends; i++) {
            tickets.add(new Ticket(scanner.nextInt(), scanner.nextInt()));
        }
        return tickets;
    }

    private String buildAnswer(Integer testId, Integer solution) {
        return String.format("Case #%d: %s", testId, solution);
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

    private class Structure {
        private Integer friends;
        private Integer gridDimensions;
        private TreeSet<Ticket> tickets;

        public Structure(Integer friends, Integer gridDimensions) {
            this.friends = friends;
            this.gridDimensions = gridDimensions;
        }

        public Integer getFriends() {
            return friends;
        }

        public Integer getGridDimensions() {
            return gridDimensions;
        }

        public TreeSet<Ticket> getTickets() {
            return tickets;
        }

        public void setTickets(TreeSet<Ticket> tickets) {
            this.tickets = tickets;
        }
    }


    private class Ticket implements Comparable<Ticket> {
        private Integer row;
        private Integer column;

        public Ticket(Integer row, Integer column) {
            this.row = row;
            this.column = column;
        }

        public Integer getRow() {
            return row;
        }

        public Integer getColumn() {
            return column;
        }

        @Override
        public int compareTo(Ticket ticket) {
            if (this.row < ticket.getRow()) return -1;
            if (this.row.equals(ticket.getRow()) && this.column < ticket.getColumn()) return -1;
            if (this.row.equals(ticket.getRow()) && this.column.equals(ticket.getColumn())) return 0;
            return 1;
        }
    }
}
