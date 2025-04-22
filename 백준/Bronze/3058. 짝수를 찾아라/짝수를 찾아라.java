import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                extracted(br);
            }
        }
    }

    private static void extracted(BufferedReader br) throws IOException {
        int[] evenNumbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).filter(s -> s % 2 == 0).toArray();
        System.out.println(Arrays.stream(evenNumbers).sum() + " " + Arrays.stream(evenNumbers).min().getAsInt());
    }

}