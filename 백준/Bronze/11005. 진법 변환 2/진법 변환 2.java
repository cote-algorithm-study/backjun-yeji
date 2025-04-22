import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 60466175 36
 */
public class Main {

    private static final Map<Integer, String> map =
            IntStream.rangeClosed(10, 35)
                    .boxed()
                    .collect(Collectors.toMap(
                            i -> i,
                            i -> String.valueOf((char) ('A' + (i - 10)))
                    ));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int target = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        StringBuilder sb = new StringBuilder();

        while (target > 0) {
            int r = target % n;
            sb.append(r >= 10 ? map.get(r) : r);
            target /= n;
        }

        System.out.println(sb.reverse());
    }
}