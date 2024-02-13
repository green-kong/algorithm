import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] s = br.readLine().split(" ");
        final int l = Integer.parseInt(s[0]);
        int answer = 0;

        final LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            dq.add(i + 1);
        }

        final String[] targets = br.readLine().split(" ");
        for (final String target : targets) {
            final int targetIdx = dq.indexOf(Integer.parseInt(target));

            int midIdx;

            if (dq.size() % 2 == 0) {
                midIdx = dq.size() / 2 - 1;
            } else {
                midIdx = dq.size() / 2;
            }

            int count = 0;
            if (targetIdx <= midIdx) {
                count = targetIdx;
                rotate(dq, count);
            } else {
                count = dq.size() - targetIdx;
                rotateRevers(dq, count);
            }
            dq.removeFirst();
            answer += count;
        }

        System.out.println(answer);
    }

    public static void rotate(final LinkedList<Integer> list, final int count) {
        for (int i = 0; i < count; i++) {
            list.addLast(list.removeFirst());
        }
    }

    public static void rotateRevers(final LinkedList<Integer> list, final int count) {
        for (int i = 0; i < count; i++) {
            list.addFirst(list.removeLast());
        }
    }
}
