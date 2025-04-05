import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> array = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();

        int max = 0;
        String result = "";
        for (int i = 0; i < array.size(); i++) {
            String upperCase = array.get(i).toUpperCase();
            map.put(upperCase, map.getOrDefault(upperCase, 0) + 1);
        }

        for (String s : map.keySet()) {
            Integer target = map.get(s);
            if (max < target) {
                max = target;
                result = s;
            } else if (max == target) {
                result = "?";
            }
        }

        System.out.println(result);
    }

}