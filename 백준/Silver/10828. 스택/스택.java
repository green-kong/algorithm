import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Integer> stack = new ArrayList<>();
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                stack.add(value);
                size++;
            } else if (command.equals("pop")) {
                if(size == 0){
                    System.out.println(-1);
                }else{
                Integer remove = stack.remove(stack.size() - 1);
                    size--;
                    System.out.println(remove);
                }
            } else if (command.equals("size")) {
                System.out.println(size);
            } else if (command.equals("empty")) {
                System.out.println(size > 0 ? 0 : 1);
            } else if (command.equals("top")) {
                if (size == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.get(size - 1));
                }
            }
        }
    }
}
