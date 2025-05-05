import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] compare = Arrays.stream(Arrays.copyOf(array, n)).distinct().sorted().toArray();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < compare.length; i++) {
            int target = compare[i];
            if (!map.containsKey(target)) {
                map.put(target, i);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            answer.append(map.get(array[i])).append(" ");
        }
        answer.append(map.get(array[n - 1]));
        System.out.println(answer);
    }

}