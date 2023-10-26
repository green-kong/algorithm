import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {
//    4

//    RDD
//    4
//    [1,2,3,4]

//    DD
//    1
//    [42]

//    RRD
//    6
//    [1,1,2,3,5,8]

    //    D
//    0
//    []

    static Deque<String> arr = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arr.clear();
            final String[] func = br.readLine().split("");
            final int m = Integer.parseInt(br.readLine());
            String s = br.readLine();
            final String[] s1 = s.replace("[", "").replace("]", "").replaceAll(",", " ").split(" ");
            for (int j = 0; j < s1.length; j++) {
                if(s1[j].isBlank()) {
                    continue;
                }
                arr.add(String.valueOf(s1[j]));
            }

            boolean reverse = false;
            boolean check = true;
            for (final String s2 : func) {
                if (s2.equals("R")) {
                    reverse = !reverse;
                }

                if (s2.equals("D")) {
                    if (arr.isEmpty()) {
                        check = false;
                        break;
                    }

                    if (reverse) {
                        arr.removeLast();
                    } else {
                        arr.removeFirst();
                    }
                }
            }

            if (check) {
                List<String> result = new ArrayList<>(arr);
                if(reverse) {
                    Collections.reverse(result);
                }
                final String join = String.join(",", result);
                System.out.printf("[%s]%n", join);
            } else {
                System.out.println("error");
            }

        }
    }

    public static boolean delete() {
        if (arr.isEmpty()) {
            return false;
        }
        arr.removeFirst();
        return true;
    }
}
