import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length -1; i++) {
                final String s = phone_book[i];
                final String s1 = phone_book[i + 1];
                if (s1.startsWith(s)) {
                    return false;
                }
            }
        return true;
    }
}