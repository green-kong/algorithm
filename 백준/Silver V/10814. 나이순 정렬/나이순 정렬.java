import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final PriorityQueue<Member> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int age = Integer.parseInt(st.nextToken());
            final String name = st.nextToken();
            pq.offer(new Member(i, age, name));
        }

        while (!pq.isEmpty()){
            final Member poll = pq.poll();
            System.out.println(poll.getInfo());
        }
    }

    private static class Member implements Comparable<Member> {
        int i;
        int age;
        String name;

        public Member(final int i, final int age, final String name) {
            this.i = i;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(final Member o) {
            if (this.age == o.age) {
                return this.i - o.i;
            }
            return this.age - o.age;
        }

        public String getInfo() {
            return age + " " + name;
        }
    }
}
