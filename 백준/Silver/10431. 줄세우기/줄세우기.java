import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                int[] students = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int testcase = students[0];
                System.out.println(testcase + " " + calculateSort(Arrays.copyOfRange(students, 1, students.length)));
            }
        }
    }

    /**
     * 정렬하기
     *
     * @param students
     * @return
     */
    private static int calculateSort(int[] students) {
        int count = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < i; j++) {
                if (students[i] < students[j]) {
                    count++;
                }
            }
        }

        return count;
    }

}