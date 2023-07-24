import java.util.*;

public class Main {
    static int n;
    static int m;
    static int dx[] = {-1,1,0,0}; //방향 좌표
    static int dy[] = {0,0,1,-1};
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static int[][] visited;
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        for(int i=0; i<n; i++ ){
            String tmp = sc.next();
            for(int j=0; j<m; j++){
               arr[i][j] = tmp.charAt(j)-'0';
            }
        }
        System.out.print(solution());
    }

    private static int solution(){
        visited = new int[n][m];
        int answer = bfs();
        return answer;
    }

    private static int bfs(){
        Queue<Node> queue = new LinkedList<>();

        visited[0][0] = 1; //시작점 방문처리
        queue.add(new Node(0,0)); //시작점 노드에 담기

        while(!queue.isEmpty()){
            Node node = queue.poll(); //위치 꺼내기

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >=n || ny <0 || ny >= m) continue; //배열 범위를 벗어나면 그만두기
                if(arr[nx][ny] == 1 && visited[nx][ny] ==0) { //갈 수있고 방문한 적이 없다면

                    queue.add(new Node(nx, ny)); //큐에 넣기

                    visited[nx][ny] = visited[node.x][node.y] +1; //이전 출발지점에서 +1 이동시켜준다
                    //ex) 0,0출발 visited[0][0] =1 시작
                    // 다음칸 visited[0][1]으로 이동했으면 visited[0][1] = 2
                    // count로 하면 이동한 칸수 모두가 누적되서 count되니까 이동하는 길을 따라서 수를 높여주어야 한다

                }
            }
        }

        return visited[n-1][m-1];
    }
}
