import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final int[] inputs = new int[n];
        final int[] answer = new int[n];
        final Deque<Integer> st = new ArrayDeque<>();

        final StringTokenizer stkn = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(stkn.nextToken());
        }

        for (int i = 0; i < inputs.length; i++) {
            if (st.isEmpty()) {
                st.add(i);
                continue;
            }

            while (inputs[st.peekLast()] < inputs[i]) {
                final int idx = st.removeLast();
                answer[idx] = inputs[i];
                if (st.isEmpty()) {
                    break;
                }
            }

            st.addLast(i);
        }

        while (!st.isEmpty()) {
            final int idx = st.removeLast();
            answer[idx] = -1;
        }

        System.out.println(Arrays.stream(answer)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
