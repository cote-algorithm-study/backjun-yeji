import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        int[] ground = new int[N + 2]; 

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            ground[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[N + 2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            diff[a] += k;
            diff[b + 1] -= k;
        }

        int acc = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            acc += diff[i];
            sb.append(ground[i] + acc).append(" ");
        }

        System.out.println(sb);
    }
}