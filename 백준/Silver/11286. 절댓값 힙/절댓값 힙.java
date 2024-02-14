import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        final Queue<Number> pq = new PriorityQueue<>();
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            final int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().origin);
                }
                continue;
            }
            pq.add(Number.from(input));
        }
    }

    static private class Number implements Comparable<Number> {
        private final int abs;
        private final int origin;

        private Number(final int abs, final int origin) {
            this.abs = abs;
            this.origin = origin;
        }

        public static Number from(final int value) {
            return new Number(Math.abs(value), value);
        }

        @Override
        public int compareTo(final Number o) {
            if (this.abs == o.abs) {
                return this.origin - o.origin;
            }
            return this.abs - o.abs;
        }
    }

}
