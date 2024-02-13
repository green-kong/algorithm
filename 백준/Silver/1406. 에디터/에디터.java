import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final Deque<String> st = new ArrayDeque<>();
        final Deque<String> st2 = new ArrayDeque<>();

        final String s = br.readLine();
        final String[] split = s.split("");
        for (final String s1 : split) {
            st.addLast(s1);
        }

        final int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            final String[] s1 = br.readLine().split(" ");

            if (s1[0].equals("L")) {
                if (!st.isEmpty()) {
                    st2.addLast(st.removeLast());
                }
            }

            if (s1[0].equals("D")) {
                if (!st2.isEmpty()) {
                    st.addLast(st2.removeLast());
                }
            }

            if (s1[0].equals("B")) {
                if (!st.isEmpty()) {
                    st.removeLast();
                }
            }

            if (s1[0].equals("P")) {
                st.addLast(s1[1]);
            }
        }

        while (!st2.isEmpty()) {
            st.addLast(st2.removeLast());
        }
        System.out.println(String.join("", st));
    }
}
