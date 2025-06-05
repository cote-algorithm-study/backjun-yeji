import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/6236
 * 용돈관리
 */
public class Main {

    public static void main(String[] args)  {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int day = n[0];
            int[] s = new int[day];
            for(int i=0; i<day; i++){
                s[i] = Integer.parseInt(br.readLine());
            }
            int min = Arrays.stream(s).max().orElse(0);
            int max = Arrays.stream(s).sum();
            int result = 0;
            while(min <= max){
                int mid = (min + max) / 2;
                int sum = 0;
                int count = 1;
                for (int j : s) {
                    if (sum + j > mid) {
                        count++;
                        sum = j;
                    } else {
                        sum += j;
                    }
                }
                if(count > n[1]){
                    min = mid + 1;
                }else{
                    result = mid;
                    max = mid - 1;
                }
            }
            System.out.println(result);

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
