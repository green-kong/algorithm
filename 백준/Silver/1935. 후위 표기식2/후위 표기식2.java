import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final String s = br.readLine();
        final Deque<Double> dq = new ArrayDeque<>();

        final int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);

            if ('A' <= c && c <= 'Z') {
                double d = ints[c - 'A'];
                dq.addLast(d);
                continue;
            }

            final double first = dq.removeLast();
            final double second = dq.removeLast();

            if (c == '*') {
                dq.addLast(second * first);
                continue;
            }

            if (c == '+') {
                dq.addLast(second + first);
                continue;
            }
            if (c == '/') {
                dq.addLast(second / first);
                continue;
            }
            if (c == '-') {
                dq.addLast(second - first);
            }
        }

        System.out.printf("%.2f", dq.removeLast());
    }
}
