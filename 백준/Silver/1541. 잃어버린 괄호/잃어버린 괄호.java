import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] s = br.readLine().split("-");

        List<Integer> ints = new ArrayList<>();

        for (final String s1 : s) {
            final String[] split = s1.split("\\+");
            int sum = 0;
            for (final String s2 : split) {
                sum += Integer.parseInt(s2);
            }
            ints.add(sum);
        }

        int sum = ints.get(0);
        for (int i = 1; i < ints.size(); i++) {
            sum -= ints.get(i);
        }
        System.out.println(sum);
    }
}
