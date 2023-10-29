import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] s = br.readLine().split(" ");

        final int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);



        int cnt = 1;
        while (b > a) {
            if (b % 2 == 1 && b % 10 != 1) {
                System.out.println(-1);
                return;
            }

            if (b % 10 == 1) {
                b /= 10;
            } else {
                b /= 2;
            }
            cnt += 1;
        }

        System.out.println(a == b ? cnt : -1);
    }
}
