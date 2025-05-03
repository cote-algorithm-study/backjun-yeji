import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Person> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            Person person = new Person(s[1], Integer.parseInt(s[0]), i);
            priorityQueue.offer(person);
        }

        while (!priorityQueue.isEmpty()) {
            Person poll = priorityQueue.poll();
            System.out.println(poll.age + " " + poll.name);
        }

    }

    public static class Person implements Comparable<Person> {

        private String name;
        private int age;
        private int index;

        public Person(String name, int age, int index) {
            this.name = name;
            this.age = age;
            this.index = index;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age == o.age) {
                return this.index - o.index;
            }
            return this.age - o.age;
        }

    }

}