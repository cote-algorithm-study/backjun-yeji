import java.io.*;
import java.util.Arrays;

/**
 * 2751. 수 정렬하기 2
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 */
public class Main {

    // 1,2,3,4,5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 빠른 출력
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array); // Dual-Pivot QuickSort 사용

        for (int i = 0; i < n; i++) {
            bw.write(array[i] + "\n"); // 한 번에 출력
        }
        bw.flush(); // 출력 버퍼 비우기
        bw.close();
    }

}
