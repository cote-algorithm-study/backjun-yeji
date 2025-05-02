import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Staff implements Comparable<Staff> {
        String name;
        double score;

        public Staff(String name, double score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Staff o) {
            return Double.compare(o.score, this.score); // 내림차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int participants = Integer.parseInt(br.readLine());
        int staffCount = Integer.parseInt(br.readLine());

        List<Staff> validStaffs = new ArrayList<>();
        Map<String, Integer> result = new HashMap<>();
        long threshold = participants * 5L;

        for (int i = 0; i < staffCount; i++) {
            String[] info = br.readLine().split(" ");
            String name = info[0];
            int vote = Integer.parseInt(info[1]);

            if ((long) vote * 100 >= threshold) {
                validStaffs.add(new Staff(name, vote));
                result.put(name, 0); // 칩 수 초기화
            }
        }

        PriorityQueue<Staff> pq = new PriorityQueue<>();
        for (Staff s : validStaffs) {
            for (int i = 1; i <= 14; i++) {
                pq.offer(new Staff(s.name, s.score / (double)i));
            }
        }

        for (int i = 0; i < 14 && !pq.isEmpty(); i++) {
            Staff top = pq.poll();
            result.put(top.name, result.getOrDefault(top.name, 0) + 1);
        }

        result.keySet().stream()
                .sorted()
                .forEach(name -> System.out.println(name + " " + result.get(name)));
    }
}