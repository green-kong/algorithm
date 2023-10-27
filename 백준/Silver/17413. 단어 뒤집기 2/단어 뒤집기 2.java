import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
//    baekjoon online judge

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] s = br.readLine().split("");

        boolean check = false;

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (final String s1 : s) {
            if (s1.equals("<")) {
                Collections.reverse(list);
                sb.append(String.join("", list));
                list.clear();
                list.add(s1);
                check = true;
                continue;
            }

            if (s1.equals(">")) {
                list.add(s1);
                sb.append(String.join("", list));
                list.clear();
                check = false;
                continue;
            }

            if (check && s1.isBlank()) {
                list.add(" ");
                continue;
            }

            if (!check && s1.isBlank()) {
                Collections.reverse(list);
                sb.append(String.join("", list));
                list.clear();
                sb.append(" ");
                continue;
            }

            list.add(s1);
        }
        if (!list.isEmpty()) {
            Collections.reverse(list);
            sb.append(String.join("", list));
        }
        System.out.println(sb);
    }
}
