import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

    static int n;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}; // U D L R
    static int[] dy = {0, 0, -1, 1};
    static int x, y;
    static Map<String, Integer> directions = Map.of("U", 0, "D", 1, "L", 2, "R", 3);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] moves = br.readLine().split("");

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = '.';
            }
        }

        x = 0;
        y = 0;

        for (String move : moves) {
            if (move.isBlank())
                continue;

            int dir = directions.get(move);
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            draw(x, y, dir);
            x = nx;
            y = ny;
            draw(x, y, dir);
        }

        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            for (char c : row) {
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void draw(int x, int y, int dir) {
        if (x < 0 || x >= n || y < 0 || y >= n)
            return;

        if (dir == 0 || dir == 1) {
            if (map[x][y] == '-') {
                map[x][y] = '+';
            } else if (map[x][y] == '.') {
                map[x][y] = '|';
            }
        } else if (dir == 2 || dir == 3) {
            if (map[x][y] == '|') {
                map[x][y] = '+';
            } else if (map[x][y] == '.') {
                map[x][y] = '-';
            }
        }
    }

}