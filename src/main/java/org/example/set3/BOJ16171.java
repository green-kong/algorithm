package org.example.set3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16171 {
    public static void main(String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String s = br.readLine().replaceAll("\\d", "");
        System.out.println(s.contains(br.readLine()) ? 1 : 0);
    }
}
