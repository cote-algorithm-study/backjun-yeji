import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]); 

        String[] wheel = new String[N];
        Arrays.fill(wheel, "?");

        Set<String> used = new HashSet<>();
        int pointer = 0;

        for (int i = 0; i < K; i++) {
            String[] cmd = br.readLine().split(" ");
            int move = Integer.parseInt(cmd[0]);
            String ch = cmd[1];

            pointer = (pointer + move) % N;

            if (!wheel[pointer].equals("?") && !wheel[pointer].equals(ch)) {
                System.out.println("!");
                return;
            }

            if (wheel[pointer].equals("?") && used.contains(ch)) {
                System.out.println("!");
                return;
            }

            wheel[pointer] = ch;
            used.add(ch);
        }

        // 역순으로 출력
        for (int i = 0; i < N; i++) {
            System.out.print(wheel[pointer]);
            pointer = (pointer - 1 + N) % N;
        }
    }

}