import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int limit = Integer.parseInt(br.readLine());

        if (limit == 0) {
            System.out.println(0);
            return;
        }

        final int first = 0;
        final int current = 1;

        System.out.println(func(first, current, limit, 1));
    }

    private static int func(final int before, final int current, final int limit, final int count) {
        if (count == limit) {
            return current;
        }

        return func(current, before + current, limit, count + 1);
    }
}
