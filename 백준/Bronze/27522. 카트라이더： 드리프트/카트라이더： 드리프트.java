import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] raceResult = new String[8][4];

        for (int i = 0; i < 8; i++) {
            final String[] strings = new String[4];
            final String[] s = br.readLine().split(" ");
            final String[] split = s[0].split(":");
            strings[0] = split[0];
            strings[1] = split[1];
            strings[2] = split[2];
            strings[3] = s[1];
            raceResult[i] = strings;
        }

        Arrays.sort(raceResult, ((o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                if (o1[1].equals(o2[1])) {
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
            return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
        }));

        String first = "";
        int r = 0;
        int b = 0;

        for (int i = 0; i < raceResult.length; i++) {
            String team = raceResult[i][3];
            int score = 0;
            if (i == 0) {
                first = team.equals("R") ? "Red" : "Blue";
            }

            if(i == 0) {
                score = 10;
            } else if (i == 1) {
                score = 8;
            } else {
                score = 8 - i;
            }

            if(team.equals("R")) {
                r += score;
            }else {
                b += score;
            }
        }

        if (r == b) {
            System.out.println(first);
            return;
        }

        System.out.println(r > b ? "Red" : "Blue");
    }
}
