import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
// (()[[]])([])
// ‘()’ 인 괄호열의 값은 2이다.
// ‘[]’ 인 괄호열의 값은 3이다.
// ‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
// ‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split("");
        Deque<String> dq = new ArrayDeque<>();

        int answer = 0;
        int cnt = 1;

        for (int i = 0; i < split.length; i++) {
            final String s = split[i];
            if (dq.isEmpty()) {
                if (!s.equals("(") && !s.equals("[")) {
                    System.out.println(0);
                    return;
                }
            }

            if (s.equals("(")) {
                dq.add(s);
                cnt *= 2;
                continue;
            }

            if (s.equals("[")) {
                dq.add(s);
                cnt *= 3;
                continue;
            }

            if (s.equals(")")) {
                if (!dq.peekLast().equals("(")) {
                    System.out.println(0);
                    return;
                }

                if (split[i - 1].equals("(")) {
                    answer += cnt;
                }

                dq.removeLast();
                cnt /= 2;

            }

            if (s.equals("]")) {
                if (!dq.peekLast().equals("[")) {
                    System.out.println(0);
                    return;
                }

                if (split[i - 1].equals("[")) {
                    answer += cnt;
                }

                dq.removeLast();
                cnt /= 3;
            }
        }
        System.out.println(dq.isEmpty() ? answer : 0);
    }

}
