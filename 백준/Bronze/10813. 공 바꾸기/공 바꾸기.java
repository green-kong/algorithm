import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] s = br.readLine().split(" ");
        final int n = Integer.parseInt(s[0]);
        final int m = Integer.parseInt(s[1]);

        int[] basket = new int[n + 1];
        for (int i = 0; i < basket.length; i++) {
            basket[i] = i;
        }

        for (int i = 0; i < m; i++) {
            final String[] s1 = br.readLine().split(" ");
            final int a = Integer.parseInt(s1[0]);
            final int b = Integer.parseInt(s1[1]);

            final int tmp = basket[a];
            basket[a] = basket[b];
            basket[b] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(basket[i]);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
