import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] U = new int[N];
        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(U);
        Set<Integer> sumSet = new HashSet<>();

        // 두 수의 합을 모두 구해 저장
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sumSet.add(U[i] + U[j]);
            }
        }

        // d를 큰 수부터 탐색
        for (int k = N - 1; k >= 0; k--) {
            for (int z = 0; z < N; z++) {
                int diff = U[k] - U[z];
                if (sumSet.contains(diff)) {
                    System.out.println(U[k]);
                    return;
                }
            }
        }
    }
}
