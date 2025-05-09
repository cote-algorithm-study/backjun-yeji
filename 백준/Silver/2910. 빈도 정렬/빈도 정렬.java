import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준. 10250
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Number> map = new Hashtable<>();
        for(int i=0; i<s.length; i++){
            if(map.containsKey(s[i])){
                map.get(s[i]).count++;
            }else{
                map.put(s[i], new Number(i, 1));
            }
        }

        map.keySet().stream().sorted(Comparator.comparingInt(key -> map.get(key).getCount()).reversed().thenComparingInt(key->map.get(key).getIndex())).forEach(key -> {
            Number number = map.get(key);
            for(int i=0; i<number.count; i++){
                System.out.print(key + " ");
            }
        });

    }

    private static class Number{

        int index;
        int count;

        private Number(int index, int count){
            this.index = index;
            this.count = count;
        }

        public int getCount(){
            return this.count;
        }

        public int getIndex(){
            return this.index;
        }
    }
}