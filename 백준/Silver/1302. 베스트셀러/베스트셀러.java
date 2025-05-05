import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new LinkedHashMap<>();
        Queue<Book> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            Book book = new Book(key, map.get(key));
            queue.offer(book);
        }

        if (!queue.isEmpty()) {
            System.out.println(queue.poll().name);
        }

    }

    public static class Book implements Comparable<Book> {

        private String name;
        private Integer count;

        public Book(String name, Integer count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Book o) {
            if (this.count == o.count) {
                return name.compareTo(o.name);
            }
            return o.count - this.count;
        }

    }

}