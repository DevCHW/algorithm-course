import java.util.*;

public class 토마토_7576  {

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt(); // 가로 크기
        N = sc.nextInt(); // 세로 크기
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int days = BFS();

        boolean check = true;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0){
                    check = false;
                }
            }
        }

        if(check){
            System.out.println(days);
        } else {
            System.out.println(-1);
        }

    }


    public static int BFS(){
        Queue<Point> q = new LinkedList<>();

        for (int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if (arr[i][j] == 1){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }

        int days = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                Point current = q.poll();
                int x = current.x;
                int y = current.y;

                for(int j=0; j<4; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == -1 || visited[nx][ny]){
                        continue;
                    }

                    q.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                    arr[nx][ny] = 1; // 토마토 익었음

                }
            }

            if(!q.isEmpty()) { // 하루가 지났을 경우
                days++;
            }
        }
        return days;
    }

}
