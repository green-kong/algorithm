package org.example.set2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ19538 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] s = br.readLine().split(" ");
        final int start = Integer.parseInt(s[0].replace(":", ""));
        final int meetingEnd = Integer.parseInt(s[1].replace(":", ""));
        final int streamingEnd = Integer.parseInt(s[2].replace(":", ""));

        Set<String> startParticipants = new HashSet<>();
        Set<String> fullTimeParticipants = new HashSet<>();
        String line;
        while ((line = br.readLine()) != null) {
            final String[] s1 = line.split(" ");
            final int time = Integer.parseInt(s1[0].replace(":", ""));
            final String name = s1[1];

            if (time <= start) {
                startParticipants.add(name);
                continue;
            }

            if (time < meetingEnd) {
                continue;
            }

            if (time <= streamingEnd && startParticipants.contains(name)) {
                fullTimeParticipants.add(name);
            }

            if (time > streamingEnd) {
                break;
            }
        }

        System.out.println(fullTimeParticipants.size());
    }
}

//06:00 shinyo17
//        06:00 kimchist
//        06:00 swoon
//        06:00 kheee512
//        06:00 Green55

//12:00 kimchist
//        17:59 swoon
//        17:59 swoon
//        18:00 kheee512
