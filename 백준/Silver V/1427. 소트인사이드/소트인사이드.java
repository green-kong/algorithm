import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String s = br.readLine();
        final String[] split = s.split("");
        Arrays.sort(split, Comparator.reverseOrder());
        System.out.println(String.join("", split));
    }
}
