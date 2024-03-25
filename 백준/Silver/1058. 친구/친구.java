import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            final String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            final HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'Y') {
                    set.add(j);
                    for (int k = 0; k < n; k++) {
                        if (k == i) {
                            continue;
                        }
                        if (arr[k][j] == 'Y' && arr[i][k] != 'Y') {
                            set.add(k);
                        }
                    }
                }
            }
            answer = Math.max(answer, set.size());
        }
        System.out.println(answer);
    }
}
