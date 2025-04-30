import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준. 10250
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for(int i=0; i<total; i++){
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);

            int floor = n % h == 0 ? h : n % h;
            int room = (int) Math.ceil((double)n / h);
            String roomNumber = String.format("%d%02d", floor, room);
            System.out.println(roomNumber);
        }

    }
}