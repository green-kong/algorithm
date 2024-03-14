import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        if (N == 1) {
            result = 1;
        } else if (N == 2) {
            result = Math.min((M + 1) / 2, 4);
        } else if (N >= 3) {
            if (M < 7) {
                result = Math.min(M, 4);
            } else {
                result = M - 2;
            }
        }
        System.out.println(result);
    }
}
