import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());
            int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, Integer> map = new HashMap<>();

            for (int j : cards) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
            br.readLine();
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            StringBuffer sb = new StringBuffer();
            for(int a : array){
                sb.append(map.getOrDefault(a, 0)).append(" ");
            }
            System.out.println(sb);

        }catch (Exception e){}

    }
}