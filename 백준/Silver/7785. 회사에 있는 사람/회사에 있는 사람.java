import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String name = s[0];
            String status = s[1];

            if ("enter".equals(status)) {
                map.put(name, status);
            } else {
                map.remove(name);
            }
        }

        map.keySet().stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));

    }

}