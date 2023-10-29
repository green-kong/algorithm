import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int poll = pq.poll();

        int sum = 0;
        while (!pq.isEmpty()) {
            final int e = pq.poll() + poll;
            sum += e;
            pq.offer(e);
            poll = pq.poll();
        }

        System.out.println(sum);
    }
}
