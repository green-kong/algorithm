import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        Arrays.sort(strings, ((o1, o2) -> {
            final int fLen = o1.length();
            final int sLen = o2.length();
            if (fLen == sLen) {
                final int fSum = getSum(o1);
                final int sSum = getSum(o2);
                if (fSum == sSum) {
                    for (int i = 0; i < fLen; i++) {
                        final char c1 = o1.charAt(i);
                        final char c2 = o2.charAt(i);
                        final int numericValue1 = Character.getNumericValue(c1);
                        final int numericValue2 = Character.getNumericValue(c2);
                        if (numericValue1 == numericValue2) {
                            continue;
                        }
                        return numericValue1 - numericValue2;
                    }
                }
                return fSum - sSum;
            }
            return fLen - sLen;
        }));
        System.out.println(String.join("\n", strings));
    }

    private static int getSum(final String o1) {
        int cnt = 0;
        for (int i = 0; i < o1.length(); i++) {
            try {
                final int val = Integer.parseInt(String.valueOf(o1.charAt(i)));
                cnt += val;
            } catch (NumberFormatException e) {
            }
        }
        return cnt;
    }
}
