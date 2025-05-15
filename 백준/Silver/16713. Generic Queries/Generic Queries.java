import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = reader.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);

        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] prefixXor = new int[n + 1];  // prefixXor[0] = 0

        for (int i = 1; i <= n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ a[i - 1];
        }

        int[] countStart = new int[n + 2];
        int[] countEnd = new int[n + 2];

        for (int i = 0; i < q; i++) {
            String[] se = reader.readLine().split(" ");
            int s = Integer.parseInt(se[0]);
            int e = Integer.parseInt(se[1]);
            countStart[s]++;
            countEnd[e + 1]++;
        }

        int xorResult = 0;
        int active = 0;
        for (int i = 1; i <= n; i++) {
            active += countStart[i];
            if (active % 2 == 1) {
                xorResult ^= a[i - 1];
            }
            active -= countEnd[i + 1];
        }

        System.out.println(xorResult);
    }
}